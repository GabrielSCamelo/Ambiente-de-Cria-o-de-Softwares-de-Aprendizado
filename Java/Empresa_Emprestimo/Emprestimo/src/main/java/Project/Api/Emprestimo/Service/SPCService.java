package Project.Api.Emprestimo.Service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Funcionario;
import Project.Api.Emprestimo.Model.SPC;
import Project.Api.Emprestimo.Repository.SPCRepository;

@Service
public class SPCService {

    private final SPCRepository spcRepository;

    public SPCService(SPCRepository spcRepository) {
        this.spcRepository = spcRepository;
    }

    public void verificarPagamentoAtrasado(Contratos contrato) {
        LocalDate dataContrato = contrato.getData();
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(dataContrato, dataAtual);
        int mesesSemPagamento = periodo.getMonths();

        if (mesesSemPagamento > 2) {
            String codFuncionario = contrato.getFuncionario().getCodfuncionario();
            adicionarAoSPC(codFuncionario);
        }
    }
    
    public void verificarFuncionarioNoSPC(Funcionario funcionario) throws Exception {
        String codFuncionario = funcionario.getCodfuncionario();
        SPC spc = spcRepository.findByCodSPC(codFuncionario);
        if (spc != null) {
            throw new Exception("O funcionário está no SPC e não pode criar um contrato.");
        }
    }
    
    private void adicionarAoSPC(String codFuncionario) {
        SPC spc = spcRepository.findByCodSPC(codFuncionario);
        if (spc == null) {
            spc = new SPC();
            spc.setCodSPC(codFuncionario);
            spcRepository.save(spc);
            System.out.println("Adicionando ao SPC: " + codFuncionario);
        }
    }
}
