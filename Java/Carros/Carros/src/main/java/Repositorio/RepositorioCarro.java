package Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Modelo.Carro;

@Repository
public interface RepositorioCarro extends JpaRepository<Carro, Long> {
    
}