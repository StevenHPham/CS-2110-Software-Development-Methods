// import the swing library and awt resources
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//extend JFrame
public class SimpleWindow extends JFrame {
    // set form controls as instance variables
    private JButton actionButton;
    private JLabel infoLabel;
    private JTextArea textArea;
    // a layout object determines how controls are drawn on the panel
    private FlowLayout layout = new FlowLayout();
    
    // the main method invokes the createAndShowGUI method
    // using a runnable object
    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() { // ** ANONYMOUS CLASS **
                public void run() {     // Runnable -> Interface! Needs: run()
                   createAndShowGUI();
                }
            });
    } // --- END main ---
    
    // createAndShowGUI creates an instance of the current
    // class and displays it
     private static void createAndShowGUI() {
            //Create and set up the window. 
            SimpleWindow frame = new SimpleWindow();
            frame.setTitle("Simple Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Set up the content pane.
            frame.addComponentsToPane(frame.getContentPane());
            //Display the window.
            frame.pack();
            frame.setVisible(true);
        } // --- END createAndShowGUI ---
     
     public void addComponentsToPane(Container pane) { //takes an item of type Container 
         
        // create an inner class for the button action
        class ButtonListener implements ActionListener { // ** INNER CLASS **
            
            // Implement the ActionListener's actionPerformed method; 
            // this is the actual event-handling method
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("click")) {
                infoLabel.setText("Display something"); // change label to say "Button clicked" after button was clicked. 
                }
            }
        } // --- END ButtonListener inner class --- 
        
        
        // add components to a panel
        JPanel panel = new JPanel();
       
        // set options
        panel.setLayout(layout);
        layout.setAlignment(FlowLayout.CENTER);
        
        // initialize and add elements to the frame
        // button
        actionButton = new JButton("Hit me!");
        actionButton.setActionCommand("click");
        actionButton.addActionListener(new ButtonListener()); // add ActionListener
             // Task to perform once button is clicked is found in "actionPerformed" method
        panel.add(actionButton);
        
        // label
        infoLabel = new JLabel("Awaiting input");
        panel.add(infoLabel);
        
        textArea = new JTextArea(1,10);
        panel.add(textArea);
                
        // add this panel to the content pane
        pane.add(panel);
    } // --- END addComponentsToPane ---
}