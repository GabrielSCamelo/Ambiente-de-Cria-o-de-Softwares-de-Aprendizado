package Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Modelo.Aluguel;

@Repository
public interface RepositorioAluguel extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findAll();
}
