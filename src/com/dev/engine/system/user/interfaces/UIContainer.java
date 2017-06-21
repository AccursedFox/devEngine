package com.dev.engine.system.user.interfaces;

import java.util.LinkedList;
import java.util.List;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.handlers.events.EventUI;
import com.dev.engine.system.handlers.events.EventUI.UIActions;

public class UIContainer extends UIComponent {
	protected List<UIComponent> components = new LinkedList<UIComponent>();
	public UIContainer(Texture gui, int x, int y) {
		super(gui, x, y);
	}
	
	public final void addComponent(UIComponent uic) {components.add(uic);}
	public final void removeComponent(UIComponent uic) {components.remove(uic);}
	
	@Override public final void display() {
		if(!components.isEmpty())
			for(UIComponent c : components)
				new EventUI(c, UIActions.DISPLAY);
		
		super.display();}
	@Override public final void close() {
		if(!components.isEmpty())
			for(UIComponent c : components)
				new EventUI(c, UIActions.CLOSE);
		
		super.close();}
}
