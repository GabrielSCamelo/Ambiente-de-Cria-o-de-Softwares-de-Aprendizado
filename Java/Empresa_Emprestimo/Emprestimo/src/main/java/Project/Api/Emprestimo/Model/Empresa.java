package Project.Api.Emprestimo.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresa")
@SequenceGenerator(name = "seq_Empresa" , sequenceName = "seq_Empresa",allocationSize = 1, initialValue=1)
public class Empresa implements Serializable{

	private static final long serialversionuid = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Empresa")
    private Long id;
	private String descrição;
	private String nome;
	private String cnpj;
	
	//Relacionamento
	@OneToMany(mappedBy = "empresa") //varios funcionarios podem trabalhar em 1 empresa
    private List<Funcionario> funcionario;

	// Getters e setters
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
