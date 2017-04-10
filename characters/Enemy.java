package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

import physics.Vector;
import utilities.Constants;
import visual.statik.TransformableContent;

public class Enemy extends Character {
	private Polygon triangle;
	private int[] xPositions;
	private int[] yPositions;
	private double speed;
	public Enemy(int xPosition, int yPosition, Vector vector) {
		super(xPosition, yPosition, vector);
		xPositions = new int[]{Constants.SCREEN_WIDTH - 20, Constants.SCREEN_WIDTH - 10, Constants.SCREEN_WIDTH};
		yPositions = new int[]{Constants.LINE_Y, Constants.LINE_Y - 30, Constants.LINE_Y};
		triangle = new Polygon(xPositions, yPositions, 3);
		Random rand = new Random();
		speed = rand.nextDouble() * 3 + .1;
	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 3 ; i++) {
			xPositions[i] -= speed;
		}
		triangle = new Polygon(xPositions, yPositions, 3);
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.drawPolygon(triangle);
	}

}
