package ej11;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ej11Calculo {
	
	public static void main(String [] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	try {
        		System.out.print("md5sum>");
            	String line = br.readLine();
            	if(line.isBlank()) break;
            	
   
            	File tmp = File.createTempFile("pipe", ".txt");
            	Files.writeString(tmp.toPath(), line, StandardCharsets.UTF_8);
            	
            	
            	ProcessBuilder pb = new ProcessBuilder("md5sum");
            	pb.redirectInput(tmp);
            	pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
            	pb.redirectError(ProcessBuilder.Redirect.PIPE);
            	
            	Process proceso = pb.start();
            	proceso.waitFor();
            	
            	String salida = new String(proceso.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            	System.out.println(salida);
            	
            	tmp.delete();
        	}catch(Exception ex) {}
        	
        }
        
        System.out.println("FIN");

	}

}