package physics;

/**
 * Represents the location in coordinates.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Location {
	/* Instance Variables */
	private double xPosition;
	private double yPosition;

	/**
	 * Create a new Location at (xPosition, yPosition).
	 * 
	 * @param xPosition
	 *            x Coordinate
	 * @param yPosition
	 *            y Coordinate
	 */
	public Location(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	/**
	 * Create a new Location from the x and y coordinates from the passed
	 * Location.
	 * 
	 * @param location
	 *            Location to base this Location off of
	 */
	public Location(Location location) {
		this.xPosition = location.xPosition;
		this.yPosition = location.yPosition;
	}

	/**
	 * Get the x Coordinate
	 * 
	 * @return double x Coordinate
	 */
	public double getX() {
		return this.xPosition;
	}

	/**
	 * Get the Y coordinate.
	 * 
	 * @return double y coordinate
	 */
	public double getY() {
		return this.yPosition;
	}

	/**
	 * Set the x Coordinate
	 * 
	 * @param xPosition
	 *            double x coordinate
	 */
	public void setX(double xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Set the y coordinate
	 * 
	 * @param yPosition
	 *            double y coordinate
	 */
	public void setY(double yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * String representation in the form (###.#, ###.#) where the first value is
	 * the x coordinate and the second is the y coordinate.
	 */
	@Override
	public String toString() {
		return String.format("(%.1f, %.1f)", this.xPosition, this.yPosition);
	}
}
