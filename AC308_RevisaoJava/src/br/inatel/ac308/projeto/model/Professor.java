package br.inatel.ac308.projeto.model;

public class Professor implements Pesquisador{
	
	public String nome;
	public String formacao;
	public int grauDeInstrucao;
	
	public Professor(String nome, String formacao, int grauDeInstrucao) {
		this.nome = nome;
		this.formacao = formacao;
		this.grauDeInstrucao = grauDeInstrucao;
	}
	
	public String gerarCurriculo() {
		StringBuilder result = new StringBuilder();
		
		result.append("Curriculo Professor: ").append("\n");
		result.append("Nome: ").append(nome).append("\n");
		result.append("Formação: ").append(formacao).append("\n");
		result.append("Grau de Instrução: ").append(grauDeInstrucao);
		
		return result.toString();
	}
	
	public int conceitoGeral() {
		return grauDeInstrucao;
	}

}
