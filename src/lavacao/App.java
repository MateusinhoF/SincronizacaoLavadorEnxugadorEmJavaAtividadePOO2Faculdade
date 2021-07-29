package lavacao;

public class App {

	
	private static Escorredor escorredor;
	private static Enxugador enxugador;
	private static Lavador lavador;
	private static Thread threadLavador;
	private static Thread threadEnxugador;
	
	static void work() throws InterruptedException {
	escorredor = new Escorredor(10);
	enxugador = new Enxugador(escorredor);
	lavador = new Lavador(escorredor);
	
	threadLavador = new Thread(lavador);
	threadEnxugador = new Thread(enxugador);
	
	//ativando lavador e enxugador
	lavador.done(false);
	enxugador.done(false);
	
	threadEnxugador.start();
	threadLavador.start();
	
	//espera um tempo pra deixar a aplicação rodar
	Thread.sleep(10000);
	}
	
	static void stop() throws InterruptedException{

		lavador.done(true);
		threadLavador.join();

		enxugador.done();
		threadEnxugador.join();
		
	}
	
	public static void main(String[]args) throws InterruptedException {
		
		System.out.println("Começando a lavação");
		work();
		System.out.println("Encerrando a lavação");
		stop();
		System.out.println("Lavação Encerrada");
	}
}
