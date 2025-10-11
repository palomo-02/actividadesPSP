package ej08;

public class ej08timeOut {

	public static void main(String[] args) {

		try {

			ProcessBuilder pb = new ProcessBuilder("sleep", "1");

			Process p = pb.start();


			boolean terminado = p.waitFor(5, java.util.concurrent.TimeUnit.SECONDS);
			
			if (terminado) {
				System.out.println("El proceso terminó dentro del tiempo");
			} else {
				System.out.println("El proceso no terminó dentro del tiempo, se va a destruir");
				p.destroy();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
