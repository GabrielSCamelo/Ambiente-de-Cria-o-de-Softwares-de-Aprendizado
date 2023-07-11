package Project.Api.Emprestimo.Model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pagamento")
@SequenceGenerator(name = "seq_Pagamento" , sequenceName = "seq_Pagamento",allocationSize = 1, initialValue=1)
public class Pagamento implements Serializable{

	private static final long serialversionuid = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Pagamento")
    private Long id;
	private LocalDate data;
	private boolean status;
	private double valorparcela;

	//Relacionamento
	@ManyToOne
	@JoinColumn(name = "Contrato_codcontrato") // varios pagamentos podem pertencer a apenas 1 contrato.
	private Contratos contrato;
	
	// Getters e setters
	

	public boolean isStatus() {
		return false;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Contratos getContrato() {
		return contrato;
	}

	public void setContrato(Contratos contrato) {
		this.contrato = contrato;
	}

	public void setData(LocalDate now) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorparcela() {
		return valorparcela;
	}

	public void setValorparcela(double valorparcela) {
		this.valorparcela = valorparcela;
	}

	public LocalDate getData() {
		return data;
	}

}
