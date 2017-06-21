package com.dev.engine.system.user;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	protected static JFrame frame;
	protected static Screen screen;
	public Window(String title, Dimension dim) {
		frame = new JFrame(title);
		screen = new Screen(dim);
		frame.setSize((int)dim.getWidth(), (int)dim.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.add(screen);
	}
	
	public final JFrame getFrame() {return frame;}
	public final Screen getScreen() {return screen;}
}
