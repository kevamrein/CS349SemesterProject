import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import app.MultimediaApplication;

/**
 * Starts a PossibleGameApplication using the MovieApp.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class PossibleGameApplication extends MultimediaApplication {
	
	public static void main (String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new PossibleGameApplication(args, 800, 400));
	}
	
	/**
	 * Creates a new MovieApplication
	 * @param args Command-line arguments
	 * @param width int width
	 * @param height int height
	 */
	public PossibleGameApplication(String[] args, int width, int height) {
		super(args, new PossibleGameApp(), width, height);
	}
}
