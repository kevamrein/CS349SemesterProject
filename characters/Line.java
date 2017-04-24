package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import utilities.Constants;
import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

public class Line extends AbstractSprite
{
  private static final int X1 = 0;

  public Line()
  {
    super();
  }

  @Override
  public void render(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.orange);

    g2.drawLine(X1, Constants.LINE_Y, Constants.SCREEN_WIDTH, Constants.LINE_Y);
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

}
