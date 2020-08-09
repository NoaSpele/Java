package Event;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Cards.MonsterCard;
import Cards.Player;
import Gamesetup.Game;

public class AttackMonster extends Event{
	private int pick;
	private boolean finished = false;
	private int y = 0;
	private MonsterCard[] field;
	private MonsterCard attacker;

	public AttackMonster(Game game, MonsterCard[] field, MonsterCard attacker, int y) {
		super(game);
		this.y = y;
		this.field = field;
		this.attacker = attacker;
		pick = -1;
		findInitPick();
	}

	private void findInitPick() {
		for(int i = 0; i < field.length; i++) {
			if(field[i] != null) {
				pick = i;
				break;
			}
		}
		if(pick < 0) {
			finished = true;
		}
	}

	public void render(Graphics g) {
		if(!finished) {
			g.setColor(Color.RED);
			g.drawRect(150+pick*200, y, 100, 120);
			g.drawRect(150+pick*200+1, y+1, 98, 118);
			g.drawRect(150+pick*200+2, y+2, 96, 116);
			g.drawRect(150+pick*200+3, y+3, 94, 114);
		}
	}

	public void update() {
		if(!finished) {
			if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_LEFT) && pick > 0) {
				for(int i = pick-1; i>=0; i--) {
					if(field[i] != null) {
						pick = i;
						break;
					}
				}
			}
			else if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_RIGHT) && pick < 3) {
				for(int i = pick+1; i<4; i++) {
					if(field[i] != null) {
						pick = i;
						break;
					}
				}
			}
			else if(game.getKBC().checkIfKeyPAR(KeyEvent.VK_ENTER)) {
				field[pick].attack(attacker.getATK());
				finished = true;
			}
		}
	}

	public boolean finished() {
		return finished;
	}

}
