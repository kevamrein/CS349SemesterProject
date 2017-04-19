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
import application.PossibleGameApp;
import io.ReadFile;

public class ExitScreen extends JPanel implements ActionListener {
	private JButton button;
	private JLabel label, label1;
	private ReadFile reader;
	private BufferedImage image = null;
	PossibleGameApp app;
	
	public ExitScreen(int score, AbstractMultimediaApp app) {
		super();

		this.app = (PossibleGameApp) app;
		setBounds(0, 0, 800, 400);
		
		reader = new ReadFile();
		image = reader.getImage("Title.png");
		
		button = new JButton("Play Again");
		button.setBounds(300,275,200, 75);
		button.addActionListener(this);
		
		label = new JLabel("GAME OVER");
		label.setBounds(300, 0, 350, 300);
	
		label.setFont(new Font("Serif", Font.ITALIC, 32));
		label.setForeground(Color.WHITE);
	
		label1 = new JLabel("SCORE: " + score);
		label1.setBounds(300,100,350,300);
		label1.setFont(new Font("Serif", Font.ITALIC, 32));
		label1.setForeground(Color.WHITE);
		
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
	    add(label1);
	    g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);

	}

	public void actionPerformed(ActionEvent e) {
		app.createGameElements();
		app.playGame();
	}


}
