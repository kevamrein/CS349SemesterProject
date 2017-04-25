package physics;

/**
 * Represents the magnitude and direction of a moving object.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Vector
{
  private double magnitude;
  private double direction;

  public Vector(double magnitude, double direction)
  {
    this.magnitude = magnitude;
    this.direction = direction;
  }

  public double getMagnitude()
  {
    return this.magnitude;
  }

  public void setMagnitude(double magnitude)
  {
    this.magnitude = magnitude;
  }

  public double getDirection()
  {
    return this.direction;
  }

  public void setDirection(double direction)
  {
    this.direction = direction;
  }
}
