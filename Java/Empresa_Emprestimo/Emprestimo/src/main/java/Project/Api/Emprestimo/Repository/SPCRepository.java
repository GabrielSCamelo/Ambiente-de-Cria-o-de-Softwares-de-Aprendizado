package Project.Api.Emprestimo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Api.Emprestimo.Model.SPC;

@Repository
public interface SPCRepository extends JpaRepository<SPC, Long> {
    SPC findByCodSPC(String codSPC);
}
