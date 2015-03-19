package br.inatel.ac308.projeto.model;

import java.util.ArrayList;

public class EquipeDePesquisa {
	
	private ArrayList<Pesquisador> pesquisadores;
	
	public EquipeDePesquisa() {
		pesquisadores = new ArrayList<>();
	}
	
	public void adicionarPesquisador(Pesquisador p) {
		pesquisadores.add(p);
	}
	
	public String gerarCurriculos() {
		StringBuilder result = new StringBuilder();
		for(Pesquisador pesquisador : pesquisadores) {
			result.append(pesquisador.gerarCurriculo()).append("\n");
		}
		
		return result.toString();
	}
	
	public float conceitoGeralDaEquipe() {
		float conceitoGeral = 0;
		float total = 0;
		
		for(Pesquisador pesquisador : pesquisadores) {
			total += pesquisador.conceitoGeral();
		}
		if(!pesquisadores.isEmpty()) {
			conceitoGeral = total / pesquisadores.size();
		}
		 
		return conceitoGeral;
	}

	public ArrayList<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}
}
