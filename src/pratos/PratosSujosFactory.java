package pratos;

import java.util.Random;

public class PratosSujosFactory{

	private static int serie = 0;
	private double nivel;
		
	public Prato criarPratoSujo() {

		this.nivel = new Random().nextDouble();
		addCount();
		return new Prato(serie,nivel);	
	}
	
	static void addCount() {
		serie++;
	}
	
}
