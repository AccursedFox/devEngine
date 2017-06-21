package com.dev.engine.system.user.experience;

public class Camera {
	protected static Object target;
	protected static double x, y;
	protected static double xOffset, yOffset;
	public Camera(Object following, double xPos, double yPos, double xOfset, double yOfset) {
		target = following;
		xOffset = xOfset;		yOffset = yOfset;
		x = (xPos - xOfset);	y = (yPos - yOfset);}
	
	public final Object getTarget() {return target;}
	public final double getX() {return x;}
	public final double getY() {return y;}
	public final double getXOffset() {return xOffset;}
	public final double getYOffset() {return yOffset;}
}
