package Input;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class ImageLoader {
	
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
