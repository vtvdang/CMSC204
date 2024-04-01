/*
 * @author vivian dang
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Data manager - Implements CourseDBManagerInterface. Allow users to read the
 * courses from a file or enter data.
 * 	 */

public class CourseDBManager implements CourseDBManagerInterface {
	 CourseDBStructure cds;

	/**
	 * Constructor
	 */
	public CourseDBManager() {
		
		cds = new CourseDBStructure(20);
	}

	/**
	 * Adds a new cde
	 */
	@Override
	public void add(String course, int crn, int credit, String room, String instructor) {
		cds.add(new CourseDBElement(course, crn, credit, room, instructor));
	}

	/**
	 * Gets a CourseDBElement from the CDS based on the crn
	 * 
	 * @param crn
	 * @return cde if found, null if not
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
			} 
		catch (IOException e) {
			System.out.print(e.getMessage());
			return null;
			}
	}

	/**
	 * Reads every line from a text file and adds it to the CDS
	 * 
	 * @param input the course file to be added
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner fileIn = new Scanner(input);
		int credit, crn;
		String string;
		String[] course;
		CourseDBElement cde;


		
		while (fileIn.hasNextLine()) {
			string = fileIn.nextLine();
			course = string.split(" ");
			crn = Integer.parseInt(course[1]);
			credit = Integer.parseInt(course[2]);
			cde = new CourseDBElement(course[0], crn, credit, course[3], course[4]);
			cds.add(cde);
		}
	}

	/**
	 * Displays all courses in the hash table as an ArrayList of strings
	 * 
	 * @return ArrayList 
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
}
