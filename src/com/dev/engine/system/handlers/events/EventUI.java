package com.dev.engine.system.handlers.events;

import com.dev.engine.system.user.interfaces.UIComponent;

public class EventUI extends Event {
	public static enum UIActions {DISPLAY(0), OPEN(1), CLOSE(2);
		final int id;	UIActions(int id) {this.id = id;}
		public final int getId() {return id;}}
	protected UIActions action;
	public EventUI(Object source, UIActions act) {
		super(source);
		action = act;
	}
	
	public final void actionPreforemd() {
		if(getSource() instanceof UIComponent) {
			switch(action.getId()) {
			case 0: // Open UI
				if(!((UIComponent)getSource()).isDisplayed())
					((UIComponent)getSource()).display();;
				break;
			case 1: // Close UI
				((UIComponent)getSource()).action();
				break;
			case 2:
				((UIComponent)getSource()).close();
				// Should never be called
			default:
				break;}}}
}
