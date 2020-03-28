package university;

public class Student{
	private String fullName;
	private static int s = 10000;
	private int serial;
	private Exam[] coursesAttending = new Exam[25]; //leave this for other implementations of this class
	
	public Student(String first, String second) {
		if(serial < 11000) {
			this.fullName = first + "" + second;
			this.serial = s++ ;
		} else {
			this.serial = 0; //TODO: Check for null object detection on ExampleApp.java
		}
	}
	
	public String getFullName() {
		return this.fullName;
	}
	public int getSerial() { 
		return this.serial;
	}
	public void setExam(Exam attending) {
		for(Exam e: this.coursesAttending) {
			if(e == null) { //TODO: optimize using static indexes
				e = attending;
				break;
			}
		}
	}
	public String getExamsList() {
		String examsList = null;
		for (Exam e: this.coursesAttending) {
			examsList = examsList + "\n" + e.getCourseInfo();
		}
	}
}