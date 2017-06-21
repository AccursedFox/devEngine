package com.dev.engine.system.handlers;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, InputMethodListener {
	protected static final short KEYS = 256;
	protected static final byte BUTTONS = 5;
	
	protected static boolean[] keys = new boolean[KEYS];
	protected static boolean[] buttons = new boolean[BUTTONS];
	protected static int mouseX = 0, mouseY = 0;
	protected static int scroll;
	public InputListener() {}
	
	@Override public void keyPressed(KeyEvent e) {keys[e.getKeyCode()] = true;}
	@Override public void keyReleased(KeyEvent e) {keys[e.getKeyCode()] = false;}
	@Override public void mousePressed(MouseEvent e) {buttons[e.getButton()] = true;}
	@Override public void mouseReleased(MouseEvent e) {buttons[e.getButton()] = false;}
	@Override public void mouseDragged(MouseEvent e) {mouseX = e.getX(); mouseY = e.getY();}
	@Override public void mouseMoved(MouseEvent e) {mouseX = e.getX(); mouseY = e.getY();}
	@Override public void mouseWheelMoved(MouseWheelEvent e) {scroll = e.getWheelRotation();}
	
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
	
	@Override public void inputMethodTextChanged(InputMethodEvent e) {}
	@Override public void caretPositionChanged(InputMethodEvent e) {}
	
	public final boolean getKeyState(int key) {return keys[key];}
	public final boolean getButtonState(int button) {return buttons[button];}
	public final boolean isMouseInBounds(int x, int y, int width, int height) {
		return (mouseX > x && mouseX < width && mouseY > y && mouseY < height) ? true : false;
		
	}
}
