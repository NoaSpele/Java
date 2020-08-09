package Cards;

import Input.ImageLoader;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public abstract class Card {
	protected ImageLoader il;
	protected String name;
	protected BufferedImage image1;
	
	protected int ID;
	
	public Card(String name, String path1, int ID) {
		il = new ImageLoader();
		this.name = name;
		image1 = il.loadImage(path1);
		this.ID = ID;
	}
	
	public abstract void play();
}
