package university;

public class Exam{
	private String title;
	private String teacher;
	private static int c = 10;
	private int code; 
	private Student[] attendees = new Student[100]; //100 attendees at most
	
	public Exam(String title, String teacher) {
		this.title = title; //TODO: boundaries feedback, see ExampleApp
		this.teacher = teacher;
		this.code = c++; //TODO: Check for null object detection on ExampleApp.java
	}
	public int getExamCode() { 
		return this.code;
	}
	public String getCourseInfo() {
		return code + ", " + title + ", " + teacher;
	}
	public void setAttendee(Student newAttendee) {
		for(Student a: this.attendees) {
			if(a == null) { //TODO: optimize using static indexes
				a = newAttendee;
				break;
			}
		}
	}
	public String getAttendeesList() {
		String fullNamesList = null;
		for(Student s: this.attendees) {
			fullNamesList = fullNamesList + "\n" + s.getSerial() + " " + s.getFullName();
		}
		return fullNamesList + "\n";
	}
}