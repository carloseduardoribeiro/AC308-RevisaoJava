package br.inatel.ac308.projeto.control;

import br.inatel.ac308.projeto.model.Conta;
import br.inatel.ac308.projeto.model.SaldoInsuficienteException;
import br.inatel.ac308.projeto.view.MainFrame;

public class Runner {
	
	public static void main(String[] args) {
		String extrato;
		MainFrame mainFrame = new MainFrame();
		
		
		Conta contaEduardo = new Conta(10, "Eduardo", (float)100.100);
		Conta contaMaria = new Conta(11, "Maria", (float)111.111);
		Conta contaJoao = new Conta(12, "Joao", (float)120.120);
		
		mainFrame.print("Cadastro Eduardo: ");
		
		extrato = contaEduardo.gerarExtrato();
		mainFrame.print(extrato);
		mainFrame.print(""); // Pular uma linha - Para Efeito Visual
		
		mainFrame.print("Saque de R$2,00");
		mainFrame.print("Deposito de R$30,00");
		mainFrame.print("Trafeir para Maria: R$20,00");
		mainFrame.print("Resultado:");
		try {
			contaEduardo.sacar(2);
		} catch (IllegalArgumentException i) {
			mainFrame.print("Invalido: Valor de saque Negativo!");
		} catch (SaldoInsuficienteException s) {
			mainFrame.print("Saldo Insufuciente para este valor de saque!");
		}
		try {
			contaEduardo.depositar(30);
		} catch(IllegalArgumentException i) {
			mainFrame.print("Invalido: Valor de deposito Negativo!");
		}
		try {
			contaEduardo.transferirPara(contaMaria, 20);
		} catch (IllegalArgumentException i) {
			mainFrame.print("Erro ao fazer a transferencia: Valor negativo!");
		} catch (SaldoInsuficienteException s) {
			mainFrame.print("Erro ao fazer a transferencia: Saldo Insuficiente!");
		}
		extrato = contaEduardo.gerarExtrato();
		mainFrame.print(extrato);
		mainFrame.print(""); // Pular uma linha - Para Efeito Visual
	}

}
