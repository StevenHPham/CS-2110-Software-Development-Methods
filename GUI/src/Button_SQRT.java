// import the swing library and awt resources
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//extend JFrame
public class Button_SQRT extends JFrame { // class extends JFrame
	// set form controls as instance variables
	private JButton actionButton;
	private JLabel infoLabel;
	private JLabel resultLabel;
	private JTextField inputTextField;
	
	// a layout object determines how controls are drawn on the panel
	private FlowLayout layout = new FlowLayout();
	
	// the main method invokes the createAndShowGUI method
	public static void main(String[] args) {
	    Button_SQRT gui1 = new Button_SQRT();
	    gui1.createAndShowGUI();
	} // --- END main ---
	
	// createAndShowGUI creates a frame and sets the content pane up to add components
	// then displays it
	 private static void createAndShowGUI() {
	        //Create and set up the window. 
		 	Button_SQRT frame = new Button_SQRT();
	        frame.setTitle("SQRT Example - Adding Components"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what the 'x' button does
	        frame.setSize(450, 120);
	        //This will center the JFrame in the middle of the screen (optional)
	        frame.setLocationRelativeTo(null);
	        //Set up the content pane by calling another method "addComponentsToPane"
	        frame.addComponentsToPane(frame.getContentPane()); // pass in the content pane
	        //Display the window.
	        //frame.pack(); // automatically packs components in a certain way 
	                      // (play around with having this here or commenting it out)
	        frame.setVisible(true); // so that all things show up, set visibility to "true"!
	                                // NOT optional unless you wish to see nothing :) 
	    } // --- END createAndShowGUI ---
	 
	 // Where most of the work takes place. 
	 // Creating components and adding them to a panel and then onto the content pane
	 public void addComponentsToPane(Container pane) { //takes an item of type Container 
		 
		 class ButtonListener implements ActionListener{
			 public void actionPerformed(ActionEvent e) {
				 if (e.getActionCommand().equals("click")) {
				 }
			 }
		 }
		 
		 
		// add components to a panel
        JPanel panel = new JPanel();
       
        // set options
        panel.setLayout(layout); // specify that the FlowLayout should be used 
        layout.setAlignment(FlowLayout.CENTER);
		
        // initialize and add elements to the frame
        // ----------------------------------------
        
		// label
		infoLabel = new JLabel("Enter a number to get it's square-root:");
		panel.add(infoLabel, BorderLayout.NORTH);   // NORTH = add to the "top" of the panel
		
		// text field
		inputTextField = new JTextField(10);
		inputTextField.setText("25"); // puts a default value into the text field (optional) 
		panel.add(inputTextField, BorderLayout.NORTH); // add to panel
        
		// button
		actionButton = new JButton("Click Me! Currently I do nothing!");
		actionButton.setActionCommand("click");
		actionButton.addActionListener(new ButtonListener());
		panel.add(actionButton, BorderLayout.NORTH); // add to panel
		
		// label
		resultLabel = new JLabel("Result: ");
		//resultLabel.setVisible(false); //later if we only want it to show after values are
		        // entered, can initially make this label's visibility false 
		panel.add(resultLabel, BorderLayout.SOUTH); // SOUTH = add to the "bottom" of the panel

		// add this panel to the content pane
		pane.add(panel);
	} // --- END addComponentsToPane ---
}
