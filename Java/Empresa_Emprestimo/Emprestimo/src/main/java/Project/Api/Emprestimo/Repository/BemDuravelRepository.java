package Project.Api.Emprestimo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.BemDuravel;

@Repository
public interface BemDuravelRepository extends JpaRepository<BemDuravel, Long> {

	Optional<BemDuravel> findById(Long id);

}
