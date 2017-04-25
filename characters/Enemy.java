package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

import physics.Location;
import physics.LocationUtilities;
import utilities.Constants;
import visual.statik.TransformableContent;

/**
 * Enemy is a triangle that represents a horizontally moving object.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Enemy extends Character {

	/* Instance variables */
	private Polygon triangle;
	private static Location[] startingLocations;
	private double speed;
	private boolean survived;
	private Random rand;

	/**
	 * Creates a new Enemy off the right side of the screen.
	 */
	public Enemy() {
		super(100, 100, 3);
		startingLocations = new Location[3];
		startingLocations[0] = new Location(Constants.SCREEN_WIDTH - 20, Constants.LINE_Y);
		startingLocations[1] = new Location(Constants.SCREEN_WIDTH - 10, Constants.LINE_Y - 30);
		startingLocations[2] = new Location(Constants.SCREEN_WIDTH, Constants.LINE_Y);
		this.rand = new Random();
		this.survived = false;
		resetTriangle();
		this.triangle = new Polygon(LocationUtilities.getXPositions(this.coordinates),
				LocationUtilities.getYPositions(this.coordinates), 3);

	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {

		for (int i = 0; i < 3; i++) {
			double x = this.coordinates[i].getX();
			x -= this.speed;
			this.coordinates[i].setX(x);
		}

		if (this.coordinates[2].getX() <= 0) {
			resetTriangle();
		}

		this.triangle = new Polygon(LocationUtilities.getXPositions(this.coordinates),
				LocationUtilities.getYPositions(this.coordinates), 3);
	}

	/**
	 * Sets the current coordinates to the starting coordinates so Enemy can
	 * "wrap" about the screen and resets the variables.
	 */
	private void resetTriangle() {
		this.coordinates = LocationUtilities.copyArray(startingLocations);
		this.speed = this.rand.nextDouble() * 3 + 3;
		this.destroyed = false;
		this.survived = false;
	}

	/**
	 * Returns whether the Enemy "survived" or not.
	 * 
	 * @return true if survived
	 */
	public boolean getSurvived() {
		return this.survived;
	}

	/**
	 * Enemy survived
	 */
	public void survived() {
		this.survived = true;
	}

	@Override
	public void render(Graphics g) {
		if (!this.destroyed) {
			super.render(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.black);
			g2.drawPolygon(this.triangle);
			//g2.fillPolygon(this.triangle);
		}
	}

}
