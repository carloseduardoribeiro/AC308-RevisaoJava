package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class AlunoGraduacao extends Aluno{
	
	private ArrayList<Float> notas;
	
	public AlunoGraduacao(String nome, int matricula, String email) {
		super(nome, matricula, email);
		notas = new ArrayList<>();
	}
	
	public void adicionarNota(float n) {
		notas.add(n);		
	}
	
	public boolean aprovado() {
		boolean result = false;
		float total = 0;
		float media = 0;
		
		for(float nota : notas) {
			total += nota;
		}
		media = total / notas.size();
		if(media >= 60) {
			result = true;
		}
		
		return result;
	}

}
