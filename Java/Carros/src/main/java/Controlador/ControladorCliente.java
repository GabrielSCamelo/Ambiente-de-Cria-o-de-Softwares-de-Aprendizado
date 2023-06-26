package Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Modelo.Cliente;
import Repositorio.RepositorioCliente;

@Controller
public class ControladorCliente {

    private final RepositorioCliente clienteRepository;

    @Autowired
    public ControladorCliente(RepositorioCliente clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/cliente/inserir")
    public String exibirFormularioRegistro() {
        return "formularioRegistro";
    }

    @PostMapping("/cliente/inserir")
    public String registrarCliente(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("senha") String senha) {

        Cliente cliente = new Cliente(nome, email, telefone, senha, false);
        clienteRepository.save(cliente);

        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/listar")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }
    
    @GetMapping("/cliente/confirmar/{id}")
    public String exibirConfirmacaoRegistro(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            model.addAttribute("cliente", cliente);
            return "confirmacaoRegistro";
        } else {
            return "redirect:/cliente/listar";
        }
    }

    @GetMapping("/cliente/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            model.addAttribute("cliente", cliente);
            return "formularioEdicao";
        } else {
            return "redirect:/cliente/listar";
        }
    }

    @PostMapping("/cliente/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id,
                                @RequestParam(value = "nome", required = false) String nome,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "telefone", required = false) String telefone,
                                @RequestParam(value = "senha", required = false) String senha) {

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            if (nome != null) {
                cliente.setNome(nome);
            }
            if (email != null) {
                cliente.setEmail(email);
            }
            if (telefone != null) {
                cliente.setTelefone(telefone);
            }
            if (senha != null) {
                cliente.setSenha(senha);
            }
            clienteRepository.save(cliente);
        }

        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/apagar/{id}")
    public String apagarCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/cliente/listar";
    }
}