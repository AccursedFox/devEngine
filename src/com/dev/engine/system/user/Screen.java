package com.dev.engine.system.user;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.List;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.handlers.properties.IDrawable;
import com.dev.engine.system.user.interfaces.UIContainer;
import com.dev.engine.system.utils.managers.UIManager;

@SuppressWarnings("serial")
public class Screen extends Canvas {
	protected static List<IDrawable> textures = new LinkedList<IDrawable>();
	protected static float scale;
	protected static GraphicsConfiguration gCfg = GraphicsEnvironment.getLocalGraphicsEnvironment()
																	.getDefaultScreenDevice()
																	.getDefaultConfiguration();
	
	static Texture texture;
	static UIContainer uic;
	
	public Screen(Dimension dimension) {
		super(gCfg);
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setSize(dimension);
		setBackground(Color.BLACK);
		
		addKeyListener(UIManager.getInputListener());
		addMouseListener(UIManager.getInputListener());
		addMouseMotionListener(UIManager.getInputListener());
		addMouseWheelListener(UIManager.getInputListener());
	}
	
	public final void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {createBufferStrategy(3); return;}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(!textures.isEmpty())
			for(IDrawable texture : textures) {
				if(texture.getTexture().isInitialized())
					texture.draw(g, this);}
		
		g.dispose();
		bs.show();
	}
	
	public final List<IDrawable> getTextures() {return textures;}
}
