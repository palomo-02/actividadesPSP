package ej07;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ej07SimularPipes {

	public static void main(String[] args) {

		try {

			File tmp = File.createTempFile("pipe", ".txt");

			ProcessBuilder p1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo'");

			p1.redirectOutput(tmp);
			Process proceso1 = p1.start();

			int codigo1 = proceso1.waitFor();

			ProcessBuilder p2 = new ProcessBuilder("bash", "-lc", "wc -w");

			p2.redirectInput(tmp);
			Process proceso2 = p2.start();

			String salida = new String(proceso2.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

			proceso2.waitFor();

			System.out.println("La salida es: " + salida);

			Files.deleteIfExists(tmp.toPath());

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

}
