package Project.Api.Emprestimo.Controllers;

import java.time.LocalDate;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Funcionario;
import Project.Api.Emprestimo.Model.Vendedor;
import Project.Api.Emprestimo.Service.ContratosServiceImpl;
import Project.Api.Emprestimo.Service.FuncionarioService;

public class ContratosController {

    private final FuncionarioService funcionarioService;
    private final ContratosServiceImpl contratosService;

    public ContratosController(FuncionarioService funcionarioService, ContratosServiceImpl contratosService) {
        this.funcionarioService = funcionarioService;
        this.contratosService = contratosService;
    }

    @GetMapping("/contratos/{funcionarioCod}")
    public String listarContratosFuncionario(@PathVariable("funcionarioCod") String funcionarioCod, Model model) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCod(funcionarioCod);
        if (funcionario == null) {
            // Tratar o caso em que o funcionário não foi encontrado
            // Por exemplo, redirecionar para uma página de erro
            return "ERRO - Funcionario Não Encontrado";
        }

        model.addAttribute("funcionario", funcionario);
        model.addAttribute("contratos", contratosService.listarContratosPorFuncionario(funcionario));

        return "listaContratos";
    }

    @GetMapping("/contratos/{codContrato}")
    public String buscarContratoPorCod(@PathVariable("codContrato") String codContrato, Model model) {
        Contratos contrato = contratosService.buscarContratoPorCodContrato(codContrato);
        if (contrato == null) {
            // Tratar o caso em que o contrato não foi encontrado
            // Por exemplo, redirecionar para uma página de erro
            return "ERRO - Contrato Inexistente";
        }

        model.addAttribute("contrato", contrato);

        return "detalhesContrato";
    }

    @PostMapping("/contratos/Criar")
    public String criarContrato(@RequestParam("funcionarioCod") String funcionarioCod,
                                @RequestParam("vendedorCod") String vendedorCod,
                                @RequestParam("parcelas") int parcelas,
                                @RequestParam("valorParcela") double valorParcela,
                                @RequestParam("juros") double juros) throws Exception {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCod(funcionarioCod);
        Vendedor vendedor = Vendedor.buscarVendedorPorCod(vendedorCod);

        if (funcionario == null || vendedor == null) {
            // Tratar o caso em que o funcionário ou vendedor não foi encontrado
            // Por exemplo, redirecionar para uma página de erro
            return "ERRO - Vendedor ou Funcionario Não Encontrado";
        }

        try {
            contratosService.criarContrato(funcionario, LocalDate.now(), vendedor, parcelas, valorParcela, juros, null);
        } catch (RuntimeException e) {
            return "ERRO - Contrato Não Foi Fechado Com Sucesso";
        }

        // Redirecionar para a página de sucesso ou exibir uma mensagem de sucesso
        return "O Contrato Foi Fechado Com Sucesso";
    }
}

