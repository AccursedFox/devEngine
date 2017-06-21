package com.dev.engine.system.handlers.events;

import com.dev.engine.system.Launcher;
import com.dev.engine.system.user.interfaces.UIComponent;
import com.dev.engine.system.user.interfaces.UIContainer;
import com.dev.engine.system.utils.Register;

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
			
			case 0:
				if(!((UIComponent)getSource()).isDisplayed())
					Register.registerTexture(((UIComponent)getSource())); break;
			case 1:
				if(((UIComponent)getSource()).getParent() != Launcher.getApp().getWindow().getScreen().getComponentHolder()) {
					if(((UIComponent)getSource()).getParent() != null) {
						Register.registerUIComponent(((UIContainer)((UIComponent)getSource()).getParent()), (UIComponent)getSource());}
					else {}}
				else {
					Register.registerUIComponent(Launcher.getApp().getWindow().getScreen().getComponentHolder(), (UIComponent)getSource());}
			case 2: Register.unregisterTexture(((UIComponent)getSource()));	break;
			default: break;}}}
}
