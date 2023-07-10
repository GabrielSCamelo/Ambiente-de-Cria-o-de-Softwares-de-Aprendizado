package Project.Api.Emprestimo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Project.Api.Emprestimo.Model.Empresa;
import Project.Api.Emprestimo.Service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public Iterable<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @GetMapping("/{cnpj}")
    public Empresa buscarEmpresaPorCnpj(@PathVariable String cnpj) {
        return empresaService.buscarEmpresaPorCnpj(cnpj);
    }
    
    @PostMapping
    public Empresa registrarEmpresa(@RequestBody Empresa empresa) {
    	return empresaService.registrarEmpresa(empresa); 
        
    }
    
    @PutMapping("/{cnpj}")
    public Empresa atualizarEmpresa(@PathVariable String cnpj, @RequestBody Empresa empresa) {
        return empresaService.atualizarEmpresa(cnpj, empresa);
    }

    @DeleteMapping("/{cnpj}")
    public void excluirEmpresa(@PathVariable String cnpj) {
        empresaService.excluirEmpresa(cnpj);
    }
}

