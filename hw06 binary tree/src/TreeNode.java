
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author shp4df
 * @param <Comparable> The type of data this tree node stores
 */
public class TreeNode<T extends Comparable<T>> {
    
  
    /**
     * Reference pointer to the left subtree
     */
    private TreeNode<T> left;

    /**
     * Reference pointer to the right subtree
     */
    private TreeNode<T> right;

    /**
     * Data stored at this node
     */
    private T data;

    /**
     * Default Constructor
     * 
     * Creates a binary tree node with null data and null children
     */
    public TreeNode(){
        this(null,null,null);
    }

    /**
     * Data-only Constructor
     * 
     * Creates a binary tree node with the given data and null children
     * 
     * @param theData The data to store at this node
     */
    public TreeNode(T theData){
        this(theData,null,null);
    }


    /**
     * Full Constructor
     * 
     * Creates a binary tree node with the given data and child reference pointers
     * 
     * @param theData The data to store at this node
     * @param leftChild A reference pointer to the left subtree
     * @param rightChild A reference pointer to the right subtree
     */
    public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild){
        data = theData;
        left = leftChild;
        right = rightChild;
    }


    /**
     * Left Child/Subtree getter
     * 
     * @return A reference pointer to the root of the left subtree
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Left Child/Subtree Setter
     * 
     * @param left A reference pointer to the new left subtree's root node
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Get the data at this node
     * 
     * @return The data stored at this node
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data at this node
     * 
     * @param data The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    public boolean find(T val) {
        boolean found = false; 
        if (val.compareTo(data) == 0)
		    return true;
		else if (val.compareTo(data) < 0 && this.left != null) //if the value is less than the data of the node and the left node is not empty...
		    found = this.left.find(val); //recursive call for left node to find val
		else if (val.compareTo(data) > 0 && this.right != null) // if the value is less than the data of the node and the right node is not empty...
		    found = this.right.find(val); //recursive call for right node to find val
        return found;
    }


    public boolean insert(T val) {
        boolean added = false; 
        if (val.compareTo(this.data) < 0) { // checks if the value is less than the data already in the node 
		    if(this.left == null) { // if the left node is empty...   
		        this.left = new TreeNode<T>(val); //create a new node add the value to the node and return true
		        return true;
		    } else { //if the left node is not empty, recursive insert call on the left node for val
		        added = this.left.insert(val);
		    }
		} else if (val.compareTo(this.data) > 0) { //checks if the value is greater than node
		    if (this.right == null) { //if the right node is empty...
		        this.right = new TreeNode<T>(val); //create a new node add the value to the node and return true
		    } else {
		        added = this.right.insert(val);  //if the right node is not empty, recursive insert call on the left node for val
		    }
		}
        return added; 

    }


    public boolean isLeaf() //checks if the node is a leaf
    {
        return (left == null && right == null);
    }
    

    public int size() {
        if(this.getLeft() == null && this.getRight() == null) { //if there is no child node, return 1 from only one root
            return 1;
        }
        if(this.getLeft() != null && this.getRight() != null) { //if there both children are there, get the size 
            return 1 + this.getLeft().size() + this.getRight().size();
        }
        else if(this.getLeft() != null) { // if there is only left child, get the size of the left
            return 1 + this.getLeft().size();
        }
        else if(this.getRight() != null) { // if there is only right child, get the size of the right
            return 1 + this.getRight().size();
        }
        return 1;
    }

    public int height() {
        if(this.getLeft() == null && this.getRight() == null) {
            return 1;
        }
        if(this.getLeft() != null && this.getRight() != null) {
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
        else if(this.getLeft() != null) {
            return 1 + this.getLeft().height();
        }
        else if(this.getRight() != null) {
            return 1 + this.getRight().height();
        }
        return 1;
    }

    public String inOrder() {
        String s = "(" + toString() + ")";
        if (left != null)
            s =   left.inOrder()  + s ;
        if (right != null)
            s +=  right.inOrder() ;
        return s;
    }

    public String postOrder() {
        String s = "";
        if (left != null)
            s = left.postOrder();
        if (right != null)
            s += right.postOrder();
        return s + "(" + toString() + ")"; 
    }



    /**
     * toString method
     */
    @Override
    public String toString() {
        return data.toString();
    }


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
        bst.insert(4);
        System.out.println(bst);
        System.out.println();
        System.out.println();
        
    }




}
