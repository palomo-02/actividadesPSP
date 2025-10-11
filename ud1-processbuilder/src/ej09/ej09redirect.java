package ej09;

import java.io.File;

public class ej09redirect {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("cat", "etc/passwd");

		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));

		try {

			Process p = pb.start();
			p.waitFor();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
