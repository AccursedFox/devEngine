package com.dev.engine.system.utils;

public class Timer {
	protected static int limiterUpdates, limiterFrames;
	
	protected static long timeInitial, timeEnd, timeElapsed;
	protected static double dUpdates, dGraphics;
	protected static boolean update, render;
	protected static long timer;
	public Timer(int updates, int frames) {
		timer = System.currentTimeMillis();
		limiterUpdates = (updates < 20) ? 20 : updates;
		limiterFrames = (frames < 30) ? 30 : frames;
		
		timeInitial = System.nanoTime();
		dUpdates = 0; dGraphics = 0;
		timeEnd = timeInitial;
		timeElapsed = (timeInitial - timeEnd);
		
		update = false; render = false;
	}
	
	public final void time() {
		timeInitial = System.nanoTime();
		timeElapsed = (timeInitial - timeEnd);
		dUpdates = timeElapsed / limiterUpdates;
		dGraphics = timeElapsed / limiterFrames;
	}
	
	public final boolean shouldUpdate() {
		update = (dUpdates > 1);
		if(update) {--dUpdates;}
		return update;
	}
	public final boolean shouldRender() {
		render = (dGraphics > 1);
		if(render) {--dGraphics;}
		return render;
	}

	public final double getUpdateTime() {return dUpdates;}
}
