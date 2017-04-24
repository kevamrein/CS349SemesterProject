package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;

import Title.EntryScreen;
import Title.ExitScreen;
import app.AbstractMultimediaApp;
import characters.Enemy;
import characters.Line;
import characters.NumericDisplay;
import characters.Player;
import event.Metronome;
import event.MetronomeListener;
import io.ReadFile;
import physics.Location;
import utilities.Constants;
import visual.Visualization;
import visual.VisualizationView;
import visual.dynamic.described.Stage;

public class PossibleGameApp extends AbstractMultimediaApp implements KeyListener, MetronomeListener {
	private static final int ENEMY_COUNT = 4;
	private static final int LIVES_X = 600;
	private static final int LIVES_Y = 30;
	private static final int STARTING_LIVES = 3;
	private static final String LIVES_LABEL = "Lives:";
	private static final int SCORE_X = 600;
	private static final int SCORE_Y = 50;
	private static final int STARTING_SCORE = 0;
	private static final String SCORE_LABEL = "Score:";

	private JPanel contentPane;
	private Player player;
	private Stage visualization;
	private VisualizationView view;
	private EntryScreen entryscreen;
	private ArrayList<Enemy> enemies;
	private int createdEnemyCounter;
	private int creationBuffer;
	private NumericDisplay scoreDisplay, livesDisplay;

	public void init() {
		
	
		AudioInputStream stream;
		Clip clip = null;
		ReadFile read = new ReadFile();
		
		contentPane = (JPanel) rootPaneContainer.getContentPane();
		contentPane.setLayout(null);

		entryscreen = new EntryScreen(this);

		contentPane.add(entryscreen);
		
		clip = read.getAudio("Music.wav");
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();

	}

	public void createGameElements() {
		// Create Enemies
		enemies = new ArrayList<Enemy>();
		for (int i = 0; i < ENEMY_COUNT; i++) {
			enemies.add(new Enemy());
		}
		createdEnemyCounter = 0;

		livesDisplay = new NumericDisplay(LIVES_LABEL, STARTING_LIVES, LIVES_X, LIVES_Y);
		scoreDisplay = new NumericDisplay(SCORE_LABEL, STARTING_SCORE, SCORE_X, SCORE_Y);
		
		player = new Player(Constants.PLAYER_START_X, Constants.PLAYER_START_Y);
		
		player.changeColor(livesDisplay.getValue());
	}

	public void playGame() {
		contentPane.removeAll();
		// Metronome newMetronome = new Metronome(20);
		visualization = new Stage(15);
		// Visualization visualization = new Visualization();
		// metronome = new Metronome(1400);

		view = visualization.getView();
		view.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		view.addKeyListener(this);
		Line l = new Line();

		visualization.add(l);

		// metronome.addListener(this);
		visualization.getMetronome().addListener(this);
		// newMetronome.addListener(enemy);

		visualization.add(player);

		visualization.add(livesDisplay);
		visualization.add(scoreDisplay);

		contentPane.add(view);
		// metronome.start();
		visualization.start();
	}

	private void exit() {
		contentPane.removeAll();
		ExitScreen exitScreen = new ExitScreen(scoreDisplay.getValue(), this);
		contentPane.add(exitScreen);
		contentPane.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/*
		 * if (e.getKeyCode() == KeyEvent.VK_SPACE) { if (!player.isJumping()) {
		 * player.startJumping(); } }
		 */
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!player.isJumping()) {
				player.startJumping();
			} else if (player.isJumping() && !player.isDoubleJumping()) {
				player.startDoubleJump();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * if (e.getKeyCode() == KeyEvent.VK_SPACE) { if (!player.isJumping()) {
		 * player.startJumping(); } }
		 */
	}

	private boolean hit(Enemy enemy) {
		Location[] playerCoordinates = player.getCoordinates();
		Location[] enemyCoordinates = enemy.getCoordinates();
		return ((enemyCoordinates[0].getX() <= playerCoordinates[3].getX()
				&& enemyCoordinates[0].getX() >= playerCoordinates[2].getX())
				|| (enemyCoordinates[2].getX() <= playerCoordinates[3].getX()
						&& enemyCoordinates[2].getX() >= playerCoordinates[2].getX()))
				&& enemyCoordinates[1].getY() <= playerCoordinates[2].getY();
	}

	private boolean survived(Enemy enemy) {
		Location[] playerCoordinates = player.getCoordinates();
		Location[] enemyCoordinates = enemy.getCoordinates();

		return playerCoordinates[2].getX() > enemyCoordinates[2].getX();
	}

	@Override
	public void handleTick(int arg0) {
		if (createdEnemyCounter != ENEMY_COUNT) {
			creationBuffer++;
			if (creationBuffer == 50 || creationBuffer % 300 == 0) {
				visualization.add(enemies.get(createdEnemyCounter));
				createdEnemyCounter++;
			}
		}

		for (Enemy e : enemies) {
			if (!e.isDestroyed() && hit(e)) {
				e.destroy();
				livesDisplay.decrement();
				player.changeColor(livesDisplay.getValue());
			} else if (!e.isDestroyed() && survived(e) && !e.getSurvived()) {
				scoreDisplay.increment();
				e.survived();
			}
		}

		if (livesDisplay.getValue() == 0) {
			exit();
		}
	}
}
