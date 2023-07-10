package Project.Api.Emprestimo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Empresa;
import Project.Api.Emprestimo.Repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Iterable<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa buscarEmpresaPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj);
    }
    
    public Empresa registrarEmpresa(Empresa empresa) {
        // Verificar se a empresa já está registrada pelo CNPJ
        Empresa empresaExistente = empresaRepository.findByCnpj(empresa.getCnpj());
        if (empresaExistente != null) {
            throw new RuntimeException("A empresa já está registrada.");
        }

        // Configurar as características da empresa
        empresa.setDescrição(empresa.getDescrição());
        empresa.setNome(empresa.getNome());
        empresa.setCnpj(empresa.getCnpj());
        empresa.setEmpComissão(empresa.getEmpComissão());

        return empresaRepository.save(empresa);
    }

    public Empresa atualizarEmpresa(String cnpj, Empresa empresa) {
        // Verificar se a empresa existe
        Empresa empresaExistente = empresaRepository.findByCnpj(cnpj);
        if (empresaExistente == null) {
            throw new RuntimeException("A empresa não existe.");
        }
        
        // Atualizar as características da empresa
        empresaExistente.setDescrição(empresa.getDescrição());
        empresaExistente.setNome(empresa.getNome());
        empresaExistente.setCnpj(empresa.getCnpj());
        empresaExistente.setEmpComissão(empresa.getEmpComissão());

        return empresaRepository.save(empresaExistente);
    }

    public void excluirEmpresa(String cnpj) {
        // Verificar se a empresa existe
        Empresa empresaExistente = empresaRepository.findByCnpj(cnpj);
        if (empresaExistente == null) {
            throw new RuntimeException("A empresa não existe.");
        }

        empresaRepository.delete(empresaExistente);
    }
}
