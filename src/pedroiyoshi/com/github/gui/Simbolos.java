package pedroiyoshi.com.github.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import pedroiyoshi.com.github.logic.Leitor;

@SuppressWarnings("serial")
public class Simbolos extends JFrame implements KeyListener{
	private int y;
	private final String path = "src\\pedroiyoshi\\com\\github\\gui\\content.txt";
	private String simbolos = new Leitor().leitor(path);
	private List<Botoes> btn = new ArrayList<>();
	
	private Simbolos(){
		Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
		y = (int) Math.round(simbolos.length()/ 7.0);
		organizarLayout();
		setAlwaysOnTop(true);
		int distanciax = (int) Math.round(tk.getWidth() - 555);
		setBounds(distanciax, 0, 560, y*80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(this);
		setVisible(true);
		setFocusable(true);
		setTitle("Simbolos");
	}
		
	public static void main(String[] args) {
		new Simbolos();
	} 
	
	private void organizarLayout() {
		Painel painel = new Painel(y);
		for(int i = 0; i < simbolos.length(); i++) {
			painel.adicionaBotao(simbolos.charAt(i) + "", i);
		}
		add(painel);
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
		//40 - baixo
		//39 - direita
		//38 - cima
		//37 - esquerda
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
}
