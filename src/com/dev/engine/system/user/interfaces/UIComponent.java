package com.dev.engine.system.user.interfaces;

import java.awt.Graphics;

import com.dev.engine.assets.graphics.Texture;
import com.dev.engine.system.Launcher;
import com.dev.engine.system.handlers.events.EventUI;
import com.dev.engine.system.handlers.properties.IDrawable;
import com.dev.engine.system.user.Screen;
import com.dev.engine.system.utils.Register;

public class UIComponent implements IDrawable {
	protected UIComponent parent;
	protected Texture gui;
	protected int x, y;
	protected boolean displayed;
	public UIComponent() {
		this.x = 0; this.y = 0;
		this.displayed = false;
		this.parent = this;}
	public UIComponent(Texture gui) {
		this.gui = gui;
		this.x = 0; this.y = 0;
		this.displayed = false;
		
		this.parent = Launcher.getApp().getWindow().getScreen().getComponentHolder();}
	
	public final UIComponent getParent() {return parent;}
	public final int getX() {return x;}
	public final int getY() {return y;}
	public final boolean isDisplayed() {return displayed;}
	public final boolean hasParent() {return (parent != null);}
	public final Texture getTexture() {return gui;}
	public final UIComponent setPosition(int x, int y) {this.x = x; this.y = y; return this;}
	public final void draw(Graphics g, Screen screen) {g.drawImage(gui.getTexture(), getX(), getY(), screen);}
	public final void actionPreformed(EventUI.UIActions action) {new EventUI(this, action);}
	public void display() { displayed = true;}
	public void close() {Register.unregisterTexture(this); displayed = false;}
	public void action() {}
	void setParent(UIComponent uic) {this.parent = uic;}
}
