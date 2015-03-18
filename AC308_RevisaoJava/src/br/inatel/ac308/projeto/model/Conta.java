package br.inatel.ac308.projeto.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Conta implements ImpressaoExtrato{

	private int numero;
	private String cliente;
	private float saldo = 0;
	NumberFormat form;
	
	public Conta(int numero, String cliente, float saldo) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	public String getCliente() {
		return cliente;
	}
	public float getSaldo() {
		return saldo;
	}
	
	public String gerarExtrato() {
		StringBuilder result = new StringBuilder();
		form = DecimalFormat.getInstance();
		
		result.append("Numero da conta: ").append(getNumero()).append("\n");
		result.append("Nome do cliente: ").append(getCliente()).append("\n");
		result.append("Saldo disponivel em conta: R$").append(form.format(getSaldo())).append("\n");
		
		return result.toString();
	}
	
	public boolean sacar(float valor) throws SaldoInsuficienteException{
		boolean result = false;
		
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor Ilegal de saque!!!");
		} else {
			if(valor <= getSaldo()) {
				this.saldo -= valor;
				result = true;
			} else {
				throw new SaldoInsuficienteException("Saldo insuficiente para sacar: " + valor);
			}
		}

		return result;
	}
	
	public boolean depositar(float valor) throws IllegalArgumentException {
		boolean result = false;
		
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor de depósito Ilegal!!!");
		} else {
			this.saldo += valor;
			result = true;
		}
		
		return result;
	}
	
	public boolean transferirPara(Conta c, float valor) throws SaldoInsuficienteException {
		boolean result = false;
		
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor para transferencia Ilegal!!!");
		} else {
			if(valor < this.getSaldo()) {
				this.sacar(valor);
				c.depositar(valor);
				result = true;
			} else {
				throw new SaldoInsuficienteException("Transferencia não permitida. Saldo insuficiente!");
			}
		}
		return result;
	}
}






















