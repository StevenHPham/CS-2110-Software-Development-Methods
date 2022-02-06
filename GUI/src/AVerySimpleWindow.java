import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * A very simple window that has a single JLabel on it - no interactive components
 */
public class AVerySimpleWindow extends JFrame { // superclass is JFrame 
	private JLabel helloLabel;
	private FlowLayout layout = new FlowLayout();

	public void addComponentsToPane(Container pane) {

		// add components to a panel
		JPanel panel = new JPanel();

		// set options
		panel.setLayout(new FlowLayout());
		
		// label
		helloLabel = new JLabel("Hello, CS 2110!"); // Setting what the label will display
		panel.add(helloLabel); // add the label to the panel

		// add this panel to the content pane
		pane.add(panel);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		AVerySimpleWindow frame = new AVerySimpleWindow();
		frame.setTitle("Very Simple Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Describing what does the "X" does

		// Set up the content pane.
		// from: javax.swing.JFrame.getContentPane()
		frame.addComponentsToPane(frame.getContentPane());
		
		// Display the window.
		frame.pack();
		frame.setSize(300, 80); // dimensions 
		frame.setVisible(true); // Always remember to set the visibility to true!
	}

	public static void main(String[] args) {
		
		createAndShowGUI(); // start by running this method (does all the work) 
	
	}
}
