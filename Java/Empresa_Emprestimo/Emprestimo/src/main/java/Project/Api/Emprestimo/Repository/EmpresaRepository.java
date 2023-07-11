package Project.Api.Emprestimo.Repository;

import Project.Api.Emprestimo.Model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByCnpj(String CNPJ);
    
}
