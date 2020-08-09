package Input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardChecker implements KeyListener{
	private boolean[] keys;
	private boolean[] presAndRel;
	
	public KeyboardChecker() {
		keys = new boolean[256];
		presAndRel = new boolean[256];
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		presAndRel[e.getKeyCode()] = false;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		presAndRel[e.getKeyCode()] = true;
	}
	
	public boolean checkIfKeyIsPressed(int toCheck) {
		return keys[toCheck];
	}
	
	public boolean checkIfKeyPAR(int toCheck) {
		if(presAndRel[toCheck] == true) {
			presAndRel[toCheck] = false;
			return true;
		}
		return false;
	}
	
	public boolean checkIfAnyPAR(){
		for(int i = 0; i<presAndRel.length; i++) {
			if(presAndRel[i] == true) {
				presAndRel[i] = false;
				return true;
			}
		}
		return false;
	}

}
