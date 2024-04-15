/*	A generic linked binary tree which inherits from the LinkedConverterTreeInterface. 
 *  The class uses an external generic TreeNode class parameterized as a String: TreeNode<String>. 
 *   This class uses the private member of root.  Nodes are added based on their morse code value.  
 *   A ‘.’ (dot) means to traverse leftChild and a ‘-‘ (dash) means to traverse rightChild. 
 *   The constructor will call the method to “build the tree”.  
 *   Follow the Javadoc that is provided.
 *    The Javadoc only lists those public methods that are required to pass the Junit tests.
 *    You may add any private methods you need for your design.
 * 
 */

import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 * It relies on a root (reference to root of the tree)
 * The root is set to null when the tree is empty.
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode)
 * The constructor will call the buildTree
 *  
 * @author Vivian Dang
 *
 */
public class MorseCodeTree{

	/**
     * Root of tree
     */
	protected TreeNode<String> root;

	/**
	 * Constructor calls the buildTree method.
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would be stored as the right child of the left child of the root Algorithm 
	 * for the recursive method: 1. if there is only one character a. 
	 * if the character is '.' (dot) store to the left of the current root b.
	 *  if the character is "-" (dash) store to the right of the current root c. 
	 *  return 2. if there is more than one character a. 
	 *  if the first character is "." (dot) new root becomes the left child b. 
	 *  if the first character is "-" (dash) new root becomes the right child c.
	 *  new code becomes all the remaining charcters in the code (beyond the first character) d. 
	 *  call addNode(new root, new code, letter
	 *  
	 * Adds a node to the tree with the data of the passed English letter
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	
	public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.charAt(0) == '.') {
                root.leftChild = new TreeNode<>(letter);
            } else {
                root.rightChild = new TreeNode<>(letter);
            }
        } else {
            char firstChar = code.charAt(0);
            String next = code.substring(1);
            if (firstChar == '.') {
                if (root.leftChild == null) root.leftChild = new TreeNode<>("");
                addNode(root.leftChild, next, letter);
            } else {
                if (root.rightChild == null) root.rightChild = new TreeNode<>("");
                addNode(root.rightChild, next, letter);
            }
        }
    }
	
     /**
 	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
 	 * The root will have a value of "" (empty string) 
 	 * level one: insert(".", "e"); insert("-", "t"); 
 	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); 
 	 * etc. Look at the tree and the table of codes to letters in the assignment description.
 	 */
 	
 	public void buildTree() {
 		
 		//Level 0 (root)
 		setRoot(new TreeNode<String>(""));
 		
 		//Level 1
 		insert(".", "e");
 		insert("-", "t");
 		
 		//Level 2
 		insert("..", "i");
 		insert(".-", "a");
 		
 		insert("-.", "n");
 		insert("--", "m");
 		
 		//Level 3
 		insert("...", "s");
 		insert("..-", "u");
 		
 		insert(".-.", "r");
 		insert(".--", "w");
 		
 		insert("-..", "d");
 		insert("-.-", "k");
 		
 		insert("--.", "g");
 		insert("---", "o");
 		
 		//Level 4
 		insert("....", "h");
 		insert("...-", "v");
 
 		insert("..-.", "f");
 		
 		insert(".-..", "l");
 		
 		insert(".--.", "p");
 		insert(".---", "j");
 		
 		insert("-...", "b");
 		insert("-..-", "x");
 		
 		insert("-.-.", "c");
 		insert("-.--", "y");
 		
 		insert("--..", "z");
 		insert("--.-", "q");		
 	}
 	
 	/*
 	 * This operation is not supported in the MorseCodeTree
 	 */
 	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}
	
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param  code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	public String fetch(String code) {	
		if(code.equals("/")) {
			return " ";
		}
		return fetchNode(getRoot(), code);		
	}


	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	
	public String fetchNode(TreeNode<String> root, String code) {
	    String letter = "";
	    
	    if (code.length() == 1) {
	        if (code.equals(".")) {
	            letter = root.leftChild.data;
	        } else if (code.equals("-")) {
	            letter = root.rightChild.data;
	        } 
	        
	    } else {
	        if (code.length() > 0) {
	            char firstChar = code.charAt(0);
	            if (firstChar == '.') {
	                letter = fetchNode(root.leftChild, code.substring(1));
	            } else if (firstChar == '-') {
	                letter = fetchNode(root.rightChild, code.substring(1));
	            }
	        }
	    }
	    return letter;
	}


	
	/**
	 * This method returns a reference to the root
	 * @return reference to root
	 */
	
	public TreeNode<String> getRoot() {
        return root;
    }

 	/**
	 * Adds element to the correct position in the tree based on the code 
	 * This method will call the recursive method addNode
	 * @param the code for the new node to be added, example ".-."
	 * @return the current state of the tree
	 */
	
	public MorseCodeTree insert(String code, String letter) {
		addNode(getRoot(), code, letter);
		return this;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
	    if (root == null) {
	        return;
	    }
	    
	    LNRoutputTraversal(root.leftChild, list);
	    list.add(root.data);
	    LNRoutputTraversal(root.rightChild, list);
	}


	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order 
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeList = new ArrayList<>();
		LNRoutputTraversal(root, treeList);
		return treeList;
	}


	/*
 	 * This operation is not supported in the MorseCodeTree
 	 */
 	
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}	
}