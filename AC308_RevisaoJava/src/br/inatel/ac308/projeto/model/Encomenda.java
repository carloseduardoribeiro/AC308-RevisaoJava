package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class Encomenda {
	
	public static final int PREPARANDO = 1;
	public static final int PRONTO = 2;

	private int numero;
	private String nomeCliente;
	private int status;
	private ArrayList<Configuracao> produtos;
	
	public Encomenda(int numero, String nomeCliente) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.status = PREPARANDO;
		produtos = new ArrayList<>();
	}
	
	public void adicionarProduto(Configuracao c) {
		produtos.add(c);
	}
	
	public float calcularPrecoTotal() {
		float total = 0.0f;
		
		for (Configuracao prod : produtos) {
			total += prod.getValorTotal();
		}
		
		return total;
	}
}
