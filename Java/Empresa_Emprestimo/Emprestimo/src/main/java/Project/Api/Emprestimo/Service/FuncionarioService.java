package Project.Api.Emprestimo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Funcionario;
import Project.Api.Emprestimo.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorCod(String codFuncionario) {
        return funcionarioRepository.findByCodfuncionario(codFuncionario);
    }

    public Funcionario registrarFuncionario(Funcionario funcionario) {
        // Verificar se o funcionário já está registrado pelo CodFuncionario
        Funcionario funcionarioExistente = funcionarioRepository.findByCodfuncionario(funcionario.getCodfuncionario());
        if (funcionarioExistente != null) {
            throw new RuntimeException("O funcionário já está registrado.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(String codFuncionario, Funcionario funcionario) {
        // Verificar se o funcionário existe
        Funcionario funcionarioExistente = funcionarioRepository.findByCodfuncionario(codFuncionario);
        if (funcionarioExistente == null) {
            throw new RuntimeException("O funcionário não existe.");
        }

        // Atualizar as características do funcionário
        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setSalario(funcionario.getSalario());
        funcionarioExistente.setAnoentrada(funcionario.getAnoentrada());
        funcionarioExistente.setAnosaida(funcionario.getAnosaida());
        funcionarioExistente.setAnonascimento(funcionario.getAnonascimento());

        return funcionarioRepository.save(funcionarioExistente);
    }
    
    public void apagarFuncionario(String codFuncionario) {
        Funcionario funcionario = funcionarioRepository.findByCodfuncionario(codFuncionario);
        if (funcionario == null) {
            throw new RuntimeException("O funcionário não existe.");
        }
        funcionarioRepository.delete(funcionario);
    }
}
