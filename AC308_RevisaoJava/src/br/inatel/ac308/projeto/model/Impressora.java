package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class Impressora {
	
	private ArrayList<ImpressaoExtrato> itens = new ArrayList<>();
	private int cont = 0;
	
	public boolean enfileiramento(ImpressaoExtrato c)  throws IllegalAccessException {
		boolean result = false;
		if(c != null) {
			this.itens.add(c);
			cont++;
			result = true;
		} else {
			throw new IllegalAccessException("Erro no enfileiramento: Atributo nulo");
		}
		
		return result;
	}
	
	public String gerarRelatorio() {
		StringBuilder result = new StringBuilder();
		
		for(ImpressaoExtrato impressaoExtrato : this.itens) {
			result.append(impressaoExtrato.gerarExtrato()).append("\n");
		}
		
		return result.toString();
	}
	
	public int getQuantidadeContas() {
		
		return this.cont;
	}
}











