package Title;

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
import app.MultimediaApplet;
import application.PossibleGameApp;
import io.ReadFile;
import visual.statik.SimpleContent;

/**
 * Represents the title screen once the application starts
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class EntryScreen extends JPanel implements ActionListener {
	
	private JButton button;
	private JLabel label;
	private ReadFile reader;
	private BufferedImage image = null;
	private PossibleGameApp app;
	
	public EntryScreen(AbstractMultimediaApp app) {
		super();
		
		this.app = (PossibleGameApp)app;
		
		setBounds(0, 0, 800, 400);
		
		reader = new ReadFile();
		image = reader.getImage("Title.png");
		
		button = new JButton("Start Game");
		button.addActionListener(this);
		button.setBounds(300,275,200, 75);
		
		label = new JLabel("POSSIBLE GAME");
		label.setBounds(275, 0, 300, 300);
	
		label.setFont(new Font("Serif", Font.ITALIC, 32));
		label.setForeground(Color.WHITE);
	
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(true);
		button.setForeground(Color.WHITE);
		button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

	}
	@Override 
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    add(button);
	    add(label);
	    g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		app.playGame();
	}

}
