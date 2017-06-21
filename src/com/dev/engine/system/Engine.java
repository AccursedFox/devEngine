package com.dev.engine.system;

import java.awt.Dimension;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.handlers.EventHandler;
import com.dev.engine.system.handlers.Handler;
import com.dev.engine.system.handlers.events.EventUI.UIActions;
import com.dev.engine.system.user.Window;
import com.dev.engine.system.user.interfaces.UIContainer;
import com.dev.engine.system.utils.Timer;

class Engine implements Runnable {
	protected Thread tEngine;
	protected Timer timer;
	protected Handler handler;
	protected EventHandler eHandler;
	protected Window window;
	protected boolean running;
	public Engine(String title, Dimension res, int updates, int frames) {
		timer = new Timer(updates, frames);
		handler = new Handler();
		eHandler = new EventHandler();
		window = new Window(title, res);}
	public final synchronized void start() {
		if(!running) {
			window.getFrame().pack();
			window.getFrame().setVisible(true);
			
			running = true;
			tEngine = new Thread(this);	
			tEngine.start();}
		else {return;}}
	public final synchronized void stop() {
		if(running) {
			try {tEngine.join();}
			catch (InterruptedException e) {e.printStackTrace();}
			running = false;}
		else {return;}}
	public void run() {
		while(running) {
			timer.time();
			
			eHandler.handle();
			while(timer.shouldUpdate()) {handler.update(timer.getUpdateTime());}
			while(timer.shouldRender()) {window.getScreen().render();}}}
	
	public final boolean isRunning() {return running;}
	public final EventHandler getEventHandler() {return eHandler;}
	public final Handler getHandler() {return handler;}
	public final Window getWindow() {return window;}
	
}
