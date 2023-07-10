package Project.Api.Emprestimo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendedor")
@SequenceGenerator(name = "seq_Vendedor" , sequenceName = "seq_Vendedor",allocationSize = 1, initialValue=1)
public class Vendedor implements Serializable{

	private static final long serialversionuid = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Vendedor")
    private Long id;
	private String codvendedor;
	private String nome;
	private int anoentrada;
	private int anosaida;
	private int anonascimento;
	private double VedComissão;
	
	//Relacionamento
	@OneToOne
    @JoinColumn(name = "CodContrato") //um contrato foi vendido por 1 vendedor fluxo (contrato->vendedor)
	private Vendedor vendedor;

	// Getters e setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodvendedor() {
		return codvendedor;
	}


	public void setCodvendedor(String codvendedor) {
		this.codvendedor = codvendedor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAnoentrada() {
		return anoentrada;
	}


	public void setAnoentrada(int anoentrada) {
		this.anoentrada = anoentrada;
	}


	public int getAnosaida() {
		return anosaida;
	}


	public void setAnosaida(int anosaida) {
		this.anosaida = anosaida;
	}


	public int getAnonascimento() {
		return anonascimento;
	}


	public void setAnonascimento(int anonascimento) {
		this.anonascimento = anonascimento;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public static Vendedor buscarVendedorPorCod(String vendedorCod) {
		// TODO Auto-generated method stub
		return null;
	}


	public double getVedComissão() {
		return VedComissão;
	}


	public void setVedComissão(double vedComissão) {
		VedComissão = vedComissão;
	}

}
