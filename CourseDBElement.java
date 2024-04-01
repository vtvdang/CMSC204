/*
 * @author vivian dang
 */
public class CourseDBElement implements CourseDBElementInterface{

	String id;
	int crn;
	int credits;
	String roomNum;
	String instructor;
	
	/**
	 * Parameterized constructor
	 * @param id
	 * 
	 */	public void  CourseDBElement(String id, int crn,  int credits, String roomNum , String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	/**
	 * Constructor
	 */
	public String getID(String id) {
		return id;
	}
	/**
	 * Constructor
	 */
	public void setID(String id) {
		  this.id = id;
	}
	/**
	 * Constructor
	 */
	public void  getRoomNum(String roomNum) {
		get roomNum;
	}
	/**
	 * Constructor
	 */
	public void  setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	/**
	 * Constructor
	 */
	public int  compareTo(CourseDBElement element) {
		if (o.crn == crn) {
			return 0;
		} else if (o.crn < crn) {
			return -1;
		} else {
			return 1;
		}
	}
	/**
	 * Constructor
	 */
	public int  getCRN(int crn) {
		return crn;
	}
	/**
	 * Constructor
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/**
	 * Constructor
	 */
	public int hashCode(int hash) {
		int hashCode = crn.hashCode();
        return hashCode;
    }
	
	/**
	 * Constructor
	 */
		@Override
	public String toString() {
		String str = "\nCourse:" + course + " CRN:" + crn + " Credits:" + credit + " Instructor:" + instructor + " Room:" + room;
		return str;
		}

	}

}