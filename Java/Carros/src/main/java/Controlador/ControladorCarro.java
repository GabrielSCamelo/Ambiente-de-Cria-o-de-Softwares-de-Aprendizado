package Controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Modelo.Carro;
import Repositorio.RepositorioCarro;

@RestController
@RequestMapping("/carros")
public class ControladorCarro {
    private final RepositorioCarro repositorioCarro;

    @Autowired
    public ControladorCarro(RepositorioCarro repositorioCarro) {
        this.repositorioCarro = repositorioCarro;
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return repositorioCarro.findAll();
    }
}