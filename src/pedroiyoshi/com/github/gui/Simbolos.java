package pedroiyoshi.com.github.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import pedroiyoshi.com.github.logic.Leitor;
import pedroiyoshi.com.github.logic.Navegacao;

@SuppressWarnings("serial")
public class Simbolos extends JFrame implements KeyListener{
	private int y, selecionado = 0;
	public static final String path = "src\\pedroiyoshi\\com\\github\\gui\\content.txt";
	private String simbolos = Leitor.read();
	private Painel painel;
	public static List<Simbolos> janelas = new ArrayList<>();
	private static Simbolos janela;
	
	public static void reload(){
		janela.setVisible(false);
		new Simbolos();
	}
	
	Simbolos(){
		janela = this;
		janelas.add(this);
		Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
		y = (int) Math.round(simbolos.length()/ 7.0);
		setJMenuBar(new Menu());
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
		selecionado = new Navegacao().navegar(e, simbolos, selecionado);
		painel.getSimbolo(selecionado);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
