package lavacao;

import pratos.Prato;
import pratos.PratosSujosFactory;

public class Lavador implements Runnable {

	private Escorredor escorredor;
	private Prato prato;
	private PratosSujosFactory pratosFactory;
	private boolean stop = true;
	
	
	
	public Lavador(Escorredor escorredor) {
		this.escorredor = escorredor;
		pratosFactory = new PratosSujosFactory();
		prato = pratosFactory.criarPratoSujo();
		
	}

	public void done(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {

		while(stop == false) {
		
			if(prato.getNivelSujeira() > 0.7 && prato.getNivelSujeira() <= 1) {
				//baixo
				try {
					escorredor.colocarPrato(prato);
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if (prato.getNivelSujeira() > 0.2 && prato.getNivelSujeira() <= 0.7) {
				//medio
				try {
					escorredor.colocarPrato(prato);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if (prato.getNivelSujeira() <= 0.1) {
				//alto
				try {
					escorredor.colocarPrato(prato);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
