package com.dev.engine.system.user.interfaces;

import java.awt.Graphics;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.handlers.events.EventUI;
import com.dev.engine.system.handlers.properties.IDrawable;
import com.dev.engine.system.user.Screen;
import com.dev.engine.system.utils.Register;

public class UIComponent implements IDrawable {
	protected UIComponent parent;
	protected Texture gui;
	protected int x, y;
	protected boolean displayed;
	public UIComponent(Texture gui, int x, int y) {
		this.gui = gui;
		this.x = x;	this.y = y;
		
		displayed = false;
		
			// This needs to be changed
			// TODO : Make main uicomponent in screen and make every component child of it.
		parent = null;
	}
	
	public final UIComponent getParent() {return parent;}
	public final int getX() {return x;}
	public final int getY() {return y;}
	public final boolean isDisplayed() {return displayed;}
	public final boolean hasParent() {return (parent != null);}
	public final Texture getTexture() {return gui;}
	public final void setPosition(int x, int y) {this.x = x; this.y = y;}
	public final void draw(Graphics g, Screen screen) {g.drawImage(gui.getTexture(), getX(), getY(), screen);}
	public final void actionPreformed(EventUI.UIActions action) {new EventUI(this, action);}
	public void display() {Register.registerTexture(this); displayed = true;}
	public void close() {Register.unregisterTexture(this); displayed = false;}
	public void action() {}
	void setParent(UIComponent uic) {this.parent = uic;}
}
