import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Title.EntryScreen;
import Title.ExitScreen;
import app.AbstractMultimediaApp;
import characters.Enemy;
import characters.Line;
import characters.Player;
import event.Metronome;
import event.MetronomeListener;
import utilities.Constants;
import visual.Visualization;
import visual.VisualizationView;
import visual.dynamic.described.Stage;


public class PossibleGameApp extends AbstractMultimediaApp implements KeyListener, MetronomeListener {
	private JPanel contentPane;
	private Player player;
	private Stage visualization;
	private VisualizationView view;
	private EntryScreen entryscreen;
	private ExitScreen exitscreen;
	
	public void init() {
		contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setLayout(null);
		
		entryscreen = new EntryScreen();
	    exitscreen = new ExitScreen(10);
	}
	
	private void playGame() {
		Metronome metronome = new Metronome(1400);
//		Metronome newMetronome = new Metronome(20);
		visualization = new Stage(15);
		//Visualization visualization = new Visualization();

		view = visualization.getView();
		view.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.addKeyListener(this);
		Line l = new Line();
				
		visualization.add(l);
		
		player = new Player(Constants.PLAYER_START_X, Constants.PLAYER_START_Y, null);
		
		metronome.addListener(this);
//		newMetronome.addListener(enemy);
		
		visualization.add(player);		
		
		contentPane.add(view);
		metronome.start();
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
	@Override
	public void handleTick(int arg0) {
		Enemy enemy = new Enemy(100, 100, null);
		
		visualization.add(enemy);
	}
	
}
