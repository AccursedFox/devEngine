package com.dev.engine.system.handlers.properties;

import java.awt.Graphics;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.user.Screen;

public interface IDrawable {
	public void draw(Graphics g, Screen screen);
	public Texture getTexture();
}
