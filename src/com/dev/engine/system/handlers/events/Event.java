package com.dev.engine.system.handlers.events;

import com.dev.engine.system.handlers.EventHandler;

public abstract class Event {
	protected Object source;
	public Event(Object src) {source = src; EventHandler.addEvent(this);}
	
	public abstract void actionPreforemd();
	public final Object getSource() {return source;}
	public final void consume() {source = null;}
}
