package Exercicio;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	public String Nome;
	private int idade;
	private String Telefone;
	@Override
	public String toString() {
		return "Pessoa [Nome=" + Nome + ", idade=" + idade + ", Telefone=" + Telefone + "]";
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public Pessoa(String nome, int idade, String telefone) {
		super();
		Nome = nome;
		this.idade = idade;
		Telefone = telefone;
	}
}