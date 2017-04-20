package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import app.AbstractMultimediaApp;
import application.PossibleGameApp;
import physics.Location;
import physics.Vector;
import utilities.Constants;
import visual.statik.TransformableContent;

public class Player extends Character {
	public static final int PLAYER_SIZE = 50;
	private static final int NUM_TO_MOVE = 80;
	private static final int NUM_TO_MOVE_DOUBLE = 120;

	private boolean jumping, wasMax, doubleJumping;
	private int moveCount, numToMove;
	private Location[] coordinates; // in form: top-left, top-right,
									// bottom-left, bottom-right
	private Color playerColor;

	public Player(int xPosition, int yPosition) {
		super(xPosition, yPosition, 4);
		jumping = false;
		wasMax = false;
		moveCount = 0;
		coordinates = new Location[4];
		setCoordinates();
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.drawRect((int) super.x, (int) super.y, PLAYER_SIZE, PLAYER_SIZE);
		g2.setColor(playerColor);
		g2.fillRect((int) super.x, (int) super.y, PLAYER_SIZE, PLAYER_SIZE);
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

	public void startDoubleJump() {
		doubleJumping = true;
		wasMax = false;
	}

	public void endDoubleJump() {
		doubleJumping = false;
	}

	public boolean isJumping() {
		return this.jumping;
	}

	public boolean isDoubleJumping() {
		return this.doubleJumping;
	}

	private void setCoordinates() {
		coordinates[0] = new Location(super.x, super.y);
		coordinates[1] = new Location(super.x + PLAYER_SIZE, super.y);
		coordinates[2] = new Location(super.x, super.y + PLAYER_SIZE);
		coordinates[3] = new Location(super.x + PLAYER_SIZE, super.y + PLAYER_SIZE);
	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		if (jumping) {
			numToMove = doubleJumping ? NUM_TO_MOVE_DOUBLE : NUM_TO_MOVE;
			if (!wasMax && moveCount > 0) {
				super.y -= 3;
				moveCount += 3;
				if (moveCount >= numToMove) {
					wasMax = true;
				}
			} else if (wasMax && moveCount > 0) {
				super.y += 3;
				moveCount -= 3;
			} else if (moveCount <= 10) {
				endJumping();
				endDoubleJump();
			}
		}
		setCoordinates();
	}

	public Location[] getCoordinates() {
		return this.coordinates;
	}

	public void changeColor(int lives) {
		switch (lives) {
		case 3:
			playerColor = Color.green;
			break;
		case 2:
			playerColor = Color.yellow;
			break;
		case 1:
			playerColor = Color.red;
			break;
		}
	}
}
