package br.inatel.ac308.projeto.view;

import java.util.Scanner;

import br.inatel.ac308.projeto.control.Runner;
import br.inatel.ac308.projeto.model.Componente;
import br.inatel.ac308.projeto.model.Configuracao;
import br.inatel.ac308.projeto.model.Encomenda;

public class MainFrame {
	
	Scanner input = new Scanner(System.in);

	public MainFrame(){
		initialize();
	}

	private void initialize() {
		menuPrincipal();
	}

	private void menuPrincipal() {
		int op = 0;
		int opComp = 0;
		int opConfig = 0; // já é incializado com sim, pois configuração sempre tera no minimo uma.
		Encomenda encomenda = null;
		Configuracao configuracao = null;
		Componente componente = null;
		
		do {
			System.out.println("######Menu Principal######");
			System.out.println("1 - Cadastrar Encomenda");
			System.out.println("2 - Gerar Detalhes");
			System.out.println("3 - Calcular Preço Total");
			System.out.println("4 - Confirmar Montagem");
			System.out.println("9 - Sair");
			System.out.print("Opcao: ");
			try {
				op = input.nextInt();
			} catch(Exception e) {
				System.out.println("Valor Invalido!");
			}
			
			input.nextLine(); // Para eliminar o enter do inteiro
			switch(op) {
			case 1:
				encomenda = cadastrarEncomenda();
				while(opConfig == 0) {
					configuracao = cadastrarConfiguracao();
					System.out.println("Deseja cadastrar componente? Sim[0] ou Nao[1]");
					System.out.print("Opcao: ");
					try {
						opComp = input.nextInt();
					} catch(Exception e) {
						System.out.println("Valor Invalido!");
						opComp = 1;
					}					
					input.nextLine(); // Para eliminar o enter do inteiro
					switch(opComp) {
					case 0: 
						componente = cadastrarComponente();
						configuracao.adicionarPeca(componente);
						System.out.println("Deseja cadastrar outro componente? Sim [0] ou Nao [1]");
						System.out.print("Opcao: ");
						try {
							opComp = input.nextInt();
						} catch(Exception e) {
							System.out.println("Valor Invalido!");
							opComp = 1;
						}
						input.nextLine(); // Para eliminar o enter do inteiro
						while(opComp == 0) {
							componente = cadastrarComponente();
							configuracao.adicionarPeca(componente);
							System.out.println("Deseja cadastrar outro componente? Sim [0] ou Nao [1]");
							System.out.print("Opcao: ");
							try {
								opComp = input.nextInt();
							} catch(Exception e) {
								System.out.println("Valor Invalido!");
								opComp = 1;
							}
							input.nextLine(); // Para eliminar o enter do inteiro
						}						
					}
					encomenda.adicionarItem(configuracao);
					System.out.println("Deseja cadastrar outra configuração? Sim[0] ou Não[1]");
					System.out.print("Opcao: ");					
					try {
						opConfig = input.nextInt();
					} catch(Exception e) {
						System.out.println("Valor Invalido!");
						opConfig = 1;
					}					
					input.nextLine(); // Para eliminar o enter do inteiro
				}
				Runner.encomendas.put(Runner.index++, encomenda);
				opConfig = 0; // Para cadastrar mais configurações em outra encomenda
				break;
			case 2:				
				gerarDetalhes();
				break;
			case 3:
				calcularPrecoTotal();
				break;
			case 4:
				confirmarMontagem();
				break;
			case 9:
				System.out.println("OBRIGADO!!!");
				System.exit(0);
				break;
			}
		} while(op != 9);
		
		System.out.println("Obrigado!!!");

	}

	private void gerarDetalhes() {
		for(int i = 0; i < Runner.index; i++) {
			Encomenda enc = Runner.encomendas.get(i);
			System.out.println("ENCOMENDA " + (enc.getNumero()) + ":");
			enc.gerarDetalhes();
			System.out.println("---------------------------------------------------");
		}
	}

	private void calcularPrecoTotal() {
		float preco = 0;
		for(int i = 0; i < Runner.index; i++) {
			Encomenda enc = Runner.encomendas.get(i);
			preco += enc.calcularPrecoTotal();
		}
		System.out.println("Preco Total igual a: R$" + preco);
		System.out.println("---------------------------------------------------");
	}

	private void confirmarMontagem() {
		int numero = 0;
		boolean flagEncontrou = false;
		System.out.println("##Confirmar Montagem##");
		System.out.print("Entre com o numero da encomenda: ");
		try {
			numero = input.nextInt();
		} catch(Exception e) {
			System.out.println("Valor Invalido!");
		}
		input.nextLine(); // Receber o enter
		
		// Buscar Encomenda no HasMap de Encomendas
		for(int i = 0; i < Runner.index; i++) {
			Encomenda encomenda = Runner.encomendas.get(i);
			if(encomenda.getNumero() == numero) {
				encomenda.confirmarMontagem();
				flagEncontrou = true;
				System.out.println("Montagem Confirmada Com sucesso!!!");
			}
		}
		if (!flagEncontrou) {
			System.out.println("Não Possui encomenda com este numero!");
		}
		System.out.println("---------------------------------------------------");
	}

	private Encomenda cadastrarEncomenda() {
		String nomeDoCliente;
		int status = 1; // Valor automatico para quando adiciona itens
		int numero = 0;
		System.out.println("##Cadastro de Encomenda##");
		System.out.print("Nome do Cliente: ");
		nomeDoCliente = input.nextLine();
		System.out.print("Numero: ");
		try {
			numero = input.nextInt();
		} catch(Exception e) {
			System.out.println("Valor Invalido!");
		}
		input.nextLine(); // Para eliminar o enter do inteiro
		
		Encomenda encomenda = new Encomenda(status, numero, nomeDoCliente);
		
		return encomenda;
	}

	private Configuracao cadastrarConfiguracao() {
		String nome;
		int tipo = 0;
		System.out.println("##Cadastro de Configuração##");
		System.out.print("Nome: ");
		nome = input.nextLine();
		System.out.print("Tipo: ");
		try {
			tipo = input.nextInt();
		} catch(Exception e) {
			System.out.println("Valor Invalido!");
		}
		input.nextLine(); // Para eliminar o enter do inteiro
		
		Configuracao configuracao = new Configuracao(nome, tipo);
		
		return configuracao;
	}

	private Componente cadastrarComponente() {
		String nome;
		float preco = 0;
		System.out.println("##Cadastro de Componente##");
		System.out.print("Nome: ");
		nome = input.nextLine();
		System.out.print("Preço: ");
		try {
			preco = input.nextFloat();
		} catch(Exception e) {
			System.out.println("Valor Invalido!");
		}
		Componente componente = new Componente(nome, preco);
		
		return componente;
	}
}








