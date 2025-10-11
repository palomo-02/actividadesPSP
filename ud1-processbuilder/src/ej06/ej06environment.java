package ej06;

public class ej06environment {

	public static void main(String[] args) {

		try {

			ProcessBuilder pb = new ProcessBuilder("printenv","MI_VAR").inheritIO();

			pb.environment().put("MI_VAR", "UD1");

			Process p = pb.start();

			p.waitFor();

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
