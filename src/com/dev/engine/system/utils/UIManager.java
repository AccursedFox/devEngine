package com.dev.engine.system.utils;

import com.dev.engine.system.handlers.InputListener;

public class UIManager {
	protected static InputListener iListener = new InputListener();
	public static final InputListener getInputListener() {return iListener;}
	
}

