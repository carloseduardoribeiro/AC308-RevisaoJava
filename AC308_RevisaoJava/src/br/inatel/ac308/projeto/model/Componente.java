package br.inatel.ac308.projeto.model;

public class Componente {

	private String nome;
	private float preco;
	
	public Componente(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public float getPreco() {
		return preco;
	}
}
