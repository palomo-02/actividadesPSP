package ej10;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ej10EjecutarScript {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "./hola.sh palomo").directory(new File(
				"/home/usuario/git_proyectos/actividadesPSPrepaso1/actividadesPSP/ud1-processbuilder/src/ej10"));

		pb.environment().put("prueba", "🍕");
		
		
		try {
			Process p = pb.start();

			int codigo = p.waitFor();

			if (codigo == 0) {

				System.out.println("Script ejecutado correctamente. Salida:");

			} else {
				System.out.println("Error en la ejecucion del script. Salida de error:");
			}
		} catch (Exception e) {
			System.err.println("Error al ejecutar el script: " + e.getMessage());
		}
	}

}
