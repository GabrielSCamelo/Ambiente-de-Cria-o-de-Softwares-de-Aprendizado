package Project.Api.Emprestimo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Funcionario;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Long> {
    
    List<Contratos> findByFuncionario(Funcionario funcionario);

    Contratos findByCodcontrato(String codcontrato);

    @Query("SELECT COUNT(c) FROM Contratos c")
    Long countContratos();
    
}
