import java.util.*;

/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author shp4df
 * @param <Comparable> The type of data this tree node stores
 * 
 */
public class TreeNode<T extends Comparable<T>> {
	private Comparator<T> comparator;

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

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		String retVal = "";
		if (this.left != null)
			retVal += this.left.toString(); // recursive call on left
		if (this.right != null) 
			retVal += this.right.toString(); // recursive call on right
		retVal += "("+this.data+")"; // add this node's data
		return retVal;
	}

	public TreeNode<T> insert(T toInsert)
	{
		if (toInsert == null)
			return new TreeNode<T>(toInsert);

		if (compare(toInsert, data) == 0)
			return data;

		if (compare(toInsert, p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	public int compare(T x, T y)
	{
		if(comparator == null) return x.compareTo(y);
		else
			return comparator.compare(x,y);
	}
	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {

	}

}
