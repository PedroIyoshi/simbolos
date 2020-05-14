package pedroiyoshi.com.github.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painel extends JPanel	{
	private List<Botoes> btn = new ArrayList<>();
	
	Painel(int y){
		setLayout(new GridLayout(y, 7));
		setBackground(new Color(50, 50, 50));
	}
	
	public void adicionaBotao(String simbolo, int id) {
		Botoes b = new Botoes(simbolo, id);
		btn.add(b);
		add(b);
	}
	
	public void getSimbolo(int id) {
		btn.stream().forEach(a -> a.changeBorderColor(false));
		btn.stream().filter(e -> e.getId() == id).findAny().ifPresent(a -> a.changeBorderColor(true));
	}
}
