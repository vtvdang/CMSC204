/*
 * @author vivian dang
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	int tableSize;
	LinkedList<CourseDBElement> hashTable;
/*A constructor that takes in an integer n which represents the estimated number of 
courses and determines the size of the hash table by finding a 4K+3 prime just greater than n /loading factor.

Example:  if n is 500 courses, then 500/1.5 = 333, The next 4K+3 prime over 333 is 347.  
So, you would set the table a length to 347.

Note: In hash table structure with buckets the load factor can be larger than one 
and represents the average number of elements stored in each list, 
assuming that the hash function distributes elements uniformly over all positions. 
For this assignment use a load factor of 1.5.

	/**
	 * A Constructor for testing purposes. 
	 * This constructor will take a string “Testing” and an int for the hashtable size.  
	 * This is used only for testing.

	 * Constructs an array of linkedLists of given size to create a hashTable
	 * @param size the size of the constructed data structure
	 */
	 public void CourseDBStructure(int n) {	
		 int loadFactor = 1.5;
				int beforePrime = (int)(n/loadFactor) + 1;
				int prime = beforePrime + (3 - (beforePrime % 4));
				
				boolean isPrime = false;
				while (!prime){

					prime = true;
					for (int i = 2; i <= prime / 2; i++){
						if (prime % i == 0){
							isPrime = false;
							break;
						}
					}
					if (!isPrime)
						num += 4;
				}
				
				hashTable = new ArrayList<LinkedList<CourseDBElement>>;
				for (int i = 0; i < prime; i++){
					hashTable.add(new LinkedList<CourseDBElement>);
				}
			}
		
		/**
		 * Constructs an array of linked lists of given size to create a hashTable for testing
		 * @param testing means this structure is meant for testing
		 * @param size the size of the constructed data structure
		 */
	 public void CourseDBStructure(String testing, int size) {			
				hashTable = new ArrayList<LinkedList<CourseDBElement>>();
				
				for (int i = 0; i < size; i++){
					hashTable.add(new LinkedList<CourseDBElement>());
				}
	 	}
	 /*
	  * The add method of CourseDBStructure will take a CourseDBElement object and add it to the data structure 
	  * based on the calculated hashcode. If a linked list at the relevant hash code doesn’t exist (the bucket is empty),
	  * create a LinkedList with the first element being the CourseDBElement object and add it to the HashTable.
	  * If the LinkedList already exists, add the CourseDBElement object to the existing list. 
	  */
	 public void add(CourseDBElement element) {
			hashTable.add(new LinkedList<CourseDBElement>());
	}
	 
	 public int getTableSize(int crn) throws IOException{
		return hashTable.size;
	}
	 

}

/*Referred as CDS, Implements the CourseDBStructureInterface that is provided.
You will be implementing a hash table with buckets. Each bucket will be an array of linked lists of CourseDBElements.  
Each CourseDBElement object will have a hash code that is calculate based on the CRN, since the CRN is unique for courses.  Note that the CRN is an int, and the tests require the hashcode of a string, so you will need to coerce it to a String and take the hash code of the resulting string.  The add method of CourseDBStructure will take a CourseDBElement object and add it to the data structure based on the calculated hashcode. If a linked list at the relevant hash code doesn’t exist (the bucket is empty), create a LinkedList with the first element being the CourseDBElement object and add it to the HashTable. If the LinkedList already exists, add the CourseDBElement object to the existing list. 

Two constructors for the CourseDBStructure will be required, 
one that takes in an integer that is the estimated number of courses, 
the other is used for testing purposes.  
The comments in the CourseDBStructureInterface (provided) should help you figure out how to set the length of the hash table. 



