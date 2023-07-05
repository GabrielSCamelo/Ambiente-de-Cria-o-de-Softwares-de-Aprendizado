package pjrPonto;

public abstract class Veiculo {
	public String fabricante;
	public String modelo;
	protected String proprietario;
 
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public void andar() {
		System.out.println("Andando");
	}
	
	public void andar(String msg) {
		System.out.println("Andando "+msg);
	}

}
