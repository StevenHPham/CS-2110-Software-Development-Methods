/**
 * Homework 02
 * Steven Pham, shp4df
 * 
 * 
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoLibraryTest {
	PhotoLibrary testLib;
	PhotoLibrary testLib2;
	PhotoLibrary testLib3;
	Photograph p1;
	Photograph p2;
	Photograph p3;
	Photograph p4;
	Album a1;
	
	
	@Before
	public void setup() {
		p1 = new Photograph("At the beach with my friends!","Ocean City Shore","2019-04-29",4);
		p2 = new Photograph("caption","filename 1","2019-04-29",4);
		p3 = new Photograph("new cap","new name","2018-04-29",1);
		p4 = new Photograph("new cap","new name 1","2018-04-29",1);
		
		
		testLib  = new PhotoLibrary("library", 8);
		testLib2 = new PhotoLibrary("library2", 2);
		testLib3 = new PhotoLibrary("library3", 3);
		
		a1 = new Album("Summer 2019");
		
		
		testLib.addPhoto(p1);
		testLib.addPhoto(p2);
		testLib.addPhoto(p3);
		
		testLib2.addPhoto(p1);
		testLib2.addPhoto(p2);
		testLib2.addPhoto(p3);
		
		System.out.println(testLib3.addPhoto(p4));
		
		
		
//		testLib.erasePhoto(p1);
		
		
		
//		testLib.getPhotos(1);
//		testLib.getPhotos(5);
//		testLib.getPhotos(6);
//		
//		testLib.getPhotosInMonth(04, 2018);
//		testLib.getPhotosInMonth(04, 2019);
////		
//		testLib.erasePhoto(p3);
//		testLib.erasePhoto(p2);
	}
	
	
	@Test
	public void testGetPhotoPass() {		
		assertTrue(testLib.getPhotos(4).size() == 2);
	}
	
	@Test
	public void testGetPhotoPass2() {		
		assertEquals(testLib.getPhotos(4).size() , 2);
	}
	
	@Test
	public void testGetPhotoFail() {
		assertFalse(testLib.getPhotos(5) == null);
	}
	
	@Test
	public void testGetPhotosInMonthPass() {
		assertTrue(testLib.getPhotosInMonth(04, 2019).size() == 2);
	}
	
	@Test
	public void testGetPhotosInMonthFail() {
		assertFalse(testLib.getPhotosInMonth(04, 2020) == null);
	}

	@Test
	public void testGetPhotosBetweenPass() {
		assertTrue(testLib.getPhotosBetween("2019-01-01", "2020-01-01").size() == 2);
	}
	
	@Test
	public void testGetPhotosBetweenFail() {
		assertTrue(testLib.getPhotosBetween("0000-01-01", "2000-01-01") == null);
	}
	
	@Test
	public void testErasePhotoPass() {
		assertTrue(testLib.removePhoto(p1));
	}
	
	@Test
	public void testErasePhotoFail() {
		assertFalse(testLib.removePhoto(p4));
	}
	
	@Test
	public void testSimilarityPass() {
		double sim = PhotoLibrary.similarity(testLib, testLib2);
		assertTrue(sim == 1);
	}
	
	@Test
	public void testSimilarityFail() {
		double sim = PhotoLibrary.similarity(testLib, testLib3);
		assertTrue(sim == 0);
	}
	@Test
	public void testEComparePhotoPass() {
		assertEquals(p1.compareTo(p2), -34);
	}
	
	@Test
	public void testComparePhotoFail() {
		assertTrue(p1.compareTo(p2) != 1);
	}
	
	
}
