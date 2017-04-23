package characters;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import app.AbstractMultimediaApp;
import application.PossibleGameApp;
import io.ReadFile;

public class BackGround extends JPanel
{
  private Image background;
  private ReadFile read;
  private PossibleGameApp app;
  
  public BackGround(AbstractMultimediaApp app)
  {
    super();
    this.app = (PossibleGameApp) app;
    setBounds(0, 0, 800, 400);
    read = new ReadFile();
    background = read.getImage("game.png");
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(background, 0, 0, getWidth(), getHeight(), this);

  }
}
