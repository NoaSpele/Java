package Cards;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class ArtifactCard extends SkillCard{
	private Type type;
	public static enum Type{
		OFFENSIVE,
		DEFENSIVE,
		MAGIC
	}

	public ArtifactCard(String name, String path1, int ID, Type type) {
		super(name, path1, ID);
		this.type = type; 
	}

	public Type getType() {
		return type;
	}
}
