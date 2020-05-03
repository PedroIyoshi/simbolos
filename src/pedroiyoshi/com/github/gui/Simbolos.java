package pedroiyoshi.com.github.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import pedroiyoshi.com.github.logic.Copiar;
import pedroiyoshi.com.github.logic.Leitor;

@SuppressWarnings("serial")
public class Simbolos extends JFrame implements KeyListener{
	private int y, selecionado = 0;
	private final String path = "src\\pedroiyoshi\\com\\github\\gui\\content.txt";
	private String simbolos = new Leitor().leitor(path);
	private Painel painel;
	
	private Simbolos(){
		Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
		y = (int) Math.round(simbolos.length()/ 7.0);
		organizarLayout();
		setAlwaysOnTop(true);
		int distanciax = (int) Math.round(tk.getWidth() - 555);
		setBounds(distanciax, 0, 560, y*80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		setVisible(true);
		setFocusable(true);
		setTitle("Simbolos");
	}
		
	public static void main(String[] args) {
		new Simbolos();
	} 
	
	private void organizarLayout() {
		painel = new Painel(y);
		for(int i = 0; i < simbolos.length(); i++) {
			painel.adicionaBotao(simbolos.charAt(i) + "", i);
		}
		painel.getSimbolo(selecionado);
		add(painel);
	}
	
	public void keyPressed(KeyEvent e) {
		int length = simbolos.length() - 1;
		switch(e.getKeyCode()) {
		case 40:
			selecionado = selecionado + 7 >= length?length:selecionado+7;
			break;
		case 39:
			selecionado = selecionado == length?length:selecionado + 1;
			break;
		case 38:
			selecionado = selecionado - 7 <= 0?0:selecionado - 7; 
			break;
		case 37:
			selecionado = selecionado == 0?0:selecionado - 1;
			break;
		case 32: case 10:
			new Copiar().copiar(simbolos.charAt(selecionado) + "");
		}
		painel.getSimbolo(selecionado);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
}
