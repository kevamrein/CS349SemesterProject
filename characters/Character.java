package characters;
import java.awt.Graphics;

import physics.*;
import visual.dynamic.described.AbstractSprite;
import visual.statik.SimpleContent;

public abstract class Character extends AbstractSprite {
	private Location location;
	protected Location[] coordinates;
	protected boolean destroyed;
	
	public Character (int xPosition, int yPosition, int pointCount) {
		super();
		super.x = xPosition;
		super.y = yPosition;
		coordinates = new Location[pointCount];
		this.destroyed = false;
	}
	public void destroy() {
		this.destroyed = true;
	}
	
	public boolean isDestroyed() {
		return this.destroyed;
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
	
	public Location[] getCoordinates() {
		return this.coordinates;
	}
	
}
