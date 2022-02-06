import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;

/* Very simple example of adding a single component onto a frame */
/* OneButton class extends JFrame */
public class AddOneButton extends JFrame {
   public static void main(String[] args) {
      JFrame frame = new JFrame(); // create a frame
      JButton button = new JButton("Click me!"); // create a button
      // select what the 'X' button does when clicked (typically exit)
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // add the button:
      frame.getContentPane().add(button);

      frame.setSize(200, 200); // dimensions 
      frame.setVisible(true); // show the frame
   }
}

