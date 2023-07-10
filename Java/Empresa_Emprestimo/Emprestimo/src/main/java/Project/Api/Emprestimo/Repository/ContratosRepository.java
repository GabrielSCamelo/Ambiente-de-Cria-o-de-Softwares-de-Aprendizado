package Project.Api.Emprestimo.Repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Funcionario;

@Repository
public interface ContratosRepository extends CrudGenericRepository<Contratos, Long> {
    
	List<Contratos> findByFuncionario(Funcionario funcionario);

	Long findMaxId();

	Contratos findByCodcontrato(String codContrato);

	Iterable<Contratos> findByEmpresaCnpjAndVendedorCodVendedor(String cnpj, String codVendedor);
}
