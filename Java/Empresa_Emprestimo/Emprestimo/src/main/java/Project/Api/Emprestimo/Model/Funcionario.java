package Project.Api.Emprestimo.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcionario")
@SequenceGenerator(name = "seq_Funcionario" , sequenceName = "seq_Funcionario",allocationSize = 1, initialValue=1)
public class Funcionario implements Serializable{

	private static final long serialversionuid = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Funcionario")
    private Long id;
	private String codfuncionario;
	private String nome;
	private double salario;
	private int anoentrada;
	private int anosaida;
	private int anonascimento;
	
	//Relacionamento
	@ManyToOne
	@JoinColumn(name = "Empresa_cnpj") // um funcionario pode trabalhar em uma empresa
	private Empresa empresa;
		
	@OneToMany(mappedBy = "funcionario") //um contrato pertence a apenas um funcionario.
	private List<Contratos> contrato;
	
	// Getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodfuncionario() {
		return codfuncionario;
	}

	public void setCodfuncionario(String codfuncionario) {
		this.codfuncionario = codfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Contratos> getContrato() {
		return contrato;
	}

	public void setContrato(List<Contratos> contrato) {
		this.contrato = contrato;
	}

	public String getCodSPC() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
