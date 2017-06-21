package com.dev.engine.system.handlers;

import java.util.LinkedList;
import java.util.List;

import com.dev.engine.system.handlers.properties.IUpdateable;

public class Handler {
	protected static List<IUpdateable> objects = new LinkedList<IUpdateable>();
	public Handler() {}
	
	public final void update(double dUpdates) {}
	
	public final List<IUpdateable> getObjects() {return objects;}
}
