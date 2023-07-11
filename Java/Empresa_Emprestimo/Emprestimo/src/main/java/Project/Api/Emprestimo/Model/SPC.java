package Project.Api.Emprestimo.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SPC")
public class SPC implements Serializable{

	private static final long serialversionuid = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codSPC;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodSPC() {
		return codSPC;
	}
	public void setCodSPC(String codSPC) {
		this.codSPC = codSPC;
	}
	
	
	
}
