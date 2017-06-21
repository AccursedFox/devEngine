package com.dev.engine.system;

import java.awt.Toolkit;

public class Launcher {
	protected static App app;
	public Launcher(App ap) {app = ap;}
	public final void launch() {
		app.getWindow().getFrame().setUndecorated(true);
		app.start();}
	
	public static final void main(String[] args) {
		@SuppressWarnings("unused")
			final App engine = new App("dev:/Engine", Toolkit.getDefaultToolkit().getScreenSize(), 0.5f, 20, 60);
	}
	
	public static final App getApp() {return app;}
}
