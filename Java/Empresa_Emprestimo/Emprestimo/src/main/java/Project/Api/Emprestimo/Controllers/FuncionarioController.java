package Project.Api.Emprestimo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Project.Api.Emprestimo.Model.Funcionario;
import Project.Api.Emprestimo.Service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public Iterable<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{codFuncionario}")
    public Funcionario buscarFuncionarioPorCod(@PathVariable("codFuncionario") String codFuncionario) {
        return funcionarioService.buscarFuncionarioPorCod(codFuncionario);
    }

    @PostMapping
    public Funcionario registrarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.registrarFuncionario(funcionario);
    }

    @PutMapping("/{codFuncionario}")
    public Funcionario atualizarFuncionario(@PathVariable("codFuncionario") String codFuncionario,
            @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(codFuncionario, funcionario);
    }
    
    @DeleteMapping("/{codFuncionario}")
    public void apagarFuncionario(@PathVariable("codFuncionario") String codFuncionario) {
        funcionarioService.apagarFuncionario(codFuncionario);
    }
}

