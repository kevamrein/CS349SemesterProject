package physics;

/**
 * Represents the location in coordinates.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Location {
	private double xPosition;
	private double yPosition;
	
	public Location(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public double getX() {
		return this.xPosition;
	}
	
	public double getY() {
		return this.yPosition;
	}
	
	public void setX(double xPosition) {
		this.xPosition = xPosition;
	}
	
	public void setY(double yPosition) {
		this.yPosition = yPosition;
	}
}
