package Project.Api.Emprestimo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SPC")
public class SPC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String CodSPC;
	
	public String getCodSPC() {
		return CodSPC;
	}
	public void setCodSPC(String codSPC) {
		CodSPC = codSPC;
	}
	
}
