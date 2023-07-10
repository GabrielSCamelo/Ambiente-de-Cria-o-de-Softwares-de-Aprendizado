package Project.Api.Emprestimo.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Empresa;
import Project.Api.Emprestimo.Model.Pagamento;
import Project.Api.Emprestimo.Model.Vendedor;

@Service
public class ComissaoService {

    public double calcularComissaoVendedor(Vendedor vendedor, Contratos contrato) {
        List<Pagamento> pagamentos = contrato.getPagamento();
        LocalDate dataContrato = contrato.getData();
        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeContrato = ChronoUnit.MONTHS.between(dataContrato, dataAtual);

        if (mesesDesdeContrato >= 12) {
            return 0; // Não há comissão após 12 meses de contrato
        }

        int parcelasPagas = contarParcelasPagas(pagamentos);

        if (parcelasPagas == 0) {
            return 0; // Não há comissão se nenhuma parcela foi paga
        }

        double valorTotalParcelasPagas = calcularValorTotalParcelasPagas(pagamentos, parcelasPagas);

        return valorTotalParcelasPagas * vendedor.getVedComissão();
    }

    public double calcularComissaoEmpresa(Empresa empresa, Contratos contrato) {
        List<Pagamento> pagamentos = contrato.getPagamento();
        LocalDate dataContrato = contrato.getData();
        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeContrato = ChronoUnit.MONTHS.between(dataContrato, dataAtual);

        if (mesesDesdeContrato >= 12) {
            return 0; // Não há comissão após 12 meses de contrato
        }

        int parcelasPagas = contarParcelasPagas(pagamentos);

        if (parcelasPagas == 0) {
            return 0; // Não há comissão se nenhuma parcela foi paga
        }

        double valorTotalParcelasPagas = calcularValorTotalParcelasPagas(pagamentos, parcelasPagas);

        return valorTotalParcelasPagas * empresa.getEmpComissão();
    }

    private int contarParcelasPagas(List<Pagamento> pagamentos) {
        int parcelasPagas = 0;

        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isStatus()) {
                parcelasPagas++;
            }
        }

        return parcelasPagas;
    }

    private double calcularValorTotalParcelasPagas(List<Pagamento> pagamentos, int parcelasPagas) {
        double valorTotalParcelasPagas = 0;

        for (int i = 0; i < parcelasPagas; i++) {
            Pagamento pagamento = pagamentos.get(i);
            valorTotalParcelasPagas += pagamento.getValorParcela();
        }

        return valorTotalParcelasPagas;
    }
}
