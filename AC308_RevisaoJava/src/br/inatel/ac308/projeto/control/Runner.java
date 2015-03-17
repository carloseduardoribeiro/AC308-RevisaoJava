package br.inatel.ac308.projeto.control;

import java.util.HashMap;

import br.inatel.ac308.projeto.model.Encomenda;
import br.inatel.ac308.projeto.view.MainFrame;

public class Runner {
	
	public static HashMap<Integer, Encomenda> encomendas = new HashMap<Integer, Encomenda>();
	public static int index = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainFrame();
	}

}
