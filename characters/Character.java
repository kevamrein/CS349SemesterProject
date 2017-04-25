package characters;

import physics.Location;
import visual.dynamic.described.AbstractSprite;

/**
 * Character abstract class that has a position and coordinates each point of the character.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public abstract class Character extends AbstractSprite
{
  /* Instance Variables */
  protected Location[] coordinates;
  protected boolean destroyed;

  /**
   * Creates a Character at (xPosition, yPosition) and initializes the corner coordinate array to
   * pointCount.
   * 
   * @param xPosition
   *          int X Coordinate
   * @param yPosition
   *          int Y Coordinate
   * @param pointCount
   *          int number of vertices in the character polygon
   */
  public Character(int xPosition, int yPosition, int pointCount)
  {
    super();
    super.x = xPosition;
    super.y = yPosition;
    this.coordinates = new Location[pointCount];
    this.destroyed = false;
  }

  /**
   * Destroy character
   */
  public void destroy()
  {
    this.destroyed = true;
  }

  /**
   * Returns whether character has been destroyed
   * 
   * @return true if destroyed
   */
  public boolean isDestroyed()
  {
    return this.destroyed;
  }

  /**
   * Set the x Coordinate
   * 
   * @param x
   *          int x coordinate
   */
  public void setX(int x)
  {
    super.x = x;
  }

  /**
   * Sets the y coordinate
   * 
   * @param y
   *          int y coordinate
   */
  public void setY(int y)
  {
    super.y = y;
  }

  /**
   * Gets the x coordinate
   * 
   * @return int x coordinate
   */
  public int getX()
  {
    return (int) super.x;
  }

  /**
   * Gets the y coordinate
   * 
   * @return int y coordinate
   */
  public int getY()
  {
    return (int) super.y;
  }

  /**
   * Gets the location array containing the coordinates of the vertices in the character polygon
   * 
   * @return Location[] of vertices
   */
  public Location[] getCoordinates()
  {
    return this.coordinates;
  }

}
