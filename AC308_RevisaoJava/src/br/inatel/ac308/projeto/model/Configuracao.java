package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class Configuracao {

	private String nome;
	private int tipo;
	private ArrayList<Componente> pecas;
	
	public Configuracao(String nome, int tipo) {
		this.nome = nome;
		this.tipo = tipo;
		pecas = new ArrayList<>();
	}
	
	public float getValorTotal() {
		float total = 0.0f;
		
		for(Componente comp : pecas) {
			total += comp.getPreco();
		}
		
		return total;
	}
	
	public void adicionarPecas(Componente c) {
		pecas.add(c);
	}
}
