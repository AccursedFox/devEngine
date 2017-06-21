package com.dev.engine.system.utils.managers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.dev.engine.system.Launcher;

public class TextureManager {
	private TextureManager() {}
	public static final BufferedImage scale(BufferedImage bi, float scale) {
		BufferedImage scaled = new BufferedImage((int)(bi.getWidth() * scale), (int)(bi.getHeight() * scale), bi.getType());
		Graphics2D g = scaled.createGraphics();
		g.scale(scale, scale);
		g.drawImage(bi, 0, 0, Launcher.getApp().getWindow().getScreen());
		g.dispose();
		
		return scaled;}
	
	public static final BufferedImage rotate(BufferedImage bi, double angle) {
		BufferedImage rotated = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
		
		return rotated;
	}
	
}
