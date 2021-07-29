package auxiliar;

import pratos.Prato;

public class CircularBuffer{

	private int capacidade = 0;
	private int espacoOcupado = 0;
	private int proximo = 0;
	private int indicador = -1;
	
	private Prato[] array;
	
	public CircularBuffer(int capacidade) {
		this.capacidade = capacidade;
		array = new Prato[capacidade];
	}
	
	public void add(Prato obj) {
		int t = (indicador + 1) % capacidade;
		espacoOcupado++;
		array[t] = obj;
		indicador++;
	}
	
	public Prato get() {
		if(espacoOcupado == 0) {
			return null;
		}
		int t = proximo % capacidade;
		Prato prato = array[t];
		proximo++;
		espacoOcupado--;
		return prato;
	}
	
	public Prato observar() {
		if(espacoOcupado == 0) {
			return null;
		}
		int t = proximo % capacidade;
		Prato prato = array[t];
		return prato;
	}
	
	public boolean cheio() {
		if(capacidade == espacoOcupado) {
			return true;
		}
		return false;
	}

	public int getEspacoOcupado() {
		return espacoOcupado;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
}
