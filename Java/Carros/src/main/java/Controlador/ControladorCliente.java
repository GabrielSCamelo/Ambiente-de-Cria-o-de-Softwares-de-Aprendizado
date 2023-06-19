package Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Modelo.Cliente;

import java.util.List;

@Controller
public class ControladorCliente<clienteRepository, ClienteRepository> {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ControladorCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/registro")
    public String exibirFormularioRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarCliente(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("senha") String senha,
                                   Model model) {
       
        Cliente cliente = new Cliente(nome, email, telefone, senha);
        model.addAttribute("cliente", cliente);
        
        return "redirect:/confirmacao";
    }
    
    @PostMapping("/confirmacao")
    public String confirmarRegistro(@RequestParam("confirmacao") String confirmacao) {
        if (confirmacao.equals("confirmar")) {
            // Manter dados e enviar para página de registro sucesso
            return "registradoSucesso";
        } else {
            // Exclusão de dados
            return "registro";
        }
    }
    
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = ((Cliente) clienteRepository).findAll();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }
}

