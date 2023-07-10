package Project.Api.Emprestimo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.BemDuravel;

@Repository
public interface BemDuravelRepository extends CrudRepository<BemDuravel, Long> {

	Optional<BemDuravel> findById(Long id);

}
