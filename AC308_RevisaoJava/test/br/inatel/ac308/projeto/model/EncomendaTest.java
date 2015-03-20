package br.inatel.ac308.projeto.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncomendaTest {

	@Test
	public void testCalcularPrecoTotal() {
		Encomenda encomenda = new Encomenda(1, "Eduardo");
		
		// Encomenda Vazia
		assertEquals(0, encomenda.calcularPrecoTotal(), 0.001);
		
		// Configurações
		Configuracao configuracao1 = new Configuracao("Conf1", 1);
		encomenda.adicionarProduto(configuracao1);
		
		assertEquals(0, encomenda.calcularPrecoTotal(), 0.001);
		
		Configuracao configuracao2 = new Configuracao("Conf2", 2);
		encomenda.adicionarProduto(configuracao2);
		
		assertEquals(0, encomenda.calcularPrecoTotal(), 0.001);
		
		// Componentes
		Componente componente1 = new Componente("Comp1", 1.11f);
		configuracao1.adicionarPecas(componente1);
		
		assertEquals(1.11, encomenda.calcularPrecoTotal(), 0.001);
		
		Componente componente2 = new Componente("comp2", 2.22f);
		configuracao2.adicionarPecas(componente2);
		
		assertEquals(3.33, encomenda.calcularPrecoTotal(), 0.001);
		
//		fail("Not yet implemented");
	}

}
