package Event;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Cards.Player;
import Gamesetup.Game;

public class PickStarters extends Event{
	private int step;
	private int pick;
	private Player p1;
	private Player p2;
	private boolean finished;

	public PickStarters(Game game, Player p1, Player p2) {
		super(game);
		this.p1 = p1;
		this.p2 = p2;
		step = 1;
		pick = 0;
		finished = false;
	}

	public boolean finished() {
		return finished;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		if(step == 1) {
			g.drawRect(90+pick*120, 515, 100, 120);
			g.drawRect(90+pick*120+1, 516, 98, 118);
			g.drawRect(90+pick*120+2, 517, 96, 116);
			g.drawRect(90+pick*120+3, 518, 94, 114);
		}else if(step == 2){
			g.drawRect(90+pick*120, 25, 100, 120);
			g.drawRect(90+pick*120+1, 26, 98, 118);
			g.drawRect(90+pick*120+2, 27, 96, 116);
			g.drawRect(90+pick*120+3, 28, 94, 114);
		}
	}

	public void update() {
		if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_LEFT) && pick > 0) {
			pick--;
		}
		else if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_RIGHT) && pick < 4) {
			pick++;
		}
		else if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_ENTER)) {
			if(step == 1) {
				p1.playMCard(pick, 0);
				step++;
				pick = 0;
			}else if(step == 2){
				p2.playMCard(pick, 0);
				finished = true;
			}
		}
	}

}
