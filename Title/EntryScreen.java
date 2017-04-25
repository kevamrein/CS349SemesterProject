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
 * Represents the title screen once the application starts
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class EntryScreen extends JPanel implements ActionListener
{

  private JButton button;
  private JLabel label;
  private ReadFile reader;
  private BufferedImage image = null;
  private PossibleGameApp app;

  /**
   * Explicit value constructor responsible for constructing the EntryScreen
   * 
   * @param app
   *          the instance of the current app.
   */

  public EntryScreen(AbstractMultimediaApp app)
  {
    super();

    this.app = (PossibleGameApp) app;

    setBounds(0, 0, 800, 400);

    this.reader = new ReadFile();
    this.image = this.reader.getImage("Title.png");

    this.button = new JButton("Start Game");
    this.button.addActionListener(this);
    this.button.setBounds(300, 275, 200, 75);

    this.label = new JLabel("POSSIBLE GAME");
    this.label.setBounds(275, 0, 300, 300);

    this.label.setFont(new Font("Serif", Font.ITALIC, 32));
    this.label.setForeground(Color.WHITE);

    this.button.setOpaque(false);
    this.button.setContentAreaFilled(false);
    this.button.setBorderPainted(true);
    this.button.setForeground(Color.WHITE);
    this.button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

  }

  @Override
  /**
   * Renders the EntryScreen
   * 
   * @param g
   *          The graphics object
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    add(this.button);
    add(this.label);
    g2.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);

  }

  /**
   * Responsible for handling all the events invoked by the user
   * 
   * @param e
   *          The ActionEvent invoked
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    // TODO Auto-generated method stub
    this.app.createGameElements();
    this.app.playGame();
  }
}
