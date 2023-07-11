package Project.Api.Emprestimo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listar")
    public Iterable<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @GetMapping("/busca/{cnpj}")
    public ResponseEntity<Empresa> buscarEmpresaPorCnpj(@RequestParam("cnpj") String cnpj) {
        Empresa empresa = empresaService.buscarEmpresaPorCnpj(cnpj);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public ResponseEntity<Empresa> criarEmpresa(@RequestParam("cnpj") String cnpj,
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao) {
    	
			Empresa empresaExistente = empresaService.buscarEmpresaPorCnpj(cnpj);
			if (empresaExistente != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
			
			try {
			Empresa novaEmpresa = empresaService.registrarEmpresa(cnpj, nome, descricao);
			return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
			} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

    
    @PutMapping("/atualizar/{cnpj}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable String cnpj, @RequestBody Empresa empresa) {
        try {
            Empresa empresaAtualizada = empresaService.atualizarEmpresa(cnpj, empresa);
            if (empresaAtualizada != null) {
                return ResponseEntity.ok(empresaAtualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletar/{cnpj}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable String cnpj) {
        try {
            boolean empresaExcluida = empresaService.excluirEmpresa(cnpj);
            if (empresaExcluida) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

