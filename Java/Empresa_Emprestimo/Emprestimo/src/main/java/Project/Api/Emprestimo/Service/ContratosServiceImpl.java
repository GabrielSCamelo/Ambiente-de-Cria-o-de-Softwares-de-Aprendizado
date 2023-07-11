package Project.Api.Emprestimo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.BemDuravel;
import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Funcionario;
import Project.Api.Emprestimo.Model.Pagamento;
import Project.Api.Emprestimo.Model.Vendedor;
import Project.Api.Emprestimo.Repository.ContratosRepository;

@Service
public class ContratosServiceImpl {

    private final ContratosRepository contratosRepository;
    private final BemDuravelService bemDuravelService;
    private final PagamentoService pagamentoService;
    private final SPCService spcService;

    public ContratosServiceImpl(ContratosRepository contratosRepository, BemDuravelService bemDuravelService,
            PagamentoService pagamentoService, SPCService spcService) {
        this.contratosRepository = contratosRepository;
        this.bemDuravelService = bemDuravelService;
        this.pagamentoService = pagamentoService;
        this.spcService = spcService;
    }

    public void criarContrato(Funcionario funcionario, LocalDate dataAtual, Vendedor vendedor, int parcelas,
            double valorParcela, double juros, List<BemDuravel> bensDuraveis) throws Exception {

			double salario = funcionario.getSalario();
			double endividamentoMaximo = salario * 0.3;
			
			double valorContrato = valorParcela * parcelas;
			double valorComJuros = valorContrato * (1 + juros / 100);
			
			if (parcelas > 24 || valorComJuros > endividamentoMaximo || juros > 10) {
			throw new RuntimeException("O contrato não pode ser realizado devido a restrições de endividamento ou juros.");
			} else {
			
			spcService.verificarFuncionarioNoSPC(funcionario);
			
			Contratos contrato = new Contratos();
			contrato.setFuncionario(funcionario);
			contrato.setParcela(parcelas);
			contrato.setValorContrato(valorComJuros * parcelas);
			contrato.setJuros(juros);
			contrato.setCodcontrato(gerarCodigoContrato(funcionario, vendedor));
			contrato.setData(dataAtual);
			
			// Criar os pagamentos
			List<Pagamento> pagamentos = pagamentoService.criarPagamentos(parcelas, valorParcela, contrato);
			
			// Associar os pagamentos ao contrato
			contrato.setPagamento(pagamentos);
			
			// Realizar os cálculos de comissão
			double comissaoEmpresa = contrato.getValorContrato() * contrato.getComissãoempresa();
			double comissaoVendedor = contrato.getValorContrato() * vendedor.getVedcomissão();
			
			System.out.println("Comissão total da empresa: " + comissaoEmpresa);
			System.out.println("Comissão total do vendedor: " + comissaoVendedor);
			
			contratosRepository.save(contrato);
			
			// Associar os bens duráveis ao contrato
			for (BemDuravel bemDuravel : bensDuraveis) {
			bemDuravel.setContrato(contrato);
			bemDuravelService.registrarBemDuravel(bemDuravel, null, comissaoVendedor); //irei modificar depois variaveis erradas.
		}
	}
}


    private String gerarCodigoContrato(Funcionario funcionario, Vendedor vendedor) {
        Long totalContratos = contratosRepository.countContratos();
        int contador = totalContratos.intValue() + 1;

        String codigoContrato = String.format("%s%s%03d", funcionario.getCodfuncionario(), vendedor.getCodvendedor(), contador);

        return codigoContrato;
    }

    public List<Contratos> listarContratosPorFuncionario(Funcionario funcionario) {
        return contratosRepository.findByFuncionario(funcionario);
    }

    public Contratos buscarContratoPorCodContrato(String codContrato) {
        return contratosRepository.findByCodcontrato(codContrato);
    }

}
