package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class Configuracao {

	private String nome;
	private int tipo;
	private ArrayList<Componente> componentes = new ArrayList<Componente>();
	
	public Configuracao (String nome, int tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getTipo() {
		return tipo;
	}
	
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	
	public void adicionarPeca(Componente p) {
		this.componentes.add(p);
	}
	
	public float getPreco() {
		float preco = 0;
		
		for(Componente componente : getComponentes()) {
			preco += componente.getPreco();
		}
		
		return preco;
	}
	
	public String gerarDetalhes() {
		System.out.println("CONFIGURAÇÃO:");
		System.out.println("Nome: " + getNome() + " Tipo: " + getTipo());
		System.out.println("COMPONENTE(S):");
		for(Componente componente : getComponentes()) {
			componente.gerarDetalhes();
		}
		
		return null;
	}
}











