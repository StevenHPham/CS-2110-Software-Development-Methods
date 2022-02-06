import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    
    static BinarySearchTree<Integer> bst;
    static ArrayList<Integer> list;
    
    @Before
    public void setUp() {
    Integer[] a = {10,3,13,1};
    bst = new BinarySearchTree<Integer>();
    list = new ArrayList<Integer>();
    list.add(1);
    list.add(5);
    list.add(10);
    for (Integer n : a) {
        bst.insert(n);
    }
    
    }
    @Test
    public void testFindPass() {
       assertEquals(bst.find(10) , true);
    }
    @Test
    public void testFindFails() {
       assertEquals(bst.find(100) , false);
    }

    @Test
    public void testInsertPass() {
        assertEquals(bst.insert(3) , false);
    }
    
    @Test
    public void testInsertFails() {
        assertFalse(bst.insert(3) == true );
    }

    @Test
    public void testDeletePass() {
        assertEquals(bst.delete(3) , true);
    }
    
    @Test
    public void testDeleteFails() {
        assertEquals(bst.delete(3) , true);
    }

    @Test
    public void testBuildFromList() {
        assertEquals(bst.buildFromList(list) , true);
    }

    @Test
    public void testToString() {
        assertEquals(bst.toString() , "{10, {3, {1, {}, {}}, {}}, {13, {}, {}}}");
    }

    @Test
    public void testSize() {
        assertEquals(bst.size() , 4);
    }

    @Test
    public void testHeight() {
       assertEquals(bst.height() , 3);
    }

    
    
}
