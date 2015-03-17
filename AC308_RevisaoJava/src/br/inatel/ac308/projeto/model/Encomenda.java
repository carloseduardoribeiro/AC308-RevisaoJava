package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class Encomenda {

	private int status;
	private int numero;
	private String nomeDoCliente;
	private ArrayList<Configuracao> configuracoes = new ArrayList<Configuracao>();
	
	public Encomenda (int status, int numero, String nomeDoCliente) {
		this.status = status;
		this.numero = numero;
		this.nomeDoCliente = nomeDoCliente;
	}

	public int getStatus() {
		return status;
	}

	public int getNumero() {
		return numero;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
	
	public ArrayList<Configuracao> getConfiguracoes() {
		return configuracoes;
	}
	
	public void adicionarItem(Configuracao item) {
		this.configuracoes.add(item);
	}
	
	public float calcularPrecoTotal() {
		float preco = 0;
		
		for(Configuracao configuracao : getConfiguracoes()) {
			preco += configuracao.getPreco();
		}
		
		return preco;
	}
	
	public void confirmarMontagem() {
		this.status = 2;
		
	}
	
	public String gerarDetalhes() {
		System.out.println("Nome Do Clinete: " + getNomeDoCliente() + " Status: " + getStatus() + " Numero: " + getNumero());		
		for(Configuracao configuracao : getConfiguracoes()) {
			configuracao.gerarDetalhes();
		}
		return null;
	}
}














