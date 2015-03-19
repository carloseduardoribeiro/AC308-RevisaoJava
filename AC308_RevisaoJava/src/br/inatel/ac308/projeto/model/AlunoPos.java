package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class AlunoPos extends Aluno implements Pesquisador{
	
	private ArrayList<Integer> conceitos;
	
	public AlunoPos(String nome, int matricula, String email) {
		super(nome, matricula, email);
		conceitos = new ArrayList<>();
	}
	
	public String gerarCurriculo() {
		StringBuilder result = new StringBuilder();
		
		result.append("Curriculo AlunoPos: ").append("\n");
		result.append("Nome: ").append(super.getNome()).append("\n");
		result.append("Matricula: ").append(super.getMatricula()).append("\n");
		result.append("Email: ").append(super.getEmail()).append("\n");
		result.append("Conceitos: ").append(conceitos);
		
		return result.toString();
	}
	
	public int conceitoGeral() {
		int total = 0;
		int conceitoGeral = 0;
		
		for(int conceito : conceitos) {
			total += conceito;
		}
		if(total > 0) { // Para evitar divisao por zero
			conceitoGeral = total / conceitos.size();
		}
		
		return conceitoGeral;
	}
	
	public boolean aprovado() {
		boolean result = false;
		
		for(int conceito : conceitos) {
			if(conceito < 70) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
		
		return result;
	}
	
	public void adicionarConceitos(int c) {
		conceitos.add(c);
	}
}














