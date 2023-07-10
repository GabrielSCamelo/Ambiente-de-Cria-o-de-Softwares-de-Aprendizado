package Project.Api.Emprestimo.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.Contratos;
import Project.Api.Emprestimo.Model.Pagamento;

@Service
public class PagamentoService {

    public List<Pagamento> criarPagamentos(int parcelas, double valorParcela, Contratos contrato) {
        List<Pagamento> pagamentos = new ArrayList<>();

        LocalDate dataContrato = contrato.getData();

        for (int i = 0; i < parcelas; i++) {
            Pagamento pagamento = new Pagamento();
            pagamento.setValorParcela(valorParcela);
            pagamento.setContrato(contrato);

            LocalDate dataPagamento = dataContrato.plusMonths(i).withDayOfMonth(dataContrato.lengthOfMonth());
            pagamento.setData(dataPagamento);

            pagamentos.add(pagamento);
        }

        return pagamentos;
    }
}
