/**
 * Homework 02
 * Steven Pham, shp4df
 * 
 * Sources: Big Java Book, Oracle API Documentation
 */



import java.util.*;

public class PhotoLibrary extends PhotographContainer {
    
    private int id;
    
    private HashSet<Album> albums = new HashSet<Album>();
  
   
	/**
	* Copy Constructor
	* 
	* @param name name of the file
	* @param i the unique id of the photo
	*/
    public PhotoLibrary(String name, int i) {
        super(name);
        this.id     = i;
        this.albums = new HashSet<Album>();
        this.photos = new ArrayList<Photograph>();
    }
   
    
    
    /**
     * setter for the photograph 
     * @param photos
     */
    public void setphotos(ArrayList<Photograph> photos) {
        this.photos = photos;
    }
    


    
	/**
	 * erase photo in feed
	 * @param p photograph
	 * @return true if photo is in feed and is removed, false if not
	 */
    public boolean removePhoto(Photograph p) {
    	boolean removed = false;
        if (hasPhoto(p)) {
            photos.remove(p);
            removed = true;
        }
        for (Album a : albums) {
        	if (a.hasPhoto(p)){
        		a.removePhoto(p);
        		removed = true;
        	}
        }
        return removed;
    }
    
	/**
	 * return the number of photos in the feed
	 * @return the number of photos in feed
	 */

    
    /**
     * equals method
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof PhotoLibrary) {
            PhotoLibrary lib = (PhotoLibrary) other;
            return (this.id == lib.id);
        } else {
            return false;
        }
    }
    
    /**
     * combine two photolibrary (2 photoss) to a single photos
     * if two photos are the same, post only one
     * @param a  photolibrary 1
     * @param b photolibrary 2
     * @return the common photo
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b){
        ArrayList<Photograph> common = new ArrayList<Photograph>();
        ArrayList<Photograph> a1 = (ArrayList<Photograph>) a.photos;
        ArrayList<Photograph> b1 = (ArrayList<Photograph>) b.photos;
            for (Photograph eachPhoto: b1) {
                if (a1.contains(eachPhoto)) {
                    common.add(eachPhoto);
                }
            }
            return common;   
        }
    /**
     * check whether the two libraries have the same number of photos
     * @param a photolibrary 1
     * @param b photolibrary 2
     * @return the  number of similiar photos
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        double  number = commonPhotos(a,b).size();
        if (a.photos.size() == 0 || b.photos.size() == 0) {
            return 0.0;
        } else {
            return number / Math.min(a.photos.size(), b.photos.size());
            }
        }
    
    /**
     * A toString method that prints out a default sentence when 
     * the default constructor is called upon
     */
    public String toString() {
        return ("Name: " + this.name + "\nID: " + this.id + "\nPhotos: " + this.photos + "\nAlbums: " + this.albums + "\n");
    }
    
    /**
     * getter for photos
     * @return arraylist of photos
     */

    
    /**
     * setter for photos
     * @param photos
     */
    public void setPhotos(ArrayList<Photograph> photos) {
        this.photos = photos;
    }
    
    /**
     * getter for the id of the photo
     * @return id of the photo
     */
    public int getId() {
        return id;
    }
    
    /**
     * getter for album
     * @return
     */
	public HashSet<Album> getAlbums() {
		return albums;
	}
	

	/**
	 * Create a new album
	 * 	
	 * @param albumName
	 * @return true if album is created
	 */
	public boolean createAlbum(String albumName) {
		Album newAlbum = new Album(albumName);
		return albums.add(newAlbum);
	}
	
	/**
	 * Remove the album from the Photolibrary
	 * 
	 * @param albumName
	 * @return true if the album is removed, false if otherwise
	 */
	public boolean removeAlbum(String albumName) {
		Album newAlbum = new Album(albumName);
		return albums.remove(newAlbum);
	}
	
	
	
	/**
	 * Add a photo to the album set in PhotoLibrary
	 * @param p
	 * @param albumName
	 * @return true if added, false if otherwise
	 */
	
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if (p == null) {
			return false;
		}
		boolean added = false;
		if (!photos.contains(p)) { //if photo is not in photo, don't add it album
			return added;
		}
		
		for (Album a : albums) {
			if (a.getName() == albumName) { 
				if (!a.hasPhoto(p)) { // if album name equals albumName and	 photo is not in album, add it to album 
					a.addPhoto(p);
					added = true;
				}
			}
		}		
		return added;
	}
	
	/**
	 * Remove photo from album
	 * @param p
	 * @param albumName
	 * @return true if removed, false if not
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		boolean removed = false;
		for (Album a : albums) {
			if (a.getName() == albumName) {
				if (removed) {
					a.removePhoto(p);
				} else {
					removed = a.removePhoto(p);
				}
			} 
		}
		return removed;
	}
	
	/**
	 * return the string name of the album
	 * @param albumName
	 * @return string name of the album
	 */
	private Album getAlbumByName(String albumName) {
		for (Album a : albums) {
			if (a.getName() == albumName) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * Check if the format of the date string is same as the default date taken 
	 * @param dateTaken
	 * @return true if same, otherwise return false
	 */
   

    public static void main(String[] args) {
    
	    PhotoLibrary user1 = new PhotoLibrary("some name" , 10 );
	    PhotoLibrary user2 = new PhotoLibrary("name 2" , 100 );
	   
	    Photograph p = new Photograph("cap","filename");
	    Photograph p2 = new Photograph("Caption" , "Name", "2019-04-29",5);
	    System.out.println(user1);
	    System.out.println(user2);
	    
	    System.out.println(user1.getName());
	    System.out.println(user1.addPhoto(p));
	    System.out.println(user1.addPhoto(p2));
	    System.out.println(user2.addPhoto(p));
	    System.out.println(user1.hasPhoto(p));
	    System.out.println(user2.hasPhoto(p) + "\n");
	    
	    System.out.println(user1);
	    System.out.println(user2+"\n");
	    
//	    System.out.println(user1.erasePhoto(p));
//	    System.out.println(user2.erasePhoto(p));
	    System.out.println(user2.numPhotographs());
	    System.out.println(user1.numPhotographs());
    	System.out.println(p.getDateTaken().subSequence(5, 7));
    	
	    PhotoLibrary testLib = new PhotoLibrary("name",1);
	    testLib.addPhoto(p2);
	    System.out.println(testLib.addPhoto(p2));
	    System.out.println(testLib);
	    
	  
	    
	    
   
    
    
    }
}




