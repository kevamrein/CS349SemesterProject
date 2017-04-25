package application;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import Title.EntryScreen;
import Title.ExitScreen;
import app.AbstractMultimediaApp;
import characters.Enemy;
import characters.Line;
import characters.NumericDisplay;
import characters.Player;
import event.MetronomeListener;
import io.ReadFile;
import physics.Location;
import utilities.Constants;
import visual.VisualizationView;
import visual.dynamic.described.Stage;

/**
 * Main class for creating the application, handling user events, playing sounds
 * and controlling the game.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class PossibleGameApp extends AbstractMultimediaApp implements KeyListener, MetronomeListener {

	/* Constants */
	private static final int ENEMY_COUNT = 4;
	private static final int LIVES_X = 600;
	private static final int LIVES_Y = 30;
	private static final int STARTING_LIVES = 3;
	private static final String LIVES_LABEL = "Lives:";
	private static final int SCORE_X = 600;
	private static final int SCORE_Y = 50;
	private static final int STARTING_SCORE = 0;
	private static final String SCORE_LABEL = "Score:";

	/* Global Variables */
	private JPanel contentPane;
	private Player player;
	private Stage visualization;
	private VisualizationView view;
	private EntryScreen entryscreen;
	private ArrayList<Enemy> enemies;
	private int createdEnemyCounter;
	private int creationBuffer;
	private NumericDisplay scoreDisplay, livesDisplay;

	/**
	 * Starts the background music and adds the EntryScreen to the content pane.
	 */
	@Override
	public void init() {

		constructClip("Music.wav", true);

		this.contentPane = (JPanel) this.rootPaneContainer.getContentPane();
		this.contentPane.setLayout(null);

		this.entryscreen = new EntryScreen(this);

		this.contentPane.add(this.entryscreen);
	}

	/**
	 * Responsible for starting the audio file
	 * 
	 * @param name
	 *            the name of the .wav file
	 * @param loop
	 *            boolean to decide if clip should loop
	 */
	public void constructClip(String name, boolean loop) {
		Clip clip = null;
		ReadFile read = new ReadFile();

		clip = read.getAudio(name);

		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}

	/**
	 * Creates ENEMY_COUNT enemies, the player, and the score and lives
	 * displays.
	 */
	public void createGameElements() {
		// Create Enemies
		this.enemies = new ArrayList<Enemy>();
		for (int i = 0; i < ENEMY_COUNT; i++) {
			this.enemies.add(new Enemy());
		}
		this.createdEnemyCounter = 0;

		this.creationBuffer = 0;

		this.livesDisplay = new NumericDisplay(LIVES_LABEL, STARTING_LIVES, LIVES_X, LIVES_Y);
		this.scoreDisplay = new NumericDisplay(SCORE_LABEL, STARTING_SCORE, SCORE_X, SCORE_Y);

		this.player = new Player(Constants.PLAYER_START_X, Constants.PLAYER_START_Y);

		this.player.changeColor(this.livesDisplay.getValue());
	}

	/**
	 * Removes all current components from the content pane and starts the game
	 * visualization.
	 */
	public void playGame() {
		this.contentPane.removeAll();

		this.visualization = new Stage(15);
		
		this.view = this.visualization.getView();
		view.setBackground(new Color(242, 239, 240));
		this.view.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.view.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.view.addKeyListener(this);

		Line l = Line.getInstance();

		this.visualization.add(l);

		this.visualization.getMetronome().addListener(this);
		this.visualization.add(this.player);

		this.visualization.add(this.livesDisplay);
		this.visualization.add(this.scoreDisplay);
		this.contentPane.add(this.view);
		this.visualization.start();
	}

	/**
	 * Removes all components from the content pane and displays the exit
	 * screen.
	 */
	private void exit() {
		this.contentPane.removeAll();
		ExitScreen exitScreen = new ExitScreen(this.scoreDisplay.getValue(), this);
		this.contentPane.add(exitScreen);
		this.contentPane.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!this.player.isJumping()) {
				this.player.startJumping();
			} else if (this.player.isJumping() && !this.player.isDoubleJumping()) {
				this.player.startDoubleJump();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		return;
	}

	/**
	 * Checks to see if the passed enemy hit the player on the side or on the
	 * top.
	 * 
	 * @param enemy
	 *            Enemy
	 * @return true if hit
	 */
	private boolean hit(Enemy enemy) {
		Location[] playerCoordinates = this.player.getCoordinates();
		Location[] enemyCoordinates = enemy.getCoordinates();
		return ((enemyCoordinates[0].getX() <= playerCoordinates[3].getX()
				&& enemyCoordinates[0].getX() >= playerCoordinates[2].getX())
				|| (enemyCoordinates[2].getX() <= playerCoordinates[3].getX()
						&& enemyCoordinates[2].getX() >= playerCoordinates[2].getX()))
				&& enemyCoordinates[1].getY() <= playerCoordinates[2].getY();
	}

	/**
	 * Checks to see if the passed enemy passed the player without hitting it.
	 * 
	 * @param enemy
	 *            Enemy
	 * @return true if passed player
	 */
	private boolean survived(Enemy enemy) {
		Location[] playerCoordinates = this.player.getCoordinates();
		Location[] enemyCoordinates = enemy.getCoordinates();

		return playerCoordinates[2].getX() > enemyCoordinates[2].getX();
	}

	@Override
	public void handleTick(int arg0) {
		// Buffer the creation of enemies at start of game
		if (this.createdEnemyCounter != ENEMY_COUNT) {
			this.creationBuffer++;
			if (this.creationBuffer == 50 || this.creationBuffer % 300 == 0) {
				this.visualization.add(this.enemies.get(this.createdEnemyCounter));
				this.createdEnemyCounter++;
			}
		}

		// For every tick check if the enemies hit or survived
		for (Enemy e : this.enemies) {
			if (!e.isDestroyed() && hit(e)) {
				e.destroy();
				if (this.livesDisplay.getValue() > 0)
					constructClip("hit.wav", false);
				this.livesDisplay.decrement();
				this.player.changeColor(this.livesDisplay.getValue());
			} else if (!e.isDestroyed() && survived(e) && !e.getSurvived()) {
				this.scoreDisplay.increment();
				e.survived();
			}
		}

		// Game over
		if (this.livesDisplay.getValue() == 0) {
			exit();
		}
	}
}
