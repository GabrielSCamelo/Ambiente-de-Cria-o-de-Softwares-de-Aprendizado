package Project.Api.Emprestimo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

}


