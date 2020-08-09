package Cards;

import java.util.ArrayList;
import java.util.Collections;

import Cards.Card;
import Cards.MonsterCard;
import Cards.SkillCard;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class Player {
	private ArrayList<MonsterCard> monHand;
	private ArrayList<SkillCard> skillHand;
	private ArrayList<Card> grave;
	private ArrayList<MonsterCard> monDeck;
	private ArrayList<SkillCard> skillDeck;
	private MonsterCard[] field;
	private int monsterHandOffset = 0;
	private int skillHandOffset = 0;
	
	private void init() {
		monHand = new ArrayList<MonsterCard>();
		skillHand = new ArrayList<SkillCard>();
		grave = new ArrayList<Card>();
		monDeck = new ArrayList<MonsterCard>();
		skillDeck = new ArrayList<SkillCard>();
		field = new MonsterCard[4];
	}
	
	public void playMCard(int handNum, int fieldPlacment) {
		field[fieldPlacment] = monHand.get(handNum);
		monHand.remove(handNum);
		field[fieldPlacment].reset();
		decMHC();
	}
	
	public int getMHO() {
		return monsterHandOffset;
	}
	
	public int getSHO() {
		return skillHandOffset;
	}
	
	public void incMHC() {
		if(monHand.size() < 7 || monsterHandOffset == monHand.size()-7) {
			return;
		}else {
			monsterHandOffset++;
		}
	}
	
	public void incSHC() {
		if(skillHand.size() < 7 || monsterHandOffset == monHand.size()-7) {
			return;
		}else {
			skillHandOffset++;
		}
	}
	
	public void decMHC() {
		if(monHand.size() < 7 || monsterHandOffset == 0) {
			return;
		}else {
			monsterHandOffset--;
			if(skillHandOffset < 0) {
				skillHandOffset = 0;
			}
		}
	}
	
	public void decSHC() {
		if(skillHand.size() < 7 || monsterHandOffset == 0) {
			return;
		}else {
			skillHandOffset--;
			if(skillHandOffset < 0) {
				skillHandOffset = 0;
			}
		}
	}
	
	public void drawMCard() {
		if(monDeck.size() > 0) {
			monHand.add(monDeck.get(0));
			monDeck.remove(0);
		}
	}
	
	public void drawSCard() {
		if(skillDeck.size() > 0) {
			monHand.add(monDeck.get(0));
			monDeck.remove(0);
		}
	}
	
	public void addMCard(MonsterCard card) {
		monDeck.add(card);
	}
	
	public void addSCard(SkillCard card) {
		skillDeck.add(card);
	}
	
	public void shuffle() {
		shuffleMDeck();
		shuffleSDeck();
	}
	
	public void shuffleMDeck() {
		Collections.shuffle(monDeck);
	}
	
	public void shuffleSDeck() {
		Collections.shuffle(skillDeck);
	}
	
	public ArrayList<MonsterCard> getMHand() {
		return monHand;
	}
	
	public ArrayList<SkillCard> getSHand() {
		return skillHand;
	}
	
	public ArrayList<Card> getGrave() {
		return grave;
	}
	
	public ArrayList<MonsterCard> getMDeck() {
		return monDeck;
	}
	
	public ArrayList<SkillCard> getSDeck() {
		return skillDeck;
	}
	
	public MonsterCard[] getField() {
		return field;
	}
	
	public Player() {
		init();
	}
}
