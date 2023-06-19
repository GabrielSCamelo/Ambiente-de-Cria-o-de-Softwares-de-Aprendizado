package Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Modelo.Carro;
import Repositorio.RepositorioCarro;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class ControladorCarro {
    private final RepositorioCarro repositorioCarro;

    @Autowired
    public ControladorCarro(RepositorioCarro repositorioCarro) {
        this.repositorioCarro = repositorioCarro;
    }

    @PostMapping("/salvar")
    public Carro salvarCarro(@RequestBody Carro carro) {
        return repositorioCarro.save(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
        Optional<Carro> carroExistente = repositorioCarro.findById(id);
        if (carroExistente.isPresent()) {
            Carro carro = carroExistente.get();
            carro.setMarca(carroAtualizado.getMarca());
            carro.setModelo(carroAtualizado.getModelo());

            Carro carroAtualizado1 = repositorioCarro.save(carro);
            return ResponseEntity.ok(carroAtualizado1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        Optional<Carro> carro = repositorioCarro.findById(id);
        if (carro.isPresent()) {
            repositorioCarro.delete(carro.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/lista")
    public List<Carro> listarCarros() {
        return repositorioCarro.findAll();
    }

    @GetMapping("/listar")
    public String listarCarrosFiltrados(
            @RequestParam(value = "modelo", required = false) String modelo,
            @RequestParam(value = "data", required = false) Date data,
            @RequestParam(value = "valor", required = false) Double valor,
            Model model
    ) {
        List<Carro> carros;
        if (modelo != null) {
            carros = repositorioCarro.findByModelo(modelo);
        } else if (data != null) {
            carros = repositorioCarro.findByDataLocacao(data);
        } else if (valor != null) {
            carros = repositorioCarro.findByValorLocacao(valor);
        } else {
            carros = repositorioCarro.findAll();
        }
        model.addAttribute("carros", carros);
        return "listarCarros";
    }
}
