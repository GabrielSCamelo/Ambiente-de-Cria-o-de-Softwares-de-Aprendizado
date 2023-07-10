package Project.Api.Emprestimo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Empresa;
import Project.Api.Emprestimo.Model.Vendedor;
import Project.Api.Emprestimo.Service.ComissaoService;
import Project.Api.Emprestimo.Service.ContratosServiceImpl;
import Project.Api.Emprestimo.Service.EmpresaService;
import Project.Api.Emprestimo.Service.VendedorService;

@RestController
@RequestMapping("/comissoes")
public class ComissaoController {

    private final ComissaoService comissaoService;
    private final VendedorService vendedorService;
    private final EmpresaService empresaService;
    private final ContratosServiceImpl contratosService;

    @Autowired
    public ComissaoController(ComissaoService comissaoService, VendedorService vendedorService,
                              EmpresaService empresaService, ContratosServiceImpl contratosService) {
        this.comissaoService = comissaoService;
        this.vendedorService = vendedorService;
        this.empresaService = empresaService;
        this.contratosService = contratosService;
    }

    @GetMapping("/calcular/{cnpj}/{codVendedor}")
    public double calcularComissoes(@PathVariable String cnpj, @PathVariable String codVendedor) {
        Empresa empresa = empresaService.buscarEmpresaPorCnpj(cnpj);
        Vendedor vendedor = vendedorService.buscarVendedorPorCod(codVendedor);

        if (empresa == null) {
            throw new RuntimeException("Empresa não encontrada.");
        }

        if (vendedor == null) {
            throw new RuntimeException("Vendedor não encontrado.");
        }

        double comissaoVendedorTotal = vendedor.getVedComissão();
        double comissaoEmpresaTotal = empresa.getEmpComissão();

        Iterable<Contratos> contratos = contratosService.listarContratosPorEmpresaEVendedor(cnpj, codVendedor);

        for (Contratos contrato : contratos) {
            double comissaoVendedor = comissaoService.calcularComissaoVendedor(vendedor, contrato);
            double comissaoEmpresa = comissaoService.calcularComissaoEmpresa(empresa, contrato);

            comissaoVendedorTotal += comissaoVendedor;
            comissaoEmpresaTotal += comissaoEmpresa;
        }

        System.out.println("Comissão total do vendedor: " + comissaoVendedorTotal);
        System.out.println("Comissão total da empresa: " + comissaoEmpresaTotal);

        return comissaoVendedorTotal + comissaoEmpresaTotal;
    }
}