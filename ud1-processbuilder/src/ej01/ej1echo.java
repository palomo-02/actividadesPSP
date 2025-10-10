package ej01;

public class ej1echo {

	public static void main(String[] argumentos) {
		try {
			ProcessBuilder pb = new ProcessBuilder("echo", "Hola");
			Process p = pb.start();
			int codigo = p.waitFor();

			if (codigo == 0) {
				System.out.println("todo correcto");
			} else {
				System.out.println("error en la ejecucion");
			}
		}

		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
