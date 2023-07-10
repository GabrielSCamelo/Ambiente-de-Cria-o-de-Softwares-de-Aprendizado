package Project.Api.Emprestimo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Vendedor;
import Project.Api.Emprestimo.Repository.VendedorRepository;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    @Autowired
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public Vendedor registrarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public Iterable<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }

    public Vendedor buscarVendedorPorCod(String codVendedor) {
        return vendedorRepository.findByCodvendedor(codVendedor);
    }

    public Vendedor atualizarVendedor(String codVendedor, Vendedor vendedor) {
        Vendedor vendedorExistente = vendedorRepository.findByCodvendedor(codVendedor);
        if (vendedorExistente == null) {
            throw new RuntimeException("Vendedor não encontrado");
        }

        vendedorExistente.setNome(vendedor.getNome());
        vendedorExistente.setAnoentrada(vendedor.getAnoentrada());
        vendedorExistente.setAnosaida(vendedor.getAnosaida());
        vendedorExistente.setAnonascimento(vendedor.getAnonascimento());
        vendedorExistente.setVedComissão(vendedor.getVedComissão());

        return vendedorRepository.save(vendedorExistente);
    }
}
