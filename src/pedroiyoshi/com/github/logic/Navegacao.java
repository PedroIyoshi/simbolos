package pedroiyoshi.com.github.logic;

import java.awt.event.KeyEvent;

public class Navegacao {
	public int navegar(KeyEvent e, String simbolos, int selecionado) {
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
			Copiar.copiar(simbolos.charAt(selecionado) + "");
		}
		return selecionado;
	}
}
