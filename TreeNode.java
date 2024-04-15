/*This generic class is used in the MorseCodeTree classes.  
 * The class consists of a reference to the data and a reference to the leftChild and rightChild child. 
 *  Follow the Javadoc that is provided. 
 *   The Javadoc only lists those public methods that are required to pass the Junit tests.  
 *   You may add any private methods you need for your design.
 * 
 */

/**
 * The class for external Tree Node for Linked Trees
 * 
 * @author Vivian Dang
 * @param <T> data type for data reference of node
 */
public class TreeNode<T> {

    /**
     * Data of current node
     */
	protected T data;

    /**
     * left and right child nodes
     */
    protected TreeNode<T> leftChild;
    protected TreeNode<T> rightChild;

    /**
     * Default constructor. Creates a TreeNode with data set to null and no children.
     */
    public TreeNode() {
        this(null, null, null);
    }

    /**
     * Constructor to create a new TreeNode with leftChild and rightChild
     * child set to null and data set to dataNode
     * @param dataNode the data to be stored in the TreeNode
     */
    public TreeNode(T dataNode) {
        this(dataNode, null, null);
    }

    /**
     * Constructor used for making deep copies
     * @param dataPortion the data to be stored in the TreeNode
     * @param newLeftChild the left child node
     * @param newRightChild the right child node
     */
    public TreeNode(T dataPortion, TreeNode<T> newLeftChild, TreeNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    /**
     * Gets the data of the current node.
     * @return data
     */
    public T getData() {
        return data;
    }
}