import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import app.AbstractMultimediaApp;
import characters.Line;
import characters.Player;
import event.Metronome;
import utilities.Constants;
import visual.Visualization;
import visual.VisualizationView;
import visual.dynamic.described.Stage;

public class PossibleGameApp extends AbstractMultimediaApp implements KeyListener {
	JPanel contentPane;
	Player player;
	
	public void init() {
		contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setLayout(null);
		
		
		VisualizationView view;
		Metronome metronome = new Metronome(10);
		Stage visualization = new Stage(10, metronome);

		view = visualization.getView();
		view.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.addKeyListener(this);
		Line l = new Line();
		
		visualization.add(l);
		
		player = new Player(Constants.PLAYER_START_X, Constants.PLAYER_START_Y, null);
		metronome.addListener(player);
		
		visualization.add(player);
		
		contentPane.add(view);
		visualization.start();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		/*
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!player.isJumping()) {
				player.startJumping();
			}
		}
		*/
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!player.isJumping()) {
				player.startJumping();
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		/*
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!player.isJumping()) {
				player.startJumping();
			}
		}
		*/
	}

}
