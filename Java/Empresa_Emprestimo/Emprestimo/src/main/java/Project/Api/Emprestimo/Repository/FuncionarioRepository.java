package Project.Api.Emprestimo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

	Funcionario findByCodfuncionario(String codFuncionario);
}

