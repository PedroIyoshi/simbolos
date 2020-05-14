package pedroiyoshi.com.github.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import pedroiyoshi.com.github.logic.Copiar;

@SuppressWarnings("serial")
public class Botoes extends JButton implements ActionListener{
	private final int id;
	private final String texto;
	Botoes(String simbolo, int id){
		this.id = id;
		texto = simbolo;
		setFocusable(false);
		setText(texto);
		setBackground(new Color(100, 100, 100));
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		setForeground(Color.WHITE);
		setFont(new Font("Default", Font.BOLD, 25));
		addActionListener(this);
	}
	
	void changeBorderColor(boolean selecionado) {
		if(selecionado) {
			setBorder(BorderFactory.createLineBorder(Color.RED));
		}else {
			setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void actionPerformed(ActionEvent e) {
		Copiar.copiar(texto);
	}
}
