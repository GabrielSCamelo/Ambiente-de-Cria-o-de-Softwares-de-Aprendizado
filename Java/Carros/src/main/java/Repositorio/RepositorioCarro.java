package Repositorio;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Modelo.Carro;

@Repository
public interface RepositorioCarro extends JpaRepository<Carro, Long> {

    // Buscar todos os carros
    List<Carro> findAll();

    // Buscar carros por modelo
    List<Carro> findByModelo(String modelo);

    // Buscar carros por data de locação
    List<Carro> findByDataLocacao(Date dataLocacao);

    // Buscar carros por valor de locação
    List<Carro> findByValorLocacao(double valorLocacao);

    // Buscar carros por modelo, data de locação e valor de locação
    @Query("SELECT c FROM Carro c WHERE c.modelo = :modelo AND c.dataLocacao = :dataLocacao AND c.valorLocacao = :valorLocacao")
    List<Carro> findByModeloDataValorLocacao(@Param("modelo") String modelo, @Param("dataLocacao") Date dataLocacao, @Param("valorLocacao") double valorLocacao);
}
