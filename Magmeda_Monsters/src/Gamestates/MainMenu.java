package Gamestates;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Gamesetup.Game;
import Input.ImageLoader;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class MainMenu extends GameState{
	private BufferedImage bg;
	private int currOption = 1;

	public MainMenu(Game game) {
		super(game);
		ImageLoader il = new ImageLoader();
		bg = il.loadImage("/mainbg.png");
	}

	public void render(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		g.setColor(new Color(50, 50, 200, 150));
		g.fillRect(200, 80, 600, 500);
		switch(currOption) {
			case 1:
				g.setColor(new Color(0, 255, 0));
				g.fillRect(300, 130, 400, 100);
				g.setColor(new Color(255, 0, 0));
				g.fillRect(300, 280, 400, 100);
				g.fillRect(300, 430, 400, 100);
				break;
			case 2:
				g.setColor(new Color(255, 0, 0));
				g.fillRect(300, 130, 400, 100);
				g.setColor(new Color(0, 255, 0));
				g.fillRect(300, 280, 400, 100);
				g.setColor(new Color(255, 0, 0));
				g.fillRect(300, 430, 400, 100);
				break;
			case 3:
				
				g.setColor(new Color(255, 0, 0));
				g.fillRect(300, 130, 400, 100);
				g.fillRect(300, 280, 400, 100);
				g.setColor(new Color(0, 255, 0));
				g.fillRect(300, 430, 400, 100);
				break;
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 48));
		g.drawString("Play!", 430, 200);
		g.drawString("Settings", 385, 350);
		g.drawString("About", 420, 500);
	}

	public void update() {
		if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_UP)) {
			currOption--;
		}
		
		if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_DOWN)) {
			currOption++;
		}
		if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
		
		int mx = game.getMC().getX();
		int my = game.getMC().getY();
		if(mx >= 275 && mx <= 675) {
			if(my >= 125 && my <= 225) {
				currOption = 1;
			}else if(my >= 275 && my <= 375) {
				currOption = 2;
			}else if(my >= 425 && my <= 525) {
				currOption = 3;
			}
		}
		
		if(currOption > 3) {
			currOption = 3;
		}else if(currOption < 1) {
			currOption = 1;
		}
		
		if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_ENTER) == true) {
			switch(currOption) {
				case 1:
					game.setGamestate(new PlayState(game));
					break;
				case 2:
					game.setGamestate(new Settings(game));
					break;
				case 3:
					game.setGamestate(new About(game));
					break;
			}
		}
	}
}
