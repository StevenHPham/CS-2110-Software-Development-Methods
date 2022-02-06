import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhotoViewer extends JFrame {


	private static final long serialVersionUID = 1L;
	private PhotographContainer imageLibrary;
	private JButton actionButton;
	private JLabel infoLabel;
	private Photograph image;
	private FlowLayout layout = new FlowLayout();
	private JLabel mainPhoto = new JLabel();
	private JLabel onePhoto = new JLabel();
	private JLabel twoPhoto = new JLabel();
	private JLabel threePhoto = new JLabel();
	private JLabel fourPhoto = new JLabel();
	private JLabel fivePhoto = new JLabel();
	private JTextField txtRating;


	private JPanel panel_1 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	static PhotoLibrary lib = new PhotoLibrary("name" , 4);
	private String imageDirectory = "/Users/stevenpham/eclipse-workspace/CS2110/images/" ;
	private Photograph p1 = new Photograph("Beach",imageDirectory + "beach_pebbles_waves_150757_300x240.jpg", "2019-01-05",1);
	private Photograph p2 = new Photograph("Man",imageDirectory + "man_reflection_water_150755_300x240.jpg", "2018-02-05",2);
	private Photograph p3 = new Photograph("Night City",imageDirectory + "night_city_street_lights_150759_300x240.jpg", "2017-05-05",3);
	private Photograph p4 = new Photograph("Light",imageDirectory + "transistor_glow_bright_150754_300x240.jpg", "2016-06-05",4);
	private Photograph p5 = new Photograph("Art",imageDirectory + "wall_brush_strokes_paint_150758_300x240.jpg", "2015-10-05",5);
	
	private JLabel lblCaption = new JLabel("Caption_1");
	private JLabel lblCaption_1 = new JLabel("Caption_2");
	private JLabel lblCaption_2 = new JLabel("Caption_3");
	private JLabel lblCaption_3 = new JLabel("Caption_4");
	private JLabel lblCaption_4 = new JLabel("Caption_5");

	/**
	 * constructor of the class
	 * adds the 5 photographs to photo library and the gui
	 */
	public PhotoViewer() {
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		lib.addPhoto(p5);

		getContentPane().setLayout(null);
		
		/**
		 * Create the main panel for the main display for the photograph
		 */
		JPanel panel = new JPanel();
		panel.setBounds(190, 80, 596, 375);
		getContentPane().add(panel);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("img/"));
		panel.add(label);
		File imageFile = new File(p1.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
			mainPhoto.setIcon(icon);
		}
		catch (Exception e) {
			mainPhoto.setText("Error");
		}

		panel.add(mainPhoto);
		
		/**
		 * Button listener interface for next, previous buttons and the rating radio buttons
		 */
		class ButtonListener implements ActionListener{
			int x = 1;
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Next")) {
					File mainFile = new File(lib.getPhotos().get(x).getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(mainFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(500, 350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						System.out.println("Error");
					}
					x++;
					if (x == 5) {x = 0;}
					panel.add(mainPhoto);

				}
				if (e.getActionCommand().equals("Previous")) {
					File mainFile = new File(lib.getPhotos().get(x).getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(mainFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(500, 350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						System.out.println("Error");
					}
					x--;
					if (x == -1) {x = 4;}
					panel.add(mainPhoto);
				}
				if (e.getActionCommand().equals("rating1")) {
					lib.getPhotos().get(x).setRating(1);
				}
				if (e.getActionCommand().equals("rating2")) {
					lib.getPhotos().get(x).setRating(2);
				}
				if (e.getActionCommand().equals("rating3")) {
					lib.getPhotos().get(x).setRating(3);
				}
				if (e.getActionCommand().equals("rating4")) {
					lib.getPhotos().get(x).setRating(4);
				}
				if (e.getActionCommand().equals("rating5")) {
					lib.getPhotos().get(x).setRating(5);
				}

			}
		}
		
		/**
		 * Button declaration for next, previous, rating button groups, and sort button groups
		 */

		JButton btnNext = new JButton("Next");
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(new ButtonListener());
		btnNext.setBounds(341, 6, 48, 20);
		getContentPane().add(btnNext);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setActionCommand("Previous");
		btnPrevious.addActionListener(new ButtonListener());
		btnPrevious.setBounds(212, 2, 117, 29);
		getContentPane().add(btnPrevious);


		JRadioButton rdbtnSortByDate = new JRadioButton("Sort by Date");
		rdbtnSortByDate.setActionCommand("sortDate");
		rdbtnSortByDate.addActionListener(new ButtonListener());
		buttonGroup.add(rdbtnSortByDate);
		rdbtnSortByDate.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		rdbtnSortByDate.setBounds(333, 607, 91, 20);
		getContentPane().add(rdbtnSortByDate);

		JRadioButton rdbtnSortByCaption = new JRadioButton("Sort by Caption");
		rdbtnSortByCaption.setActionCommand("sortCaption");
		rdbtnSortByCaption.addActionListener(new ButtonListener());
		buttonGroup.add(rdbtnSortByCaption);
		rdbtnSortByCaption.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		rdbtnSortByCaption.setBounds(480, 607, 102, 20);
		getContentPane().add(rdbtnSortByCaption);

		JRadioButton rdbtnSortByRating = new JRadioButton("Sort by Rating");
		rdbtnSortByRating.setActionCommand("sortRating");
		rdbtnSortByRating.addActionListener(new ButtonListener());
		buttonGroup.add(rdbtnSortByRating);
		rdbtnSortByRating.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		rdbtnSortByRating.setBounds(190, 607, 107, 20);
		getContentPane().add(rdbtnSortByRating);

		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setActionCommand("rating1");
		radioButton.addActionListener(new ButtonListener());
		buttonGroup.add(radioButton);
		radioButton.setBounds(831, 76, 48, 20);
		getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setActionCommand("rating2");
		radioButton_1.addActionListener(new ButtonListener());
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(831, 108, 48, 20);
		getContentPane().add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setActionCommand("rating3");
		radioButton_2.addActionListener(new ButtonListener());
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(831, 140, 48, 20);
		getContentPane().add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setActionCommand("rating4");
		radioButton_3.addActionListener(new ButtonListener());
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(831, 172, 48, 20);
		getContentPane().add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setActionCommand("rating5");
		radioButton_4.addActionListener(new ButtonListener());
		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(831, 204, 48, 20);
		getContentPane().add(radioButton_4);

		txtRating = new JTextField();
		txtRating.setBackground(new Color(238, 238, 238));
		txtRating.setText("Rating");
		txtRating.setBounds(831, 38, 57, 26);
		getContentPane().add(txtRating);
		txtRating.setColumns(10);

		/**
		 * Declaration of side panels image icons
		 */

		panel_1.setBounds(6, 80, 172, 505);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		label.setIcon(new ImageIcon("img/"));
		panel.add(label);
		
		
		File imageFile_2 = new File(p1.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile_2);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(90,60,Image.SCALE_DEFAULT));
			onePhoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					File imageFile = new File(p1.getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(imageFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						mainPhoto.setText("Error");
					}

					panel.add(mainPhoto);
					
				}
			});
			onePhoto.setIcon(icon);
		}
		catch (Exception e) {
			onePhoto.setText("Error");
		}

		panel_1.add(onePhoto);

		
		
		File imageFile_3 = new File(p2.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile_3);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(90,60,Image.SCALE_DEFAULT));
			twoPhoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					File imageFile = new File(p2.getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(imageFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						mainPhoto.setText("Error");
					}

					panel.add(mainPhoto);
				}
			});
			twoPhoto.setIcon(icon);
		}
		catch (Exception e) {
			twoPhoto.setText("Error");
		}
		lblCaption.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		
		lblCaption.setText("Date taken: " + lib.getPhotos().get(0).getDateTaken() + " rating: " + lib.getPhotos().get(0).getRating());
		panel_1.add(lblCaption);

		panel_1.add(twoPhoto);



		File imageFile_4 = new File(p3.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile_4);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(90,60,Image.SCALE_DEFAULT));
			threePhoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					File imageFile = new File(p3.getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(imageFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						mainPhoto.setText("Error");
					}

					panel.add(mainPhoto);
				}
			});
			threePhoto.setIcon(icon);
		}
		catch (Exception e) {
			threePhoto.setText("Error");
		}
		
		lblCaption_1.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblCaption_1.setText("Date taken: " + lib.getPhotos().get(1).getDateTaken() + " rating: " + lib.getPhotos().get(1).getRating());
		panel_1.add(lblCaption_1);

		panel_1.add(threePhoto);

		
		
		File imageFile_5 = new File(p4.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile_5);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(90,60,Image.SCALE_DEFAULT));
			fourPhoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					File imageFile = new File(p4.getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(imageFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						mainPhoto.setText("Error");
					}

					panel.add(mainPhoto);
				}
			});
			fourPhoto.setIcon(icon);
		}
		catch (Exception e) {
			fourPhoto.setText("Error");
		}
		
		
		lblCaption_2.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblCaption_2.setText("Date taken: " + lib.getPhotos().get(2).getDateTaken() + " rating: " + lib.getPhotos().get(2).getRating());
		panel_1.add(lblCaption_2);

		panel_1.add(fourPhoto);

		
		
		File imageFile_6 = new File(p5.getFilename());
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile_6);
			ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(90,60,Image.SCALE_DEFAULT));
			fivePhoto.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					File imageFile = new File(p5.getFilename());
					try {
						BufferedImage defaultPhoto = ImageIO.read(imageFile);
						ImageIcon icon = new ImageIcon(defaultPhoto.getScaledInstance(550,350, Image.SCALE_DEFAULT));
						mainPhoto.setIcon(icon);
					}
					catch (Exception a) {
						mainPhoto.setText("Error");
					}

					panel.add(mainPhoto);
				}
			});
			fivePhoto.setIcon(icon);
		}
		catch (Exception e) {
			fivePhoto.setText("Error");
		}
		lblCaption_3.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		
		lblCaption_3.setText("Date taken: " + lib.getPhotos().get(3).getDateTaken() + " rating: " + lib.getPhotos().get(3).getRating());
		panel_1.add(lblCaption_3);

		panel_1.add(fivePhoto);
		lblCaption_4.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblCaption_4.setText("Date taken: " + lib.getPhotos().get(4).getDateTaken() + " rating: " + lib.getPhotos().get(4).getRating());
		panel_1.add(lblCaption_4);



	}
	/**
	 * getters and setters for ImageLibrary
	 * @return imageLibrary
	 */
	public PhotographContainer getImageLibrary() {
		return imageLibrary;
	}

	public void setImageLibrary(PhotographContainer imageLibrary) {
		this.imageLibrary = imageLibrary;
	}

	private static void createAndShowGUI() {
		PhotoViewer myViewer = new PhotoViewer();
		myViewer.setTitle("Steven Photo App");
		myViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myViewer.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(), (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		myViewer.setVisible(true);
		//Collections.sort(myViewer.getImageLibrary().getPhotos());
	}

	
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(()->PhotoViewer.createAndShowGUI());
	}
}




