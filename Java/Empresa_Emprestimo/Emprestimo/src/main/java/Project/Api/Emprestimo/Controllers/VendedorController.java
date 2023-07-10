package Project.Api.Emprestimo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.Api.Emprestimo.Model.Vendedor;
import Project.Api.Emprestimo.Service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public Iterable<Vendedor> listarVendedores() {
        return vendedorService.listarVendedores();
    }

    @GetMapping("/{codVendedor}")
    public Vendedor buscarVendedorPorCod(@PathVariable String codVendedor) {
        return vendedorService.buscarVendedorPorCod(codVendedor);
    }
}
