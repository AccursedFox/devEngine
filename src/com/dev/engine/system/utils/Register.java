package com.dev.engine.system.utils;

import com.dev.engine.system.Launcher;
import com.dev.engine.system.handlers.properties.IDrawable;
import com.dev.engine.system.handlers.properties.IUpdateable;
import com.dev.engine.system.user.interfaces.UIComponent;
import com.dev.engine.system.user.interfaces.UIContainer;

public class Register {
	private Register() {}
	public static final void registerTexture(IDrawable d) {Launcher.getApp().getWindow().getScreen().getTextures().add(d);}
	public static final void registerObject(IUpdateable u) {Launcher.getApp().getHandler().getObjects().add(u);}
	public static final void registerUIComponent(UIContainer c, UIComponent ui) {c.addComponent(ui);}
	
	public static final void unregisterTexture(IDrawable d) {Launcher.getApp().getWindow().getScreen().getTextures().remove(d);}
	public static final void unregisterObject(IUpdateable u) {Launcher.getApp().getHandler().getObjects().remove(u);}
	public static final void unregisterUIComponent(UIContainer c, UIComponent ui) {c.removeComponent(ui);}
}
