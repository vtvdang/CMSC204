/*
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs (calls the constructor for) 
 * the MorseCodeTree.
This class has two static methods convertToEnglish to convert from morse code to english. 
One method is passed a string object (“.-.. --- ...- . / .-.. --- --- -.- ...”).  

The other method is passed a file to be converted.  

These static methods use the MorseCodeTree to convert from morse code to english characters.  
Each method returns a string object of englishPhrase characters.

There is also a static printTree method that is used for testing purposes – 
to make sure the tree for MorseCodeTree was built properly.

Use the Javadoc provided to make sure that your MorseCodeConverter class follows the method headers
 so that the MorseCodeConverterTest will run correctly.

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the methods to convert morse code from a file or as a string into English
 * 
 * @author Vivian Dang
 * 
 */
public class MorseCodeConverter {


	/**
     * Constructor for a new tree
     */
    private static MorseCodeTree tree = new MorseCodeTree();
    
    
	/**
	 * Converts Morse code into englishPhrase. Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’.
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param  codeFile - name of the File that contains Morse Code
     * @return the englishPhrase translation of the file
     */
	public static String convertToenglishPhrase(File codeFile ) throws FileNotFoundException{
		Scanner code = new Scanner(codeFile);
		String phrase = "";
		while (code.hasNextLine())  {
			phrase += code.nextLine();

		}
		code.close();
		return convertToEnglish(phrase);
	}
	

	/**
	 * Converts Morse code into englishPhrase. Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’.
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param code - the morse code
	 * @return the englishPhrase translation
	 */
	public static String convertToEnglish(String code)  {
		String englishPhrase = "";
		String[] morseCode = code.split("/");
		String[][] codeWords = new String[morseCode.length][];

		for (int i = 0; i < codeWords.length; i++)  {
			codeWords[i] = morseCode[i].split(" ");
		}

		for (int i = 0; i < codeWords.length; i++) {
			for (int y = 0; y < codeWords[i].length; y++) {
				codeWords[i][y] = tree.fetch(codeWords[i][y]);
				englishPhrase += codeWords[i][y];
			}
			
			if (i == codeWords.length -1) {
				englishPhrase += "";
				} 
			else englishPhrase += " ";	
		}
	return englishPhrase;
}

   /**
	 * 	 *returns a string with all the data in the tree in LNR order with an space in between them. 
	 * Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * Note the extra space between j and b - that is because there is an empty string that is the root, 
	 * and in the LNR traversal, the root would come between the right most child of the left tree (j) 
	 * and the left most child of the right tree (b). 
	 * This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	
	public static String printTree() {
	    tree = new MorseCodeTree();
	    ArrayList<String> letters = tree.toArrayList();
	    StringBuilder englishString = new StringBuilder();
	    
	    for (int i = 0; i < letters.size(); i++) {
	    	englishString.append(letters.get(i));
	    	if (i == letters.size() - 1) {
	    		englishString.append(" ");
	        }
	    }
	    
	    return englishString.toString();
	}
}