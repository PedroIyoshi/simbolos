package pedroiyoshi.com.github.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Leitor {
	public String leitor(String path) {
		BufferedReader buffRead;
		try {
			buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
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
}
