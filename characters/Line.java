package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import utilities.Constants;
import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 * A line that goes across the screen horizontally.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class Line extends AbstractSprite {
	private static final int X1 = 0;
	private static Line line;

	/**
	 * Singleton line constructor to create the AbstractSprite
	 */
	private Line() {
		super();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.orange);

		g2.drawLine(X1, Constants.LINE_Y, Constants.SCREEN_WIDTH, Constants.LINE_Y);
	}

	/**
	 * Gets the singleton instance of the line.
	 * 
	 * @return Line
	 */
	public static Line getInstance() {
		line = line == null ? new Line() : line;

		return line;
	}

	@Override
	protected TransformableContent getContent() {
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		return;

	}
}
