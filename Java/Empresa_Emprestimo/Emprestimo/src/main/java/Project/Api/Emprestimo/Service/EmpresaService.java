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
    
    public Empresa registrarEmpresa(String Cnpj,String Descrição,String Nome) {
        // Verificar se a empresa já está registrada pelo CNPJ
    	
        Empresa empresas = new Empresa();
        empresas.setDescrição(Descrição);
        empresas.setNome(Nome);
        empresas.setCnpj(Cnpj);

        return empresaRepository.save(empresas);
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
        return empresaRepository.save(empresaExistente);
    }

    public boolean excluirEmpresa(String cnpj) {
        // Verificar se a empresa existe
        Empresa empresaExistente = empresaRepository.findByCnpj(cnpj);
        if (empresaExistente == null) {
            throw new RuntimeException("A empresa não existe.");
        }

        empresaRepository.delete(empresaExistente);
        return true;
    }
}

