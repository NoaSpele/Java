package Cards;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class MonsterCard extends Card{
	private BufferedImage image2;
	private int orgATK, orgDEF, orgHP;
	private int atk, def, hp, energy, magic;
	private boolean hasMagic, hasEffect;
	private EffectType etype;
	private Element[] elems;
	
	public static enum EffectType{
		PASSIVE,
		ACTIVE,
		ULTRA
	}
	
	public static enum Element{
		EARTH,
		HEAVEN,
		FIRE,
		NATURE,
		ICE,
		MAGIC,
		METAL,
		THUNDER
	}

	public MonsterCard(String name, String path1, String path2, int ID, int orgATK, 
					   int orgDEF, int orgHP, int energy, int magic, EffectType etype,
					   Element[] elems) {
		super(name, path1, ID);
		image2 = super.il.loadImage(path2);
		this.orgATK = orgATK;
		this.orgDEF = orgDEF;
		this.orgHP = orgHP;
		this.energy = energy;
		this.magic = magic;
		this.etype = etype;
		this.elems = elems;
		atk = orgATK;
		def = orgDEF;
		hp = orgHP;
		hasMagic = true;
	}
	
	public void useEffect() {
	}
	
	public boolean isElem(Element toCheck) {
		for(int i = 0; i<elems.length; i++) {
			if(elems[i] == toCheck) {
				return true;
			}
		}
		return false;
	}
	
	public void play() {
	}
	
	public void reset() {
		hp = orgHP;
		atk = orgATK;
		def = orgDEF;
		hasMagic = true;
		hasEffect = true;
	}
	
	public int getOrgATK() {
		return orgATK;
	}
	
	public int getATK() {
		return atk;
	}
	
	public void setATK(int newATK) {
		atk = newATK;
	}
	
	public int getOrgDEF() {
		return orgDEF;
	}
	
	public int getDEF() {
		return def;
	}
	
	public void setDEF(int newDEF) {
		atk = newDEF;
	}
	
	public int getOrgHP() {
		return orgHP;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP(int newHP) {
		hp = newHP;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public int getMagic() {
		return magic;
	}
	
	public boolean hasMagic() {
		return hasMagic;
	}
	
	public boolean hasEffect() {
		return hasEffect;
	}
	
	public EffectType getEffect() {
		return etype;
	}
	
	public BufferedImage getImage1() {
		return image1;
	}
	
	public BufferedImage getImage2() {
		return image2;
	}
	
	public void attack(int dmg) {
		if(def<dmg) {
			hp = hp-dmg+def;
		}
		if(hp<0) {
			hp=0;
		}
	}
}
