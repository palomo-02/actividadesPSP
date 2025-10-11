package ej11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ej11Calculo {

	public static String main(String[] args) {

		String linea = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("consola> ");
				linea = br.readLine();
				if (linea.isBlank())
					break;
				ProcessBuilder pb = new ProcessBuilder("md5sum");

				pb.inheritIO();

				Process p = pb.start();

				try (OutputStream os = p.getOutputStream()) {
					os.write(linea.getBytes());
					os.flush();
				}

				p.waitFor();

			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
		}
		return linea;

	}

}
