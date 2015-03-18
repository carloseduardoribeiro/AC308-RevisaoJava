package br.inatel.ac308.projeto.control;

import br.inatel.ac308.projeto.model.Conta;
import br.inatel.ac308.projeto.model.SaldoInsuficienteException;
import br.inatel.ac308.projeto.view.MainFrame;

public class Runner {
	
	public static void main(String[] args) {
		String extrato;
		MainFrame mainFrame = new MainFrame();
		
		
		Conta contaEduardo = new Conta(10, "Eduardo", (float)10);
		Conta contaMaria = new Conta(11, "Maria", (float)11);
		Conta contaJoao = new Conta(12, "Joao", 12);
		
		mainFrame.print("Cadastro: ");
		
		extrato = contaEduardo.gerarExtrato();
		mainFrame.print(extrato);
		mainFrame.print("");
		
		mainFrame.print("Saque de R$2,00");
		mainFrame.print("Deposito de R$30,00");
		mainFrame.print("Resultado:");
		try {
			contaEduardo.sacar(2);
		} catch (IllegalArgumentException i) {
			mainFrame.print("Erro I");
		} catch (SaldoInsuficienteException s) {
			mainFrame.print("Erro S");
		}
		contaEduardo.depositar(30);
		extrato = contaEduardo.gerarExtrato();
		mainFrame.print(extrato);
		mainFrame.print("");
	}

}
