package Project.Api.Emprestimo.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.xml.crypto.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contratos")
@SequenceGenerator(name = "seq_Contratos" , sequenceName = "seq_Contratos",allocationSize = 1, initialValue=1)
public class Contratos implements Serializable{

	private static final long serialversionuid = 1L;
	
	@Id //Numero do contrato 
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Contratos")
    private Long id;
	private String codcontrato;
	private int parcela;
	private double valorContrato;
	private double juros;
	private LocalDate data;
	
	//Relacionamento
	@ManyToOne
    @JoinColumn(name = "Funcionario_cod") //Funcionario pode ter muitos contratos
    private Funcionario funcionario;
	
	@OneToMany(mappedBy = "contrato") //um contrato pode ter varios bem duraveis
    private List<BemDuravel> bemduravel;
	
	@OneToMany(mappedBy = "contrato") //um contrato pode ter varios pagamento
    private List<Pagamento> pagamento;
	
	@OneToOne
    @JoinColumn(name = "Vendedor_codvendedor")  //um contrato foi vendido por 1 vendedor fluxo (contrato->vendedor)
	private Vendedor vendedor;
	
	// Getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodcontrato() {
		return codcontrato;
	}

	public void setCodcontrato(String codcontrato) {
		this.codcontrato = codcontrato;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<BemDuravel> getBemduravel() {
		return bemduravel;
	}

	public void setBemduravel(List<BemDuravel> bemduravel) {
		this.bemduravel = bemduravel;
	}

	public List<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(List<Pagamento> pagamento) {
		this.pagamento = pagamento;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate now) {
		
	}
	
}
