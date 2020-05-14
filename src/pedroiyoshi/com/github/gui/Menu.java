package pedroiyoshi.com.github.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedroiyoshi.com.github.logic.Leitor;

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener{
	private JTextField txtSimbolos = new JTextField();
	private JFrame janela = new JFrame();
	
	Menu(){
		setBackground(new Color(100, 100, 100));
		JMenu editar = new JMenu("Editar");
		editar.setForeground(Color.WHITE);
		add(editar);
		addItem(editar, "Abrir");
		addItem(editar, "Adicionar simbolo");
		addItem(editar, "Recarregar");
	}
	
	private JMenuItem addItem(JMenu menu, String text) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(this);
		menu.add(item);
		return item;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Abrir")){
			try {
				java.awt.Desktop.getDesktop().open(new File("src\\pedroiyoshi\\com\\github\\gui\\content.txt"));
			}catch(IOException exception) {
				JOptionPane.showMessageDialog(this, "Não foi possivel acessar o arquivo");
			}
		}else if(e.getActionCommand().equals("Adicionar simbolo")) {
			janelaAdicionar();
		}else if(e.getActionCommand().equals("Adicionar")) {
			String novosSimbolos = txtSimbolos.getText();
			Leitor.write(novosSimbolos);
			Simbolos.reload();
			janela.setVisible(false);
		}else {
			Simbolos.reload();
		}
	}
	
	private void janelaAdicionar() {
		Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
		int distanciax = (int) Math.round(tk.getWidth() - 555);
		janela.setBounds(distanciax-400, 0, 400, 150);
		janela.setTitle("Adicionar");
		janela.setVisible(true);
		janela.setResizable(false);
		JPanel painel = new JPanel();
		janela.add(painel);
		painel.setBackground(new Color(100, 100, 100));
		txtSimbolos.setFont(new Font("Arial", Font.BOLD, 40));
		txtSimbolos.setPreferredSize(new Dimension(370, 40));
		txtSimbolos.setBackground(new Color(170, 170, 170));
		txtSimbolos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		painel.add(txtSimbolos);
		JButton adicionar = new JButton("Adicionar");
		adicionar.setBackground(new Color(100, 100, 100));
		adicionar.setForeground(Color.WHITE);
		adicionar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		adicionar.setSize(100, 50);
		adicionar.setPreferredSize(new Dimension(160, 50));
		adicionar.setFont(new Font("Arial", Font.BOLD, 30));
		adicionar.addActionListener(this);
		painel.add(adicionar);
	}
}
