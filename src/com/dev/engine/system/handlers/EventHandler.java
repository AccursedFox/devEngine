package com.dev.engine.system.handlers;

import java.util.Stack;

import com.dev.engine.system.handlers.events.Event;

public class EventHandler {
	protected static Stack<Event> events = new Stack<Event>();
	public EventHandler() {}
	
	public final void handle() {
		if(!events.empty()) {
			events.peek().actionPreforemd();
			events.pop();
		}
	}
	
	public static final void addEvent(Event e) {events.add(e);}
	
}
