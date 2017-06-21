package com.dev.engine.system.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.dev.engine.system.App;

public class Filer {
	protected static final String FORMAT_TEXTURE = ".png";
	
	/*** Loads BufferedImage from <code>./assets/graphics + path + FORMAT_TEXTURE</code>.
	 * @param path location where the image is stored.
	 * @return BufferedImage or throws NullPointerException. */
	public static final BufferedImage loadTexture(String path) {
		BufferedImage bi = null;
		try {bi = ImageIO.read(App.class.getResource("/graphics" + path + FORMAT_TEXTURE));}
		catch (IOException e) {e.printStackTrace();}
		
		if(bi == null) throw new NullPointerException("Texture from [" + path + FORMAT_TEXTURE + "] wasn't found.");
		else return bi;}
}
