package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class MouseChecker implements MouseListener, MouseMotionListener{
	
	private boolean leftPressed, rightPressed;
	private boolean leftPAR, rightPAR;
	private int posX, posY;
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public boolean checkIfPressed(String toCheck) {
		if(toCheck == "L") {
			return leftPressed;
		}
		if(toCheck == "R") {
			return rightPressed;
		}
		if(toCheck == "A") {
			return leftPressed || rightPressed;
		}
		return false;
	}
	
	public boolean checkIfPAR(String toCheck) {
		if(toCheck == "L") {
			if(leftPAR == true) {
				leftPAR = false;
				return true;
			}
		}
		if(toCheck == "R") {
			if(rightPAR == true) {
				rightPAR = false;
				return true;
			}
		}
		return false;
	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		posX = e.getX();
		posY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}else {
			return;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
			leftPAR = true;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
			rightPAR = true;
		}else {
			return;
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
