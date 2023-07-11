package Project.Api.Emprestimo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "BemDuravel")
@SequenceGenerator(name = "seq_BemDuravel" , sequenceName = "seq_BemDuravel",allocationSize = 1, initialValue=1)
public class BemDuravel implements Serializable{

	private static final long serialversionuid = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_BemDuravel")
    private Long id;
	private String descrição;
	private Double valordbem;
	
	//Relacionamento
	@ManyToOne
    @JoinColumn(name = "Contrato_cod") // um bem duravel so pode pertencer a 1 contrato
    private Contratos contrato;

	// Getters e setters
	

	public Contratos getContrato() {
		return contrato;
	}

	public void setContrato(Contratos contrato) {
		this.contrato = contrato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Double getValordbem() {
		return valordbem;
	}

	public void setValordbem(Double valordbem) {
		this.valordbem = valordbem;
	}
	
}
