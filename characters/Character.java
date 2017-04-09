package characters;
import java.awt.Graphics;

import physics.*;
import visual.dynamic.described.AbstractSprite;
import visual.statik.SimpleContent;

public abstract class Character extends AbstractSprite {
	private Location location;
	private Vector vector;
	private boolean destroyed;
	
	public Character (int xPosition, int yPosition, Vector vector) {
		super();
		super.x = xPosition;
		super.y = yPosition;
		this.vector = vector;
		this.destroyed = false;
	}
	public void destroy() {
		this.destroyed = true;
	}
	
	public void setX(int x) {
		super.x = x;
	}
	
	public void setY(int y) {
		super.y = y;
	}
	
	public int getX() {
		return (int) super.x;
	}
	
	public int getY() {
		return (int) super.y;
	}
	
}
