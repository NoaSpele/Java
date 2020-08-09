package Gamestates;
import java.awt.Graphics;

import Gamesetup.Game;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public abstract class GameState {
	protected Game game;
	public GameState(Game game) {
		this.game = game;
	}
	
	public abstract void render(Graphics g);
	public abstract void update();
}
