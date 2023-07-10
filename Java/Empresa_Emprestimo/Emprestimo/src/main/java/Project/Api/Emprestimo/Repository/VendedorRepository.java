package Project.Api.Emprestimo.Repository;

import org.springframework.stereotype.Repository;
import Project.Api.Emprestimo.Model.Vendedor;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {

    Vendedor findByCodvendedor(String codvendedor);
}

