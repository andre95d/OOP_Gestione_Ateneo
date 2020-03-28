package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {

	private String uniName;
	private String rector;
	//private Integer i = 0, j = 0; // maybe useless
	private Student[] students = new Student[1000]; //1000 student at most
	private Exam[] exams = new Exam[50]; //50 courses at most
	
	public University(String name){
		this.uniName = name;
	}
	
	/**
	 * Getter for the name of the university
	 * @return name of university
	 */
	public String getName(){
		return this.uniName;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.rector = first + " " + last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return
	 */
	public String getRector(){
		return this.rector;
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		/*students[i] = new Student(first, last);
		return students[i++].getSerial(); //ASK TO TORCHIANO: avoid using indexes and use for each construct?
		*/
		for(Student s: students){
			if(s == null){ //TODO: optimize using static indexes
				s = new Student(first, last);
				return s.getSerial();
			}
		}
		return -1;
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int id){
		for(Student var: students) {
			if(var.getSerial() == id) {
				return var.getSerial() + var.getFullName();
			}
		}
		return null;
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		for(Exam e : exams ) {
			if(e == null) { //TODO: optimize using static indexes
				e = new Exam(title, teacher);
				return e.getExamCode();
			}
		}
		return -1;
	}
	
	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		for(Exam e: exams) {
			if(e.getExamCode() == code) {
				return e.getCourseInfo();
			}
		}
		return null;
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		for(Student s: students) {
			if(s.getSerial() == studentID) {
				for(Exam e: exams) {
					if(e.getExamCode() == courseCode) {
						s.setExam(e);
						e.setAttendee(s);
						break;
					}
				}
				
			}
		}
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		for(Exam e: exams) {
			if(e.getExamCode() == courseCode) {
				return e.getAttendeesList();
			}
		}
		return null; //see ExampleApp for better feedback
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		for(Student s: students) {
			if(s.getSerial() == studentID) {
				return s.getExamsList();
			}
		}
		return null; //See ExampleApp.java for better feedback
	}
}
