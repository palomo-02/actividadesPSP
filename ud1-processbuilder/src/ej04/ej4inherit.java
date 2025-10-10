package ej04;

public class ej4inherit {

	public static void main(String[] args) {

		heredarcomando();

	}

	private static void heredarcomando() {
		ProcessBuilder pb = new ProcessBuilder("top", "-b", "-n1");
		pb.inheritIO();

		try {

			Process p = pb.start();

			int codigo = p.waitFor();

			if (codigo == 0) {
				System.out.println("todo correcto");
			} else {
				System.out.println("error en la ejecucion");
			}
			System.out.println("Proceso finalizado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
