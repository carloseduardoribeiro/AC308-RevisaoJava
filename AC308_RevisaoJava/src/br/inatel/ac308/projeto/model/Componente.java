package br.inatel.ac308.projeto.model;

public class Componente {

	private String nome;
	private float preco;
	
	public Componente(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}
	
	public String gerarDetalhes() {
		System.out.println("Nome: " + getNome() + " Preco: " + getPreco());
		return null;
	}
}
