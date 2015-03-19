package br.inatel.ac308.projeto.control;

import java.util.ArrayList;

import br.inatel.ac308.projeto.model.Aluno;
import br.inatel.ac308.projeto.model.AlunoGraduacao;
import br.inatel.ac308.projeto.model.AlunoPos;
import br.inatel.ac308.projeto.model.EquipeDePesquisa;
import br.inatel.ac308.projeto.model.Pesquisador;
import br.inatel.ac308.projeto.model.Professor;
import br.inatel.ac308.projeto.view.MainFrame;

public class Runner {
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		ArrayList<Aluno> alunos = new ArrayList<>(); // Arraylist para armazenar os alunos cadastrados
		
		EquipeDePesquisa equipeDePesquisa = new EquipeDePesquisa();
		
		/*************************************  Cadastros *************************************/
		AlunoGraduacao alunoGraduacaoEduardo = new AlunoGraduacao("Eduardo", 111, "eduardo@inatel.com");
		alunoGraduacaoEduardo.adicionarNota(80);
		alunoGraduacaoEduardo.adicionarNota(80);
		alunoGraduacaoEduardo.adicionarNota(80);
		
		AlunoGraduacao alunoGraduacaoMaria = new AlunoGraduacao("Maria", 222, "maria@inatel.com");
		alunoGraduacaoMaria.adicionarNota(50);
		alunoGraduacaoMaria.adicionarNota(50);
		alunoGraduacaoMaria.adicionarNota(50);
		
		AlunoGraduacao alunoGraduacaoJose = new AlunoGraduacao("Jose", 333, "jose@inatel.com");
		alunoGraduacaoJose.adicionarNota(80);
		alunoGraduacaoJose.adicionarNota(70);
		alunoGraduacaoJose.adicionarNota(60);
		
		AlunoPos alunoPosJoao = new AlunoPos("Joao", 444, "joao@inatel.com");
		alunoPosJoao.adicionarConceitos(100);
		alunoPosJoao.adicionarConceitos(90);
		alunoPosJoao.adicionarConceitos(80);
		
		AlunoPos alunoPosRita = new AlunoPos("Rita", 555, "rita@inatel.com");
		alunoPosRita.adicionarConceitos(90);
		alunoPosRita.adicionarConceitos(80);
		alunoPosRita.adicionarConceitos(70);
		
		AlunoPos alunoPosAna = new AlunoPos("Ana", 666, "ana@inatel.com");
		alunoPosAna.adicionarConceitos(80);
		alunoPosAna.adicionarConceitos(70);
		alunoPosAna.adicionarConceitos(60);
		
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
		alunos.add(alunoGraduacaoJose);
		alunos.add(alunoGraduacaoMaria);
		alunos.add(alunoGraduacaoEduardo);
		alunos.add(alunoPosAna);
		alunos.add(alunoPosRita);
		alunos.add(alunoPosJoao);
		
		/************************************* Geração dos resultados *************************************/
		mainFrame.print("##########Pesquisadores#########");
		for(Pesquisador pesquisador : equipeDePesquisa.getPesquisadores()) {
			mainFrame.print(pesquisador.gerarCurriculo());
			mainFrame.print("Conceito Geral: " + Integer.toString(pesquisador.conceitoGeral()));
			mainFrame.print("\n");
		}
		
		mainFrame.print("##########Alunos#########");
		for(Aluno aluno : alunos) {
			if(aluno instanceof AlunoGraduacao) {
				mainFrame.print(aluno.toString());
			} else {
				AlunoPos alunoPos = (AlunoPos) aluno;
				mainFrame.print(alunoPos.gerarCurriculo());
				mainFrame.print("Conceito Geral: " + Integer.toString(alunoPos.conceitoGeral()));
			}
			if(aluno.aprovado()) {
				mainFrame.print("Aluno Aprovado!!!");
			} else {
				mainFrame.print("Aluno Reprovado!!!");
			}
			mainFrame.print("\n");
		}
	}
}









