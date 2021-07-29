package lavacao;

import auxiliar.CircularBuffer;
import pratos.Prato;

public class Escorredor {

	private CircularBuffer filaEscorredor;
	private int capacidade;
	private int count = 0;
	
	public Escorredor(int qtdeMaxPratos) {
		filaEscorredor = new CircularBuffer(qtdeMaxPratos);
		capacidade = qtdeMaxPratos;
	}
	
	public synchronized void colocarPrato(Prato prato) throws InterruptedException {
		while(count > capacidade) {
			wait();
		}
		
		if(filaEscorredor.cheio() == false) {
			count++;
			filaEscorredor.add(prato);
			notifyAll();
			System.out.println("ADICIONADO - Escorredor esta com "+situacaoEscorredor()+" de lota��o");
		}else {
			System.out.println("N�O ADICIONADO - Prato N�O adicionado --- "
					+ "Escorredor esta com "+situacaoEscorredor()+" de lota��o ---");
		}
	}
	
	public synchronized Prato pegarPrato() throws InterruptedException {
		while(count < 0) {
			wait();
		}
		count--;
		notifyAll();
		System.out.println("RETIRADA - Escorredor esta com "+situacaoEscorredor()+" de lota��o");
		return filaEscorredor.get();
	}
	
	public synchronized int situacaoEscorredor() {
		return filaEscorredor.getEspacoOcupado();
	}
	
	public synchronized boolean escorredorCheio() {
		if(filaEscorredor.cheio() == true) {
			return true;
		}
		return false;
	}

}
