package characters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 * A String integer display for displaying values in a Visualization
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class NumericDisplay extends AbstractSprite
{

  /* Instance Variables */
  private String label;
  private int value;

  /**
   * Creates a Numeric display with the label and starting value at position (x,y).
   * 
   * @param label
   *          String label to use in the display
   * @param startingValue
   *          int starting value for the value with the label
   * @param x
   *          int X Coordinate for the display
   * @param y
   *          int Y Coordinate for the display
   */
  public NumericDisplay(String label, int startingValue, int x, int y)
  {
    super();
    this.label = label;
    this.value = startingValue;
    super.x = x;
    super.y = y;

  }

  /**
   * Returns the value attached to the label.
   * 
   * @return value being displayed
   */
  public int getValue()
  {
    return this.value;
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
    // TODO Auto-generated method stub

  }

  /**
   * Increment the value with the label by 1.
   */
  public void increment()
  {
    this.value++;
  }

  /**
   * Decrement the value with the label by 1.
   */
  public void decrement()
  {
    this.value--;
  }

  @Override
  public void render(Graphics g)
  {
    super.render(g);
    Graphics2D g2 = (Graphics2D) g;
    Font font = new Font("Arial", Font.BOLD, 17);
    g2.setFont(font);
    g2.setColor(Color.black);
    String displayText = String.format("%s %d", this.label, this.value);
    g2.drawString(displayText, (int) this.x, (int) this.y);
  }

}
