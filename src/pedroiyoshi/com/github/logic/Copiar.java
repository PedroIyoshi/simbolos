package pedroiyoshi.com.github.logic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Copiar{

	public static void copiar(String simbolo) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
		String text = simbolo; 
		StringSelection selection = new StringSelection(text); 
		clipboard.setContents(selection, null);
		alt_tab();
	}
	
	private static void alt_tab() {
	    Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	    
	}
}
