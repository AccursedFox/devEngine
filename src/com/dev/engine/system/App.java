package com.dev.engine.system;

import java.awt.Dimension;

import com.dev.engine.system.handlers.Handler;
import com.dev.engine.system.user.Window;

public class App {
	protected static Engine engine;
	protected static float scale;
	public App(String title, Dimension res, float scaleValue, int updates, int frames) {
		engine = new Engine(title, res, updates, frames);
		scale = scaleValue;
		final Launcher launcher = new Launcher(this);
		
		launcher.launch();}
	
	public final void start() {engine.start();}
	public final Window getWindow() {return engine.getWindow();}
	public final Handler getHandler() {return engine.getHandler();}
	public final float getScale() {return scale;}
}
