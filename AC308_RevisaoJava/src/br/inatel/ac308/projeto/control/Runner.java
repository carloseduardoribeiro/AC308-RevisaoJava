package br.inatel.ac308.projeto.control;

import java.util.ArrayList;

import br.inatel.ac308.projeto.model.AlunoGraduacao;
import br.inatel.ac308.projeto.model.AlunoPos;
import br.inatel.ac308.projeto.model.EquipeDePesquisa;
import br.inatel.ac308.projeto.model.Pesquisador;
import br.inatel.ac308.projeto.model.Professor;
import br.inatel.ac308.projeto.view.MainFrame;

public class Runner {
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		EquipeDePesquisa equipeDePesquisa = new EquipeDePesquisa();
		
		/*************************************  Cadastros *************************************/
		AlunoGraduacao alunoGraduacaoEduardo = new AlunoGraduacao("Eduardo", 111, "eduardo@inatel.com");
		ArrayList<Float> notasEduardo = new ArrayList<>();
		notasEduardo.add((float)10.0);
		notasEduardo.add((float)10.0);
		notasEduardo.add((float)7.0);
		
		AlunoGraduacao alunoGraduacaoMaria = new AlunoGraduacao("Maria", 222, "maria@inatel.com");
		ArrayList<Float> notasMaria = new ArrayList<>();
		notasMaria.add((float)10.0);
		notasMaria.add((float)10.0);
		notasMaria.add((float)4.0);
		
		AlunoGraduacao alunoGraduacaoJose = new AlunoGraduacao("Jose", 333, "jose@inatel.com");
		ArrayList<Float> notasJose = new ArrayList<>();
		notasJose.add((float)10.0);
		notasJose.add((float)10.0);
		notasJose.add((float)1.0);
		
		
		AlunoPos alunoPosJoao = new AlunoPos("Joao", 444, "joao@inatel.com");
		ArrayList<Integer> conceitosJoao = new ArrayList<>();
		conceitosJoao.add(100);
		conceitosJoao.add(90);
		conceitosJoao.add(80);
		
		AlunoPos alunoPosRita = new AlunoPos("Rita", 555, "rita@inatel.com");
		ArrayList<Integer> conceitosRita = new ArrayList<>();
		conceitosRita.add(90);
		conceitosRita.add(80);
		conceitosRita.add(70);
		
		AlunoPos alunoPosAna = new AlunoPos("Ana", 666, "ana@inatel.com");
		ArrayList<Integer> conceitosAna = new ArrayList<>();
		conceitosAna.add(80);
		conceitosAna.add(70);
		conceitosAna.add(60);
		
		Professor professorDaniel = new Professor("Daniel", "Engenharia de Telecominicações", 2);
		Professor professorCarlos = new Professor("Carlos", "Engenharia Elétrica", 5);
		Professor professorRodolfo = new Professor("Rodolfo", "Engenharia da Computação", 10);
		
		/************************************* Adicionar Pesquisadores *************************************/
		equipeDePesquisa.adicionarPesquisador(alunoPosAna);
		equipeDePesquisa.adicionarPesquisador(alunoPosJoao);
		equipeDePesquisa.adicionarPesquisador(alunoPosRita);
		equipeDePesquisa.adicionarPesquisador(professorCarlos);
		equipeDePesquisa.adicionarPesquisador(professorDaniel);
		equipeDePesquisa.adicionarPesquisador(professorRodolfo);
		
		/************************************* Adicionar Alunos *************************************/
		
		/************************************* Geração dos resultados *************************************/
		mainFrame.print("##########Pesquisadores#########");
		for(Pesquisador pesquisador : equipeDePesquisa.getPesquisadores()) {
			mainFrame.print(pesquisador.gerarCurriculo());
			mainFrame.print("Conceito Geral: " + Integer.toString(pesquisador.conceitoGeral()));
			mainFrame.print("\n");
		}
	}
}









