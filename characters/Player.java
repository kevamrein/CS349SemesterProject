package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import physics.Location;
import utilities.Constants;
import visual.statik.TransformableContent;

/**
 * Represents the square player in the game
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Player extends Character
{

  /* Constants */
  public static final int PLAYER_SIZE = 50;
  private static final int NUM_TO_MOVE = 80; // Single jump
  private static final int NUM_TO_MOVE_DOUBLE = 120; // Double jump

  /* Instance Variables */
  private boolean jumping, wasMax, doubleJumping;
  private int moveCount, numToMove;
  private Location[] coordinates; // in form: top-left, top-right,
  // bottom-left, bottom-right
  private Color playerColor;

  /**
   * Create a new player at (xPosition, yPosition).
   * 
   * @param xPosition
   *          int X Coordinate
   * @param yPosition
   *          int Y Coordinate
   */
  public Player(int xPosition, int yPosition)
  {
    super(xPosition, yPosition, 4);
    this.jumping = false;
    this.wasMax = false;
    this.moveCount = 0;
    this.coordinates = new Location[4];
    setCoordinates();
  }

  @Override
  public void render(Graphics g)
  {
    super.render(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.black);
    g2.drawRect((int) super.x, (int) super.y, PLAYER_SIZE, PLAYER_SIZE);
    g2.setColor(this.playerColor);
    g2.fillRect((int) super.x, (int) super.y, PLAYER_SIZE, PLAYER_SIZE);
  }

  /**
   * Begins the single jumping action of the player
   */
  public void startJumping()
  {
    this.jumping = true;
    this.moveCount++;
  }

  /**
   * Ends the single jumping of the player and resets the jumping variables
   */
  private void endJumping()
  {
    this.jumping = false;
    this.wasMax = false;
    this.moveCount = 0;
    super.y = Constants.PLAYER_START_Y;
  }

  /**
   * Starts the double jump action for the player.
   */
  public void startDoubleJump()
  {
    this.doubleJumping = true;
    this.wasMax = false;
  }

  /**
   * Ends the double jumping for the player and resets the necessary variables.
   */
  public void endDoubleJump()
  {
    this.doubleJumping = false;
  }

  /**
   * Returns whether the player is single jumping.
   * 
   * @return true if single jump in progress
   */
  public boolean isJumping()
  {
    return this.jumping;
  }

  /**
   * Returns whether the player is double jumping.
   * 
   * @return true if double jump in progress
   */
  public boolean isDoubleJumping()
  {
    return this.doubleJumping;
  }

  /**
   * Sets the coordinates of each corner of the player.
   */
  private void setCoordinates()
  {
    this.coordinates[0] = new Location(super.x, super.y);
    this.coordinates[1] = new Location(super.x + PLAYER_SIZE, super.y);
    this.coordinates[2] = new Location(super.x, super.y + PLAYER_SIZE);
    this.coordinates[3] = new Location(super.x + PLAYER_SIZE, super.y + PLAYER_SIZE);
  }

  @Override
  protected TransformableContent getContent()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void handleTick(int arg0)
  {
    // Move on each tick if jumping and allow double jumping at any time
    // while in progress of jumping
    if (this.jumping)
    {
      this.numToMove = this.doubleJumping ? NUM_TO_MOVE_DOUBLE : NUM_TO_MOVE;
      if (!this.wasMax && this.moveCount > 0)
      {
        super.y -= 3;
        this.moveCount += 3;
        if (this.moveCount >= this.numToMove)
        {
          this.wasMax = true;
        }
      }
      else if (this.wasMax && this.moveCount > 0)
      {
        super.y += 3;
        this.moveCount -= 3;
      }
      else if (this.moveCount <= 10)
      {
        endJumping();
        endDoubleJump();
      }
    }

    // Set new coordinates based on the jumping
    setCoordinates();
  }

  /**
   * Gets the Location array containing the coordinates for each corner of the player.
   */
  @Override
  public Location[] getCoordinates()
  {
    return this.coordinates;
  }

  /**
   * Changes the color based on the number of lives left Green = 3 lives left Yellow = 2 lives left
   * Red = 1 life left
   * 
   * @param lives
   *          int lives left
   */
  public void changeColor(int lives)
  {
    switch (lives)
    {
      case 3:
        this.playerColor = Color.green;
        break;
      case 2:
        this.playerColor = Color.yellow;
        break;
      case 1:
        this.playerColor = Color.red;
        break;
    }
  }
}
