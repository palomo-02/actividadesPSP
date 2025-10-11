package ej10;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ej10EjecutarScript {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "./hola.sh palomo").directory(new File(
				"/home/usuario/git_proyectos/actividadesPSPrepaso1/actividadesPSP/ud1-processbuilder/src/ej10"));

		try {
			Process p = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}

			int exitCode = p.waitFor();
			System.out.println("Proceso finalizado con código: " + exitCode);

		} catch (Exception e) {
			System.err.println("Error al ejecutar el script: " + e.getMessage());
		}
	}

}
