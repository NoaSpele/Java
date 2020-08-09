package Event;

import Gamesetup.Game;
import Gamestates.GameState;

public abstract class Event extends GameState{

	public Event(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public abstract boolean finished();
}
