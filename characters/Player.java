package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import physics.Location;
import physics.Vector;
import utilities.Constants;
import visual.statik.TransformableContent;

public class Player extends Character {
	public static final int PLAYER_SIZE = 50;
	private static final int NUM_TO_MOVE = 80;
	
	private boolean jumping, wasMax;
	private int moveCount;
	
	public Player(int xPosition, int yPosition, Vector vector) {
		super(xPosition, yPosition, vector);
		jumping = false;
		wasMax = false;
		moveCount = 0;
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.drawRect((int)super.x, (int)super.y, PLAYER_SIZE, PLAYER_SIZE);
	}
	
	public void startJumping() {
		jumping = true;
		moveCount++;
	}
	
	private void endJumping() {
		jumping = false;
		wasMax = false;
		moveCount = 0;
		super.y = Constants.PLAYER_START_Y;
	}
	
	public boolean isJumping() {
		return this.jumping;
	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		if (jumping) {
			if (!wasMax && moveCount > 0) {
				super.y-=3;
				moveCount+=3;
				if (moveCount >= NUM_TO_MOVE) {
					wasMax = true;
				}
			} else if (wasMax && moveCount > 0) {
				super.y+=3;
				moveCount-=3;
			} else if (moveCount <= 0) {
				endJumping();
			}
		}
		
	}
}
