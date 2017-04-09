package characters;
import physics.*;
import visual.dynamic.described.DescribedSprite;

public abstract class Character extends DescribedSprite implements Moveable, Drawable {
	private Location location;
	private Vector vector;
	private boolean destroyed;
	
	public Character (Location location, Vector vector) {
		super();
		this.location = location;
		this.vector = vector;
		this.destroyed = false;
	}
	
	public void destroy() {
		this.destroyed = true;
	}

	/* Getters and Setters */
	
	public Location getLocation() {
		return location;
	}

	public Vector getVector() {
		return vector;
	}
	
	public boolean getDestroyed() {
		return this.destroyed;
	}
}
