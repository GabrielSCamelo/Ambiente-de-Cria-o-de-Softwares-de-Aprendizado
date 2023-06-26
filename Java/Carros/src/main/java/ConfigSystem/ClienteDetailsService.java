package ConfigSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Modelo.Cliente;
import Repositorio.RepositorioCliente;

@Service
public class ClienteDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioCliente repositoriocliente;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = repositoriocliente.findByNome(username);
        if (cliente == null) {
            throw new UsernameNotFoundException("Cliente não encontrado: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(cliente.getNome())
                .password(cliente.getSenha())
                .roles(cliente.isAdmin() ? "ADMIN" : "USER")
                .build();
    }
}

