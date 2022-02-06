import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
	JLabel instructions;
	JButton submit;
	JTextArea enterArea;
	
	JLabel livesRemaining;
	JLabel lettersEntered;
	JLabel wordOutput;
	
	
	boolean[] lettersCorrect = {false, false, false, false, false};
	int lives;
	String password;
	ArrayList<String> letters;
	
	public static void main(String[] args) {
		new GUILLOfFortune();
	}
	
	public GUILLOfFortune()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);
		
		password = "super";
		lives = 5;
		letters = new ArrayList<String>();
		
		instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>" );
		submit = new JButton("ENTER");
		enterArea = new JTextArea();
		livesRemaining = new JLabel("Lives: " + lives);
		lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
		wordOutput = new JLabel("_ _ _ _ _");
		wordOutput.setFont(new Font("Times", Font.BOLD, 20));
		
		instructions.setSize(23*width/60, height/6);
		submit.setSize(width/3, 50);
		enterArea.setSize(width/3, 50);
		livesRemaining.setSize(width/4, height/12);
		lettersEntered.setSize(width/3, height/3);
		wordOutput.setSize(width/2, height/6);
		
		instructions.setLocation(width/15, 1);
		submit.setLocation(width/2, height/2);
		enterArea.setLocation(width/6, height/2);
		livesRemaining.setLocation(11*width/15, 1);
		lettersEntered.setLocation(17*width/30, height/20);
		wordOutput.setLocation(width/3, height/3);
		
		submit.addActionListener(new passwordButtonListener());
		
		this.add(instructions);
		this.add(submit);
		this.add(enterArea);
		this.add(livesRemaining);
		this.add(lettersEntered);
		this.add(wordOutput);
		
		this.add(new JLabel());
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class passwordButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
				if (enterArea.getText().length() == 1) {
					if (lives == 0) {
						instructions.setText("Game Over");
					} else {
						if (letters.contains(enterArea.getText())){
							instructions.setText("Letter is already used. Try again");
						} else {
							if (password.contains(enterArea.getText())) {
								StringBuilder text = new StringBuilder(wordOutput.getText());
								letters.add(enterArea.getText());
								lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
								char letter = enterArea.getText().charAt(0);
								if (letter == 's') {
									text.setCharAt(0, letter);
									wordOutput.setText(text.toString());
								} 
								if (letter == 'u') {
									text.setCharAt(2, letter);
									wordOutput.setText(text.toString());
								}
								if (letter == 'p') {
									text.setCharAt(4, letter);
									wordOutput.setText(text.toString());
								}
								if (letter == 'e') {
									text.setCharAt(6, letter);
									wordOutput.setText(text.toString()); 
								}
								if (letter == 'r') {
									text.setCharAt(8, letter);
									wordOutput.setText(text.toString()); 
								}
								if (wordOutput.getText().contains("_") == false) {
									instructions.setText("You solved it!");
								}
							} else {
								lives --;
								livesRemaining.setText("Lives: " + lives);
								letters.add(enterArea.getText());
								lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
						
						}
					}
				}
			}
		}
	}
 }


