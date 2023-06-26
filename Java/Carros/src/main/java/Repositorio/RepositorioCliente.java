package Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Modelo.Cliente;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findAll();

	Cliente findByNome(String username);
    
}
