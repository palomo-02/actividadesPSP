package ej05;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ej05directory {

	public static void main(String[] args) {

		try {
			ProcessBuilder pb = new ProcessBuilder("pwd").directory(new File("/tmp"));

			Process p = pb.start();

			InputStream inputStream = p.getInputStream();

			InputStreamReader lector_de_flujos = new InputStreamReader(inputStream);
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
