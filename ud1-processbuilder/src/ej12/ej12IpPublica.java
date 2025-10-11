package ej12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

public class ej12IpPublica {

    public static void main(String[] args) {
        consultarIPPublica();
        System.out.println();
        consultarIPPrivada();
    }

    private static void consultarIPPublica() {
        System.out.println("🛰️ Consultando IP pública...");
        ProcessBuilder pb = new ProcessBuilder("curl", "-s", "https://api.ipify.org");
        Process proceso = null;

        try {
            Instant inicio = Instant.now();
            proceso = pb.start();
            System.out.println("PID del proceso: " + proceso.pid());

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            StringBuilder salida = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                salida.append(linea);
            }

            int codigo = proceso.waitFor();
            Duration duracion = Duration.between(inicio, Instant.now());

            System.out.println("Código de salida: " + codigo);
            System.out.println("IP Pública: " + salida.toString());
            System.out.println("Duración: " + duracion.toMillis() + " ms");
            System.out.println(codigo == 0 ? "✅ Proceso finalizado correctamente." : "⚠️ Proceso finalizado con errores.");

        } catch (Exception e) {
            System.err.println("❌ Error al consultar IP pública: " + e.getMessage());
        } finally {
            if (proceso != null && proceso.isAlive()) {
                proceso.destroyForcibly();
            }
        }
    }

    private static void consultarIPPrivada() {
        System.out.println("💻 Consultando IP privada...");
        ProcessBuilder pb = new ProcessBuilder("hostname", "-I"); // Linux/macOS
        Process proceso = null;

        try {
            Instant inicio = Instant.now();
            proceso = pb.start();
            System.out.println("PID del proceso: " + proceso.pid());

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            StringBuilder salida = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                salida.append(linea);
            }

            int codigo = proceso.waitFor();
            Duration duracion = Duration.between(inicio, Instant.now());

            System.out.println("Código de salida: " + codigo);
            System.out.println("IP Privada: " + salida.toString().trim());
            System.out.println("Duración: " + duracion.toMillis() + " ms");
            System.out.println(codigo == 0 ? "✅ Proceso finalizado correctamente." : "⚠️ Proceso finalizado con errores.");

        } catch (Exception e) {
            System.err.println("❌ Error al consultar IP privada: " + e.getMessage());
        } finally {
            if (proceso != null && proceso.isAlive()) {
                proceso.destroyForcibly();
            }
        }
    }
}
