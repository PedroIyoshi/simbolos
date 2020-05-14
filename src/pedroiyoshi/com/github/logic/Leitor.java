package pedroiyoshi.com.github.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

import pedroiyoshi.com.github.gui.Simbolos;

public class Leitor {
	public static String read() {
		BufferedReader buffRead;
		try {
			buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(Simbolos.path), "UTF-8"));
			String linha = "", simbolos = "";
	        while (true) {
	            if (linha != null) {
	            	simbolos += linha;
	            } else
	                break;
	            linha = buffRead.readLine();
	        }
	        buffRead.close();
	        return simbolos;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o arquivo");
			return null;
		}
	}

	public static void write(String simbolo){
		String content = read();
		for(int i = 0; i < simbolo.length(); i++) {
			if(content.indexOf(simbolo.charAt(i)) == -1){
				content += simbolo.charAt(i);
			}
		}
		try {
	        BufferedWriter buffWrite = new BufferedWriter(
	        		(new OutputStreamWriter(new FileOutputStream(Simbolos.path), StandardCharsets.UTF_8)));
	        buffWrite.append(content);
	        buffWrite.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel adicionar novos simbolos");
		}
    }
}
