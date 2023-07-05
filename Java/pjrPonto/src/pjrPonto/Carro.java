package pjrPonto;

public class Carro extends Veiculo implements Transport {
	private String renavam;
	
	public Carro (String fabricante, String modelo, String proprietario, String renavam) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.proprietario = proprietario;
		this.renavam = renavam;
		
	}
	
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	public void transportar() {
		System.out.println("Transportando pessoas");
	}
}
