package Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Modelo.Aluguel;
import Repositorio.RepositorioAluguel;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ControladorAluguel {

    @Autowired
    private RepositorioAluguel aluguelRepository;

    @PostMapping("/aluguel/inserir")
    public String inserirAluguel(@RequestParam("dataInicio") LocalDateTime dataInicio,
                                 @RequestParam("dataFim") LocalDateTime dataFim,
                                 @RequestParam("valorTotal") double valorTotal,
                                 @RequestParam("nomePessoa") String nomePessoa,
                                 @RequestParam("idCarro") Long idCarro) {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataInicio(dataInicio);
        aluguel.setDataFim(dataFim);
        aluguel.setValorTotal(valorTotal);
        aluguel.setNomePessoa(nomePessoa);
        aluguel.setIdCarro(idCarro);

        aluguelRepository.save(aluguel);

        return "redirect:/aluguel/listar";
    }

    @GetMapping("/aluguel/listar")
    public String listarAlugueis(Model model) {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        model.addAttribute("alugueis", alugueis);
        return "listarAlugueis";
    }
}