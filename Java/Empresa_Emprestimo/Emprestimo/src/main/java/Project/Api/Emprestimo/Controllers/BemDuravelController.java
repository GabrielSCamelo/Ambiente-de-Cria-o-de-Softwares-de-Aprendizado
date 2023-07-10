package Project.Api.Emprestimo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Project.Api.Emprestimo.Model.BemDuravel;
import Project.Api.Emprestimo.Service.BemDuravelService;

@RestController
@RequestMapping("/bemDuraveis")
public class BemDuravelController {

    private final BemDuravelService bemDuravelService;

    @Autowired
    public BemDuravelController(BemDuravelService bemDuravelService) {
        this.bemDuravelService = bemDuravelService;
    }

    @GetMapping
    public Iterable<BemDuravel> listarBemDuraveis() {
        return bemDuravelService.listarBemDuraveis();
    }
    
    @GetMapping("/contrato/{codContrato}")
    public List<BemDuravel> listarBemDuraveisPorContrato(@PathVariable String codContrato) {
        return bemDuravelService.listarBemDuraveisPorContrato(codContrato);
    }

    @PostMapping
    public BemDuravel registrarBemDuravel(@RequestBody BemDuravel bemDuravel) {
        return bemDuravelService.registrarBemDuravel(bemDuravel);
    }

    @PutMapping("/{id}")
    public BemDuravel atualizarBemDuravel(@PathVariable Long id, @RequestBody BemDuravel bemDuravel) {
        return bemDuravelService.atualizarBemDuravel(id, bemDuravel);
    }
}
