package Gamesetup;

import java.util.ArrayList;

import Cards.ArtifactCard;
import Cards.ArtifactCard.Type;
import Cards.MonsterCard;
import Cards.MonsterCard.EffectType;
import Cards.SkillCard;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class CardLoader {
	private ArrayList<MonsterCard> monsterCards;
	private ArrayList<SkillCard> skillCards;
	
	public CardLoader() {
		init();
	}
	
	private void init() {
		monsterCards = new ArrayList<MonsterCard>();
		skillCards = new ArrayList<SkillCard>();
		loadMonsters();
		loadSkills();
		createDecks();
	}
	
	//Name, path1, path2, id, off, def, hp, energy, magic, effecttype, elements
	private void loadMonsters() {
		//Opposition
		//Merzago 0
		monsterCards.add(new MonsterCard("Merzago", "/Cards1/merzago1.png", "/Cards2/merzago2.png", 0, 20, 6, 22, 47, 4, EffectType.PASSIVE, null));
		
		//Tessro 1
		monsterCards.add(new MonsterCard("Tessro", "/Cards1/tessero1.png", "/Cards2/tessero2.png", 1, 10, 0, 15, 5, 0, EffectType.ACTIVE, null));

		//Yar 2
		monsterCards.add(new MonsterCard("Yar", "/Cards1/yar1.png", "/Cards2/yar2.png", 2, 20, 1, 19, 54, 6, EffectType.ACTIVE, null));

		//Woddolo 3
		monsterCards.add(new MonsterCard("Woddolo", "/Cards1/woddolo1.png", "/Cards2/woddolo2.png", 3, 10, 7, 20, 42, 7, EffectType.PASSIVE, null));

		//Kaocyborg 4
		monsterCards.add(new MonsterCard("Kaocyborg", "/Cards1/kaoscyborg1.png", "/Cards2/kaoscyborg2.png", 4, 14, 7, 20, 82, 0, EffectType.ACTIVE, null));

		//Slatara 5
		monsterCards.add(new MonsterCard("Slatara", "/Cards1/slatara1.png", "/Cards2/slatara2.png", 5, 16, 4, 20, 89, 2, EffectType.PASSIVE, null));

		//Two-headed Dino 6
		monsterCards.add(new MonsterCard("Two-headed Dino", "/Cards1/twoheadeddino1.png", "/Cards2/twoheadeddino2.png", 6, 17, 3, 22, 73, 4, EffectType.ACTIVE, null));

		//Krytodox 7
		monsterCards.add(new MonsterCard("Krytodox", "/Cards1/krytodox1.png", "/Cards2/krytodox2.png", 7, 18, 3, 22, 55, 3, EffectType.PASSIVE, null));

		//Ashwolf 8
		monsterCards.add(new MonsterCard("Ashwolf", "/Cards1/ashwolf1.png", "/Cards2/ashwolf2.png", 8, 16, 3, 23, 91, 1, EffectType.PASSIVE, null));

		//Adonas 9
		monsterCards.add(new MonsterCard("Adonas", "/Cards1/adonas1.png", "/Cards2/adonas2.png", 9, 16, 5, 23, 61, 6, EffectType.ACTIVE, null));

		//Zidius 10
		monsterCards.add(new MonsterCard("Zidius", "/Cards1/zidius1.png", "/Cards2/zidius2.png", 10, 18, 4, 24, 94, 5, EffectType.ACTIVE, null));

		//Noralaz Knight 11
		monsterCards.add(new MonsterCard("Noralaz Knight", "/Cards1/noralaz1.png", "/Cards2/noralaz2.png", 11, 15, 6, 27, 52, 1, EffectType.PASSIVE, null));

		//Paor 12
		monsterCards.add(new MonsterCard("Paor", "/Cards1/paor1.png", "/Cards2/paor2.png", 12, 22, 6, 28, 77, 2, EffectType.PASSIVE, null));

		//Krytodox U 13
		monsterCards.add(new MonsterCard("Krytodox U", "/Cards1/krytodoxU1.png", "/Cards2/krytodoxU2.png", 13, 25, 5, 28, 55, 4, EffectType.ULTRA, null));

		//Urio 14
		monsterCards.add(new MonsterCard("Urio", "/Cards1/urio1.png", "/Cards2/urio2.png", 14, 20, 2, 30, 85, 3, EffectType.PASSIVE, null));

		//Two-headed Dino U 15
		monsterCards.add(new MonsterCard("Two-headed Dino U", "/Cards1/thdU1.png", "/Cards2/thdU2.png", 15, 22, 6, 32, 73, 6, EffectType.ULTRA, null));

		//Noralaz Knight U 16
		monsterCards.add(new MonsterCard("Noralaz Knight U", "/Cards1/noralazU1.png", "/Cards2/noralazU2.png", 16, 18, 10, 34, 52, 2, EffectType.ULTRA, null));

		//Gigantos 17
		monsterCards.add(new MonsterCard("Gigantos", "/Cards1/gigantos1.png", "/Cards2/gigantos2.png", 17, 14, 2, 40, 18, 2, EffectType.PASSIVE, null));

		//Liberation
		//Tolass 18
		monsterCards.add(new MonsterCard("Tolass", "/Cards1/tolass1.png", "/Cards2/tolass2.png", 18, 15, 20, 13, 10, 2, EffectType.PASSIVE, null));

		//Helia Sky 19
		monsterCards.add(new MonsterCard("Helia Sky", "/Cards1/helia1.png", "/Cards2/helia2.png", 19, 12, 2, 14, 80, 6, EffectType.ACTIVE, null));
		
		//Loria 20
		monsterCards.add(new MonsterCard("Loria", "/Cards1/loria1.png", "/Cards2/loria2.png", 20, 12, 3, 20, 31, 4, EffectType.ACTIVE, null));
		
		//Mindi 21
		monsterCards.add(new MonsterCard("Mindi", "/Cards1/mindi1.png", "/Cards2/mindi2.png", 21, 14, 4, 20, 90, 7, EffectType.PASSIVE, null));

		//Dindi 22
		monsterCards.add(new MonsterCard("Dindi", "/Cards1/dindi1.png", "/Cards2/dindi2.png", 22, 14, 6, 20, 90, 4, EffectType.PASSIVE, null));

		//Lindi 23
		monsterCards.add(new MonsterCard("Lindi", "/Cards1/lindi1.png", "/Cards2/lindi2.png", 23, 16, 4, 20, 90, 4, EffectType.ACTIVE, null));

		//Exorp 24
		monsterCards.add(new MonsterCard("Exorp", "/Cards1/exorp1.png", "/Cards2/exorp2.png", 24, 19, 2, 20, 92, 6, EffectType.ACTIVE, null));

		//Gepardo 25
		monsterCards.add(new MonsterCard("Gepardo", "/Cards1/gepardo1.png", "/Cards2/gepardo2.png", 25, 13, 1, 21, 100, 2, EffectType.PASSIVE, null));

		//Healer of Almeyn 26
		monsterCards.add(new MonsterCard("Healer of Almeyn", "/Cards1/healer1.png", "/Cards2/healer2.png", 26, 15, 4, 22, 65, 5, EffectType.PASSIVE, null));

		//Ortion 27
		monsterCards.add(new MonsterCard("Ortion", "/Cards1/ortion1.png", "/Cards2/ortion2.png", 27, 17, 5, 22, 48, 3, EffectType.PASSIVE, null));

		//Daio 28
		monsterCards.add(new MonsterCard("Daio", "/Cards1/daio1.png", "/Cards2/daio2.png", 28, 18, 8, 22, 76, 8, EffectType.PASSIVE, null));

		//Mainar 29
		monsterCards.add(new MonsterCard("Mainar", "/Cards1/mainar1.png", "/Cards2/mainar2.png", 29, 8, 0, 24, 40, 0, EffectType.PASSIVE, null));

		//V6H12 30
		monsterCards.add(new MonsterCard("V6H12", "/Cards1/v6h121.png", "/Cards2/v6h122.png", 30, 16, 4, 24, 62, 3, EffectType.ACTIVE, null));

		//Seranon 31
		monsterCards.add(new MonsterCard("Seranon", "/Cards1/seranon1.png", "/Cards2/seranon2.png", 31, 16, 4, 24, 45, 10, EffectType.PASSIVE, null));

		//Indi, Link of Gods 32
		monsterCards.add(new MonsterCard("Indi, Link of Gods", "/Cards1/indi1.png", "/Cards2/indi2.png", 32, 17, 6, 24, 90, 5, EffectType.ACTIVE, null));

		//Yrajax 33
		monsterCards.add(new MonsterCard("Yrajax", "/Cards1/yrajax1.png", "/Cards2/yrajax2.png", 33, 18, 5, 25, 80, 1, EffectType.ACTIVE, null));

		//Zina 34
		monsterCards.add(new MonsterCard("Zina", "/Cards1/zina1.png", "/Cards2/zina2.png", 34, 18, 5, 27, 60, 6, EffectType.PASSIVE, null));

		//Saiku 35
		monsterCards.add(new MonsterCard("Saiku", "/Cards1/saiku1.png", "/Cards2/saiku2.png", 35, 21, 1, 32, 78, 4, EffectType.PASSIVE, null));
	}
	
	//Name, path1, id
	private void loadSkills() {
		//Opposition
		skillCards.add(new SkillCard("Henkai Ghosts", "", 0));
		skillCards.add(new SkillCard("Hennalin Curse", "", 1));
		skillCards.add(new SkillCard("Zidadona", "", 2));
		skillCards.add(new SkillCard("Ultra Battle Serum", "", 3));
		skillCards.add(new SkillCard("Berserk Rampage", "", 4));
		skillCards.add(new SkillCard("Mercenaries' Prize", "", 5));
		skillCards.add(new SkillCard("Diminishing Virus", "", 6));
		skillCards.add(new SkillCard("Decomposing Virus", "", 7));
		skillCards.add(new SkillCard("Erupting Earth", "", 8));
		skillCards.add(new SkillCard("Senkai Ghost", "", 9));
		skillCards.add(new SkillCard("Clock of Sacrifies", "", 10));
		skillCards.add(new SkillCard("Dagger of Sacrifice", "", 11));
		skillCards.add(new SkillCard("Assasinate", "", 12));
		skillCards.add(new SkillCard("Soul Harvest", "", 13));
		skillCards.add(new SkillCard("Poison Bomb", "", 14));
		skillCards.add(new SkillCard("Bloodcrazed Assault", "", 15));
		skillCards.add(new ArtifactCard("Demonguard Amulet", "", 16, Type.MAGIC));
		skillCards.add(new ArtifactCard("Hellfire Crystal", "", 17, Type.MAGIC));
		skillCards.add(new ArtifactCard("Shadow Shroud", "", 18, Type.DEFENSIVE));
		skillCards.add(new ArtifactCard("Flame Mask", "", 19, Type.OFFENSIVE));
		skillCards.add(new ArtifactCard("Wrath's Clotus", "", 20, Type.OFFENSIVE));

		//Liberation
		skillCards.add(new SkillCard("Arravil of the Gods", "", 21));
		skillCards.add(new SkillCard("Cosmic Gathering", "", 22));
		skillCards.add(new SkillCard("Harness Spirit", "", 23));
		skillCards.add(new SkillCard("Holy Elements", "", 24));
		skillCards.add(new SkillCard("Wave of Endurance", "", 25));
		skillCards.add(new SkillCard("Rush of Power", "", 26));
		skillCards.add(new SkillCard("Starfall", "", 27));
		skillCards.add(new SkillCard("Elemental Overload", "", 28));
		skillCards.add(new SkillCard("Circle of Flame", "", 29));
		skillCards.add(new SkillCard("Catalyst's Healing", "", 30));
		skillCards.add(new SkillCard("Spell Restoration", "", 31));
		skillCards.add(new SkillCard("Assault Formation", "", 32));
		skillCards.add(new SkillCard("Cleansing Burst", "", 33));
		skillCards.add(new SkillCard("Light Magic: Heartwill", "", 34));
		skillCards.add(new SkillCard("Light Magic: Courage", "", 35));
		skillCards.add(new ArtifactCard("Barkya Potion", "", 36, Type.MAGIC));
		skillCards.add(new ArtifactCard("Blue Notos", "", 37, Type.MAGIC));
		skillCards.add(new ArtifactCard("Aura of Heaven", "", 38, Type.DEFENSIVE));
		skillCards.add(new ArtifactCard("Reflective Armor", "", 39, Type.DEFENSIVE));
		skillCards.add(new ArtifactCard("Crush Blade", "", 40, Type.OFFENSIVE));
		skillCards.add(new ArtifactCard("Stavira", "", 41, Type.OFFENSIVE));
	}
	
	private void createDecks() {
		
	}
	
	public MonsterCard getMCard(int id) {
		if(monsterCards.size() > id) {
			return monsterCards.get(id);
		}
		return null;
	}
	
	public SkillCard getSCard(int id) {
		if(skillCards.size() > id) {
			return skillCards.get(id);
		}
		return null;
	}
}
