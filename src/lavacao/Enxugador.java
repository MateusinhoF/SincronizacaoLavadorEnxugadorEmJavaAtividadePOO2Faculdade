package lavacao;

import java.util.Random;


public class Enxugador implements Runnable{

	private Escorredor escorredor;
	private Random random = new Random();
	private boolean stop = true;
		
	public Enxugador(Escorredor escorredor) {
		this.escorredor = escorredor;
		
	}
	
	public void done(boolean stop) {
		this.stop = stop;
	}

	public void done() {
		while(escorredor.situacaoEscorredor() > 0) {
			
		}
		this.stop = true;
		
	}
	
	@Override
	public void run() {
		while(stop == false) {
			try {
				escorredor.pegarPrato();
				long time = random.nextInt(701)+300;
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}

}
