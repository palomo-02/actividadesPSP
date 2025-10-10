package ej02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejlsl {

	public static void main(String[] args) {
	    ejecutarComando("ls -l"); // 
	}

	private static void ejecutarComando(String comando) {
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l");
			Process p = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			p.waitFor();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
