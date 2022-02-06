import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class btnPreviousListener implements ActionListener  {

	public void actionPerformed(ActionEvent e) {
		int[] x = new int[5];
		
		if (e.getActionCommand().equals("Next")) {
			File mainFile = new File(lib.getPhotos().get(x[+1]).getFilename());
			try {
				BufferedImage defaultPhoto = ImageIO.read(mainFile);
				ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(500, 350, Image.SCALE_DEFAULT));
				mainPhoto.setIcon(icon);

			}
			catch (Exception a) {
				System.out.println("Error");
			}
			
			}
			panel.add(mainPhoto);

	}

}
