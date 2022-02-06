/**
 * Homework 02
 * Steven Pham, shp4df
 * 
 * Sources: Big Java Book, Oracle API Documentation
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

import javax.imageio.ImageIO;


public class Photograph implements Comparable<Photograph> {
    /*
     * Holds the name of the file and its caption
     */
	protected BufferedImage imageData;
    private String filename;
    public String caption;
    public String dateTaken = "1901-01-01";
    public int rating = 0;
    private static String dateFormat = "yyyy-MM-dd";
    public static boolean isDateValid(String dateTaken) {
    	try {
    		DateFormat df = new SimpleDateFormat(dateFormat);
    		df.setLenient(false);
    		df.parse(dateTaken);
    		return true;
    	}
    	catch (ParseException e) {
    		return false;
    		}
    	
    }
    
    public boolean loadImageData(String filename) {
    	this.filename = filename;
    	BufferedImage img;
		try {
			img = ImageIO.read(new File(filename));
			this.imageData = img;
			return img == null ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

    }
    
    public BufferedImage getImageData() {
		return imageData;
	}

	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}

	public static void main(String[] args) {
    Photograph firstPhoto = new Photograph("Moonlight","Dancing","2000-01-01",1);
//    Photograph fPhoto = new Photograph("Moonlight","Dancing");
    System.out.println(firstPhoto);
    
    Photograph secondPhoto = new Photograph("September","Do you remember","2010-01-01",1);
    System.out.println(secondPhoto);
    
    String caption = "newSept";
    Photograph thirdPhoto = new Photograph(caption,"Do you remember");
    System.out.println(thirdPhoto);
    
    
   System.out.println(firstPhoto.compareTo(thirdPhoto));
   
   

    }
/**
 * Default Constructor of the class Photograph
 *     this allows me to configure what a photograph will have using one line [15].
 * 
 * @param caption  The caption of the photograph
 * @param filename The name of the photograph
 * @param dateTaken 
 */
    public Photograph(String caption, String filename) {
        this.caption   = caption;
        this.filename  = filename;
        this.dateTaken = "1901-01-01";
        this.rating	   = 0;
    }
// Additional constructor including date taken and rating of photo
    public Photograph(String caption, String filename, String dateTaken, int rating) {
        this.caption   = caption;
        this.filename  = filename;
        this.dateTaken = dateTaken;
        this.rating    = rating;
        if (this.rating < 0 || this.rating > 5) {
        	this.rating = 0;
        }
        if(isDateValid(dateTaken)) { 			//if the date is a valid format, set it 
        	this.dateTaken = dateTaken;
        }
        if(isDateValid(dateTaken) == false) {   //otherwise, give it a default value
        	this.dateTaken = "1901-01-01";
        }
    }
    
    
/**
 * Filename Getter
 *     get the name of the file
 * 
 * @return The name of the file 
 */
    public  String getFilename() {
        return filename;
    }
/**
* Caption Getters
*       get the caption description
* 
* @return the caption of the photograph
*/
    public String getCaption() {
        return caption;
    }
/**
 * An 	 method that return true if the object's file name
 * and caption matches to the current Photograph object. Otherwise 
 * return false
 * 
 */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Photograph) { //typecast
            Photograph photo = (Photograph) other;
            return (this.filename == photo.filename) && (this.caption == photo.caption);
        } else {
            return false;
        }
    }
    /**
     * Generate a String that shows the value of the file name 
     * and the caption
     * 
     */
    public String toString() {
        return ("File name: " + this.filename + " Caption: " + this.caption + " Date Taken: " + this.dateTaken + " Rating: " + this.rating + "\n");
    }
    /**
     * getter for the date the photo was taken
     * @return the date the photo was taken
     */
	public String getDateTaken() {
		return dateTaken;
	}
	/**
	 * setter for the date taken
	 * @param dateTaken
	 */
	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}
	/**
	 * getter for the rating of the photo
	 * @return photo's rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * setter for the rating of the photo
	 * @param rating
	 */
	public void setRating(int rating) {
		if (rating >= 0 & rating <= 5) {
			this.rating = rating;
		} else {
			this.rating = 0;
		}
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * return the hashcode of the filename
	 */
	public int hashCode() {
		return filename.hashCode();
	}
	/**
	 * Compares the picture by the date. If the date are the same, compare the
	 * caption alphabetically.
	 */
	@Override
	public int compareTo(Photograph p) {
		int a = dateTaken.compareTo(p.dateTaken);
		if (a == 0) {
			a = this.caption.compareTo(p.getCaption());
			return a;
		} else {
			return a;
		}
	}
}

