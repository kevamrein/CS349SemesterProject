import javax.swing.JPanel;

import Title.EntryScreen;
import Title.ExitScreen;
import app.AbstractMultimediaApp;

public class PossibleGameApp extends AbstractMultimediaApp {
	
	private JPanel contentPane;
	private EntryScreen entryscreen;
	private ExitScreen exitscreen;
	
	public void init() {
		
		// setup the contentPane
		contentPane = (JPanel)rootPaneContainer.getContentPane();
	    contentPane.setLayout(null);
	    
	    entryscreen = new EntryScreen();
	    exitscreen = new ExitScreen(10);
	      
	    //contentPane.add(entryscreen);
	    contentPane.add(exitscreen);
	    
	    contentPane.repaint();
	    
	    
		
	}
}
