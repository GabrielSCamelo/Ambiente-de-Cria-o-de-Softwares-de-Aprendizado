package Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Modelo.Cliente;
import Repositorio.RepositorioCliente;

import java.util.List;

@Controller
public class ControladorLogin {

    private final RepositorioCliente repositorioCliente;

    @Autowired
    public ControladorLogin(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuário ou senha inválidos");
        }
        return "Authenticação/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/Authenticação/TimeOut.html";
    }

    @GetMapping("/authenticar-usuario")
    public String autenticarUsuario(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        List<Cliente> clientes = repositorioCliente.findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(username) && cliente.getSenha().equals(password)) {
                // Autenticação bem-sucedida
            	return "redirect:/Usuarios/Usuario.html";
            }
        }
        
        // Autenticação falhou
        model.addAttribute("error", "Usuário ou senha inválidos");
        return "Login.html";
    }

}

