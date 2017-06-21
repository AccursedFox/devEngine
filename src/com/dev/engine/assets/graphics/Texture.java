package com.dev.engine.assets.graphics;

import java.awt.image.BufferedImage;

import com.dev.engine.system.Launcher;
import com.dev.engine.system.utils.Filer;
import com.dev.engine.system.utils.managers.TextureManager;

public class Texture {
	protected BufferedImage texture;
	protected boolean initialized;
	public Texture(String path) {
		texture = Filer.loadTexture(path);
		texture = TextureManager.scale(texture, Launcher.getApp().getScale());
		
		if(texture == null)	
			initialized = false;
		else
			initialized = true;
	}
	
	public final boolean isInitialized() {return initialized;}
	public final BufferedImage getTexture() {return texture;}
	public final void changeTexture(BufferedImage texture) {this.texture = texture;}
}
