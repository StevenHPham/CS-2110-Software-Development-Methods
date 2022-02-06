import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class PhotographContainer {
	
	public String name;
	public ArrayList<Photograph> photos = new ArrayList<Photograph>();	
	private static String dateFormat = "yyyy-MM-dd";

	public PhotographContainer(String name) {
		this.name = name;
		this.photos = new ArrayList<Photograph>();
	}

	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the album
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for the hashset of photos
	 * @return photos
	 */
	public ArrayList<Photograph> getPhotos() {
		return this.photos;
	}
	
	/**
	 * add photograph p to  arraylist  photos
	 * @param p
	 * @return arraylist with new photo p
	 */
	public boolean addPhoto(Photograph p){
		if (p == null) {
			return false;
		}
		
		if (hasPhoto(p)) {
			return false;
		} else {
			photos.add(p);
			return true;
		}
	}
	
	/**
	 * check if photograph p is in arraylist photos
	 * @param p
	 * @return true if p is in photos, false if not
	 */
	public boolean hasPhoto(Photograph p) {
		if (photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * remove photograph p from arraylist photos
	 * @param p
	 * @return true if removed, false if photo is not  in the arraylist
	 */
	public boolean removePhoto(Photograph p) {
		if (hasPhoto(p)) {
			photos.remove(p);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return the  size of the arraylist
	 */
	public int numPhotographs() {
		return  photos.size();
	}
	
	/**
	 * equals method for the name of the album
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof PhotographContainer) {
			PhotographContainer a = (PhotographContainer) o;
			return (this.name == a.name);
		} else {
			return false;
		}
	}
	
	/**
	 * Add a default text when the constructor is called
	 */
	public String toString() {
		String res = this.name ;
		for(Photograph photo : photos) {
			res += photo.getFilename() + "\n";
		}
		return res;
	}
	
	/**
	 * generate a unique hashcode for each of the names
	 */
	public int hashCode() {
		return name.hashCode();
		}
	
	public ArrayList<Photograph> getPhotos(int rating){
		if (rating > 5 || rating < 0) {
			return null;
		}
		
		ArrayList<Photograph> retPhotos = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			if ( p.getRating() >= rating ) {
				retPhotos.add(p);
			}
		}
		return retPhotos;
	}
	
	
	public ArrayList<Photograph> getPhotosInYear(int year){
		if (year < 0 ) {
			return null;
		}
		ArrayList<Photograph> retPhotos = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			if (Integer.parseInt(p.getDateTaken().substring(0,4)) == year) {
				retPhotos.add(p);
			}
		}
		return retPhotos;
	}
	
	
	public ArrayList<Photograph> getPhotosInMonth(int month , int year){
		if (year < 0 || month < 0 || month > 12){
			return null;
		}
		ArrayList<Photograph> retPhotos = new ArrayList<Photograph>();
		for (Photograph p : photos) {
			if ((Integer.parseInt(p.getDateTaken().substring(0,4)) == year) && (Integer.parseInt(p.getDateTaken().substring(5,7)) == month)) {
				retPhotos.add(p);
			}
		}
		return retPhotos;
	}
	
	/**
	 * A method that get photos between a certain date
	 * @param beginDate 
	 * @param endDate
	 * @return photos within the date range
	 */
	
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate){
		if(isDateValid(beginDate) && isDateValid(endDate)) {
			ArrayList<Photograph> between = new ArrayList<Photograph>();
			String start = new String(beginDate.replace("-", "")); 			//remove the dashes from the string date 
			String end = new String(endDate.replace("-", ""));
			int s = Integer.valueOf(start); 								//change the start string to an integer
			int e = Integer.valueOf(end);									//change the end string to an integer
			if (e < s) {
				return null;
			}
			else {
				for(Photograph photo : photos) {
					String middle = new String(photo.getDateTaken().replace("-", ""));
					int m = Integer.valueOf(middle);
					if(s <= m && m  <= e) {
						between.add(photo);
					}
				}
			}
			return between;
		}
		else {
			return null;
		}
	}
	
	public static boolean isDateValid(String dateTaken) {
    	try {
    		DateFormat date = new SimpleDateFormat(dateFormat);
    		date.setLenient(false);
    		date.parse(dateTaken);
    		return true;
    	}
    	catch (ParseException e) {
    		return false;
    		}
    }
	
}
