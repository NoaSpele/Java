package Gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Cards.MonsterCard;
import Cards.Player;
import Event.AttackMonster;
import Event.Event;
import Event.PickStarters;
import Gamesetup.Game;
import Input.ImageLoader;
import Input.KeyboardChecker;
import Input.MouseChecker;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 * 
 * Screen size 1000 w x 660 h 
 * Small card size 100 w x 120 h
 * Large card size 432 w x 600 h
 * Card on field block size 200 w x 160 h
 * Hand area size 900 x 140 h
 *
 */

public class PlayState extends GameState{
	private ImageLoader Il;
	private MonsterCard target;
	private Event event;
	private Player p1;
	private Player p2;
	private int state = 0;
	private int px = 0, py = 0;
	private MouseChecker mc;
	private KeyboardChecker kbc;

	public PlayState(Game game) {
		super(game);
		init();
	}

	public void render(Graphics g) {
		drawField(g);
		drawCards(g);
		if(event != null) {
			event.render(g);
		}
		if(state == 2) {
			g.drawImage(target.getImage1(), 284, 30, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.BOLD, 36));
			g.drawString(getString(target.getOrgHP()), 300, 178);
			g.drawString(getString(target.getOrgATK()), 290, 272);
			g.drawString(getString(target.getOrgDEF()), 290, 354);
			g.drawString(getString(target.getMagic()), 290, 436);
		}else if(state == 1) {
			g.drawImage(Il.loadImage("/textbox1.png"), px, py, null);
		}
	}

	public void update() {
		if(kbc.checkIfKeyPAR(KeyEvent.VK_ESCAPE)) {
			game.setGamestate(new MainMenu(game));
		}else if(mc.checkIfPAR("R")) {
			if(state == 0) {
				if(game.getMC().getY() >= 340 && mc.getY() <= 460) {
					for(int i = 0;i < 4;i++) {
						if(p1.getField()[i] != null && mc.getX() >= 150+i*200 && mc.getX() <= 250+i*200) {
							target = p1.getField()[i];
							state = 2;
						}
					}
				}else if(mc.getY() >= 180 && mc.getY() <= 300) {
					for(int i = 0;i < 4;i++) {
						if(p2.getField()[i] != null && mc.getX() >= 150+i*200 && mc.getX() <= 250+i*200) {
							target = p2.getField()[i];
							state = 2;
						}
					}
				}else if(mc.getY() >= 515 && mc.getY() <= 635) {
					if(p1.getMHand().size() > 7) {
						for(int i = 0;i < 7;i++) {
							if(mc.getX() >= 90+i*120 && mc.getX() <= 190+i*120) {
								target = p1.getMHand().get(i+p1.getMHO());
								state = 2;
							}
						}
					}else {
						for(int i = 0;i < p1.getMHand().size();i++) {
							if(mc.getX() >= 90+i*120 && mc.getX() <= 190+i*120) {
								target = p1.getMHand().get(i+p1.getMHO());
								state = 2;
							}
						}
					}
				}
				else if(mc.getY() >= 25 && mc.getY() <= 145) {
					if(p2.getMHand().size() > 7) {
						for(int i = 0;i < 7;i++) {
							if(mc.getX() >= 90+i*120 && mc.getX() <= 190+i*120) {
								target = p2.getMHand().get(i+p2.getMHO());
								state = 2;
							}
						}
					}else {
						for(int i = 0;i < p2.getMHand().size();i++) {
							if(mc.getX() >= 90+i*120 && mc.getX() <= 190+i*120) {
								target = p2.getMHand().get(i+p2.getMHO());
								state = 2;
							}
						}
					}
				}
			}else {
				state = 0;
			}
		}else if(state == 2 ) {
			if(kbc.checkIfAnyPAR() || mc.checkIfPAR("L")) {
				state = 0;
			}
			//System.out.println("2");
		}else if(event != null) {
			if(event.finished()) {
				event = null;
			}
			else {
				event.update();
				game.getKBC().checkIfAnyPAR();
				mc.checkIfPAR("L");
				mc.checkIfPAR("R");
			}
		}else {
			if(state == 0) {
				if(mc.checkIfPAR("L")) {
					if(game.getMC().getY() >= 340 && mc.getY() <= 460) {
						for(int i = 0;i < 4;i++) {
							if(p1.getField()[i] != null && mc.getX() >= 150+i*200 && mc.getX() <= 250+i*200) {
								px = 200 + i*200;
								py = 340;
								target = p1.getField()[i];
								state = 1;
							}
						}
					}else if(mc.getY() >= 180 && mc.getY() <= 300) {
						for(int i = 0;i < 4;i++) {
							if(p2.getField()[i] != null && mc.getX() >= 150+i*200 && mc.getX() <= 250+i*200) {
								px = 200 + i*200;
								py = 180;
								target = p2.getField()[i];
								state = 1;
							}
						}
					}
					else if(mc.getX() >= 60 && mc.getX() <= 80 &&
							mc.getY() >= 560 && mc.getY() <= 590) {
						p1.decMHC();
					}
					else if(mc.getX() >= 920 && mc.getX() <= 940 &&
							mc.getY() >= 560 && mc.getY() <= 590) {
						p1.incMHC();
					}
					else if(mc.getX() >= 60 && mc.getX() <= 80 &&
							mc.getY() >= 70 && mc.getY() <= 100) {
						p2.decMHC();
					}
					else if(mc.getX() >= 920 && mc.getX() <= 940 &&
							mc.getY() >= 70 && mc.getY() <= 100) {
						p2.incMHC();
					}
				}else if(kbc.checkIfKeyPAR(KeyEvent.VK_D)) {
					p1.drawMCard();
					while(p1.getMHO()<p1.getMHand().size()-7) {
						p1.incMHC();
					}
				}
				else if(kbc.checkIfKeyPAR(KeyEvent.VK_P)) {
					for(int i = 0; i < 4; i++) {
						if(p1.getField()[i] == null) {
							p1.playMCard(0,i);
							break;
						}
					}
				}
				
				else if(kbc.checkIfKeyPAR(KeyEvent.VK_S)) {
					p2.drawMCard();
					while(p2.getMHO()<p2.getMHand().size()-7) {
						p2.incMHC();
					}
				}
				else if(kbc.checkIfKeyPAR(KeyEvent.VK_O)) {
					for(int i = 0; i < 4; i++) {
						if(p2.getField()[i] == null) {
							p2.playMCard(0,i);
							break;
						}
					}
				}
				kbc.checkIfAnyPAR();
			}else if(state == 1) {
				if(mc.checkIfPAR("L")) {
					if(mc.getY() >= py && mc.getY() <= py+25 &&
					   mc.getX() >= px && mc.getX() <= px+75) {
						event = new AttackMonster(game, p2.getField(), target, 180);
					}
					state = 0;
				}
				else if(kbc.checkIfAnyPAR() || mc.checkIfPAR("R")) {
					state = 0;
				}
			}
			game.getKBC().checkIfAnyPAR();
			mc.checkIfPAR("L");
			mc.checkIfPAR("R");
		}
		
		for(int i = 0; i<4; i++) {
			if(p1.getField()[i] != null) {
				if(p1.getField()[i].getHP() <= 0) {
					p1.getGrave().add(p1.getField()[i]);
					p1.getField()[i] = null;
				}
			}
			if(p2.getField()[i] != null) {
				if(p2.getField()[i].getHP() <= 0) {
					p2.getGrave().add(p2.getField()[i]);
					p2.getField()[i] = null;
				}
			}
		}
	}
	
	private String getString(int stat) {
		if(stat < 10) {
			return " " + stat;
		}else {
			return "" + stat;
		}
	}
	
	private void init() {
		Il = new ImageLoader();
		mc = game.getMC();
		kbc = game.getKBC();
		p1 = new Player();
		p2 = new Player();
		target = null;
		initDeck();
		event = new PickStarters(game, p1, p2);
	}
	
	private void initDeck() {
		for(int i = 0; i<18; i++) {
			p1.addMCard(game.cl.getMCard(i));
		}
		for(int i = 18; i<36; i++) {
			p2.addMCard(game.cl.getMCard(i));
		}
		for(int i = 0; i<21; i++) {
			p1.addSCard(game.cl.getSCard(i));
		}
		for(int i = 21; i<42; i++) {
			p2.addSCard(game.cl.getSCard(i));
		}
		p1.shuffle();
		p2.shuffle();
		for(int i = 0; i<5; i++) {
			p1.drawMCard();
		}
		for(int i = 0; i<5; i++) {
			p2.drawMCard();
		}
	}

	private void drawCards(Graphics g) {
		MonsterCard curr;
		//Draw the hand of player 1
		for(int i = p1.getMHO(); i < 7+p1.getMHO() && i<p1.getMHand().size(); i++){
			g.drawImage(p1.getMHand().get(i).getImage2(), 90+120*(i-p1.getMHO()), 515, null);
		}
		
		//Draw the hand of player 2
		for(int i = p2.getMHO(); i < 7+p2.getMHO() && i<p2.getMHand().size(); i++){
			g.drawImage(p2.getMHand().get(i).getImage2(), 90+120*(i-p2.getMHO()), 25, null);
		}
		
		//Draw the field of player 1
		for(int i = 0; i<p1.getField().length; i++) {
			curr = p1.getField()[i];
			if(curr != null) {
				g.drawImage(curr.getImage2(), 150+200*i, 340, null);
				drawStats(g, 150+200*i, 340, curr);
			}
		}
		//Draw the field of player 2
		for(int i = 0; i<p2.getField().length; i++) {
			curr = p2.getField()[i];
			if(curr != null) {
				g.drawImage(curr.getImage2(), 150+200*i, 180, null);
				drawStats(g, 150+200*i, 180, curr);
			}
		}
	}
	
	private void drawStats(Graphics g, int x, int y, MonsterCard card) {
		//Draw stats under card
		g.setColor(Color.GREEN);
		g.fillRect(x, y+120, 25, 20);
		g.setColor(Color.RED);
		g.fillRect(x+25, y+120, 25, 20);
		g.setColor(Color.BLUE);
		g.fillRect(x+50, y+120, 25, 20);
		g.setColor(new Color(163,73,164));
		g.fillRect(x+75, y+120, 25, 20);
		
		//Draw text
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 14));
		g.drawString(getString(card.getHP()), x+3, y+135);
		g.drawString(getString(card.getATK()), x+28, y+135);
		g.drawString(getString(card.getDEF()), x+53, y+135);
		g.drawString(getString(card.getMagic()), x+78, y+135);
	}
	
	private void drawField(Graphics g) {
		//Draw background
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, game.width, game.height);
		
		//Draw hand area
		g.setColor(Color.GRAY);
		g.fillRect(50, 15, 900, 140);
		g.fillRect(50, 505, 900, 140);
		
		//Draw battlefield
		g.drawRect(100, 170, 800, 320);
		g.drawLine(100, 330, 900, 330);
		g.drawLine(300, 170, 300, 490);
		g.drawLine(500, 170, 500, 490);
		g.drawLine(700, 170, 700, 490);
		
		//Draw decks
		g.drawRect(925, 170, 50, 126);
		g.drawRect(925, 364, 50, 126);
		
		//Draw endturn button
		g.drawRect(910, 315, 80, 30);
		
		//Draw hand triangles
		g.setColor(Color.ORANGE);
		int[] xp = {60,80,80};
		int[] yp = {575,560,590};
		int[] y2p = {85, 70, 100};
		g.fillPolygon(xp, yp, 3);
		g.fillPolygon(xp, y2p, 3);
		xp[0] = 940;
		xp[1] = 920;
		xp[2] = 920;
		g.fillPolygon(xp, yp, 3);
		g.fillPolygon(xp, y2p, 3);
		
		//Draw hand changer
		g.setColor(new Color(255,174,201));
		int[] xp2 = {0,20,20,0};
		int[] yp2 = {330,350,410,390};
		g.fillPolygon(xp2, yp2, 4);
		g.setColor(Color.BLACK);
		g.drawPolygon(xp2, yp2, 4);
		yp2[0] = 430; yp2[1] = 410; yp2[2] = 470; yp2[3] = 490;
		g.setColor(new Color(185,122,87));
		g.fillPolygon(xp2, yp2, 4);
		g.setColor(Color.BLACK);
		g.drawPolygon(xp2, yp2, 4);
		yp[0] = 410; yp[1] = 390; yp[2] = 430;
		xp[0] = 20; xp[1] = 0; xp[2] = 0;
		g.setColor(new Color(220, 148, 144));
		g.fillPolygon(xp, yp, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xp, yp, 3);
	}
}
