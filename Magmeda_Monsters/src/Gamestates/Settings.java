package Gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Gamesetup.Game;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class Settings extends GameState{

	public Settings(Game game) {
		super(game);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, game.width, game.height);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
		g.setColor(Color.BLACK);
		g.drawString("NOT IMPLEMENTED", 300, 330);
	}

	public void update() {
		if(game.getKBC().checkIfAnyPAR()) {
			game.setGamestate(new MainMenu(game));
		}
	}
}
