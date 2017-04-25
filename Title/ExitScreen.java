package title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AbstractMultimediaApp;
import application.PossibleGameApp;
import io.ReadFile;

/**
 * Represents the GameOver screen once the player loses
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class ExitScreen extends JPanel implements ActionListener
{

  private BufferedImage image = null;
  private JButton button;
  private JLabel label, label1;
  private ReadFile reader;
  PossibleGameApp app;

  /**
   * Explicit value Constructor responsible for setting up the exit screen
   * 
   * @param score
   *          the final score of the player
   * @param app
   *          the instance of the current app
   */
  public ExitScreen(int score, AbstractMultimediaApp app)
  {
    super();

    this.app = (PossibleGameApp) app;
    setBounds(0, 0, 800, 400);

    this.reader = new ReadFile();
    this.image = this.reader.getImage("Title.png");

    this.button = new JButton("Play Again");
    this.button.setBounds(300, 275, 200, 75);
    this.button.addActionListener(this);

    this.label = new JLabel("GAME OVER");
    this.label.setBounds(300, 0, 350, 300);

    this.label.setFont(new Font("Serif", Font.ITALIC, 32));
    this.label.setForeground(Color.WHITE);

    this.label1 = new JLabel("SCORE: " + score);
    this.label1.setBounds(300, 100, 350, 300);
    this.label1.setFont(new Font("Serif", Font.ITALIC, 32));
    this.label1.setForeground(Color.WHITE);

    this.button.setOpaque(false);
    this.button.setContentAreaFilled(false);
    this.button.setBorderPainted(true);
    this.button.setForeground(Color.WHITE);
    this.button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

  }

  /**
   * Renders the the exitscreen
   * 
   * @param g
   *          the graphics object used to render
   */
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    add(this.button);
    add(this.label);
    add(this.label1);
    g2.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);
  }

  /**
   * Responsible for handling user input
   * 
   * @param e
   *          The actionEvent performed by the user
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    this.app.createGameElements();
    this.app.playGame();
  }
}
