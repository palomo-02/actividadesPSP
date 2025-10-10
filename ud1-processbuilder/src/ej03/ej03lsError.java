package ej03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ej03lsError {

	public static void main(String[] args) {
		ejecutarComando("ls -l");

	}

	private static void ejecutarComando(String comando) {
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "/ruta/que/no/existe");
			Process p = pb.start();

			InputStream error= p.getErrorStream();

			InputStreamReader lector_de_flujos = new InputStreamReader(error);
			BufferedReader br = new BufferedReader(lector_de_flujos);
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			int codigo = p.waitFor();
			if (codigo == 0) {
				System.out.println("todo correcto");
			} else {
				System.out.println("error en la ejecucion");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
