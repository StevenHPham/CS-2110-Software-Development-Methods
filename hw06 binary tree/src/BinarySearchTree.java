import java.util.*;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author shp4df
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * A reference pointer to the root of the tree
     */
    private TreeNode<T> root;

    /**
     * Default constructor
     * 
     * Creates a binary tree object with null root note (empty tree)
     */
    public BinarySearchTree() {
        this(null);
    }


    /**
     * Constructor
     * 
     * Creates a binary tree object with the given node as root
     * 
     * @param newRoot The root of the tree
     */
    public BinarySearchTree(TreeNode<T> newRoot) {
        this.root = newRoot;
    }

    /**
     * Get the root of the tree
     * 
     * @return The root of the tree
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     * 
     * @param root  The new root of this tree
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * Find if an element exists
     * 
     * Checks to see if the value val appears in the
     * tree (recursively).  Returns true if it appears
     * and false otherwise.
     * 
     * @param val The value to find
     * @return True if the tree contains the value, false otherwise
     */
    public boolean find(T val) {
        if (root == null) { //if the root is empty, return false
            return false;
        } else { // if not empty, call recursive call function in TreeNode
            return root.find(val);
        }
    }

    /**
     * Insert an element
     * 
     * Inserts val into the tree where it should appear, returning
     * true on success and false otherwise
     * 
     * @param val The value to insert
     * @return True on success, false otherwise
     */
    public boolean insert(T val) {
        if (root == null) { //if the root is empty, create a new node
            root = new TreeNode<T>(val); //insert val into the node
            return true;
        } else {
            return root.insert(val); //if the root is not empty, call recursive insert function in TreeNode
        }
    }



    /**
     * Delete an element from the tree
     * 
     * Deletes val from the tree if it appears, returning
     * true on success and false otherwise
     * 
     * @param val The value to delete
     * @return True on success, false otherwise
     */
    public boolean delete( T val){
        //the node to be deleted
        TreeNode<T> target = null;
        //to keep track of parent node
        TreeNode<T> parent = null;
        //variable node reference
        TreeNode<T> node = root;

        while (node != null)
        {
            if (val.compareTo( node.getData() ) == 0) //
            {
                target = node;
                break;
            }
            else if (val.compareTo( node.getData() ) > 0)  //target greater, so go right
            {
                parent = node;
                node = node.getRight();
            }
            else    //target less, so go left
            {
                parent = node;
                node = node.getLeft();
            }
        }

        if (target == null)
        {
            //target not found
            return false;
        }

        boolean isLeft = (target == parent.getLeft() );

        if (target == root) //the node that's baleeting is in fact the root node
        {
            //get last house on the left on the right!
            //it becomes the new root
            node = getLastLeft( parent.getRight() );
            if (node != null)
            {
                node.setLeft( parent.getLeft() );
                node.setRight( parent.getRight() );
                root = node;
            }
        }
        else if ( target.isLeaf() )
        {
            if (isLeft)
            {
                parent.setLeft(null);
            }
            else
            {
                parent.setRight(null);
            }
        }
        else if (target.getLeft() != null && target.getRight() != null) //two children, some shuffling
        {
            if (isLeft)
            {
                parent.setLeft( target.getRight() );
                parent.getLeft().setLeft( target.getLeft() );
            }
            else
            {
                parent.setRight( target.getRight() );
                parent.getRight().setLeft( target.getLeft() );
            }
        }
        else    //one child is simpler
        {
            if (target.getLeft() == null)
            {
                if (isLeft)
                {
                    parent.setLeft( target.getLeft() );
                }
                else
                {
                    parent.setRight( target.getLeft() );
                }
            }
            else
            {
                if (isLeft)
                {
                    parent.setLeft( target.getRight() );
                }
                else
                {
                    parent.setRight( target.getRight() );
                }
            }
        }

        return true;    
    }
    
   
    
    private TreeNode<T> getLastLeft(TreeNode<T> start){
        TreeNode<T> candidate = null;
        TreeNode<T> parent = null;
        TreeNode<T> node = start;

        while (node != null)
        {
            if ( node.getLeft() != null )
            {
                parent = node;
                candidate = node.getLeft();
            }

            node = node.getLeft();
        }

        if (parent != null)
        {
            parent.setLeft(null);
        }

        return candidate;
    }


    /**
     * Build from a list
     * 
     * Build the tree from the given list, overwriting any tree data
     * previously stored in this tree.  Should read from beginning to
     * end of the list and repeatedly call insert() to build the tree.
     * 
     * @param list The list from which to build the tree
     * @return True if successfully built, false otherwise
     */
    public boolean buildFromList(ArrayList<T> list) {
        if(list.size() == 0) {
            return false;
        }
        root = new TreeNode<T>(list.get(0));
         for(int x = 1; x < list.size(); x++) {
            insert(list.get(x));
         }
         return true;
    }


    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(this.root , sb);
        return sb.toString();
    }


    private  static <T> void toString(TreeNode node, StringBuilder string) {
        string.append('{');
        if (node != null) {
            string.append(node.getData());
            string.append(", ");
            toString(node.getLeft(), string);
            string.append(", ");
            toString(node.getRight(), string);
        }
        string.append('}');
    }

    public int size() {
        if (root == null) { //if there is no root, return 0
            return 0;
        }
        return root.size(); //call recursive size function from TreeNode
    }

    public int height() {
        if(root == null) { //if there is no root, return 0
            return 0;
        }
        return root.height(); //call recursive height function from TreeNode
    }
    
    public String inOrder() {
        return root.inOrder();
    }
    
    public String postOrder() {
        return root.postOrder();
    }
    
   
    
    

    /**
     * Main method
     * 
     * For testing, etc
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {10,3,13,1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for(Integer n : a) {
            bst.insert(n);
        }
        System.out.println(bst);
        System.out.println();
        System.out.println(bst);
        System.out.println();
//        bst.insert(4);
        System.out.println(bst);
        System.out.println();

        System.out.println(bst.inOrder());
        
        bst.delete(4);
        System.out.println(bst);
        
        System.out.println(bst.postOrder());
       


    }
}
