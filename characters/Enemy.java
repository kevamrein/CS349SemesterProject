package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.Random;

import physics.Location;
import physics.LocationUtilities;
import physics.Vector;
import utilities.Constants;
import visual.statik.TransformableContent;

public class Enemy extends Character {
	private Polygon triangle;
	private static Location[] startingLocations;
	private double speed;
	private boolean survived;
	Random rand;

	public Enemy() {
		super(100, 100, 3);
		startingLocations = new Location[3];
		startingLocations[0] = new Location(Constants.SCREEN_WIDTH - 20, Constants.LINE_Y);
		startingLocations[1] = new Location(Constants.SCREEN_WIDTH - 10, Constants.LINE_Y - 30);
		startingLocations[2] = new Location(Constants.SCREEN_WIDTH, Constants.LINE_Y);
		rand = new Random();
		survived = false;
		resetTriangle();
		triangle = new Polygon(LocationUtilities.getXPositions(coordinates),
				LocationUtilities.getYPositions(coordinates), 3);

	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {

		for (int i = 0; i < 3; i++) {
			double x = coordinates[i].getX();
			x -= speed;
			//x -= 1;
			coordinates[i].setX(x);
		}

		if (coordinates[2].getX() <= 0) {
			resetTriangle();
		}

		triangle = new Polygon(LocationUtilities.getXPositions(coordinates),
				LocationUtilities.getYPositions(coordinates), 3);
	}

	private void resetTriangle() {
		
		coordinates = LocationUtilities.copyArray(startingLocations);
		speed = rand.nextDouble() * 3 + 3;
		this.destroyed = false;
		this.survived = false;
	}
	
	public boolean getSurvived() {
		return this.survived;
	}
	
	public void survived() {
		this.survived = true;
	}

	@Override
	public void render(Graphics g) {
		if (!destroyed) {
			super.render(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.black);
			g2.drawPolygon(triangle);
		}
	}

}
