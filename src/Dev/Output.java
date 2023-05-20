package Dev;

import java.util.ArrayList;

public class Output {
	
	private ArrayList<Student> students;
	
	private Subject subject;
	
	public Output() {
		super();
		this.students = new ArrayList<>();
		this.subject = new Subject();
	}
	
	public Output(ArrayList<Student> students, Subject subject) {
		super();
		this.students = students;
		this.subject = subject;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public  String outTableString() {

		// Build the table string
		StringBuilder sb = new StringBuilder();

		sb.append("Subject Name: " + subject.getSubjectName() + "\t\t" + "Max Mark: " + subject.getFullMark()
				+ "\n\n");

		// Determine the maximum length of the student name
		int maxNameLength = 0;
		for (Student st : students) 
		{
			maxNameLength = Math.max(maxNameLength, st.getStudentNameLength());
		}

		// Format specifier string with variable length
		String format = "| %-" + (maxNameLength + 2) + "s| %-15s | %-6s | %-5s |%n";

		/* Formatting the start line of the table */
		sb.append("+");
		for (int i = 0; i < maxNameLength + 3; i++) 
		{
			sb.append("-");
		}
		sb.append("+-----------------+--------+-------+\n");
		
		/* Formatting the second line which contains the attributes of the table */
		sb.append("| Student name");
		for (int i = 0; i < maxNameLength - 10; i++) 
		{
			sb.append(" ");
		}
		sb.append("| Student number  | GPA    | Grade |\n");
		sb.append("+");
		for (int i = 0; i < maxNameLength + 3; i++) 
		{
			sb.append("-");
		}
		sb.append("+-----------------+--------+-------+\n");

		/* Adding the list of student into the table with the specified format */
		for (Student st : students) 
		{
			st.calculateFullMark();
			sb.append(String.format(format, st.getStudentName(), st.getStudentNumber(), st.getGPA(), st.getGrade()));
		}

		/* Formatting the end line of the table */
		sb.append("+");
		for (int i = 0; i < maxNameLength + 3; i++) 
		{
			sb.append("-");
		}
		sb.append("+-----------------+--------+-------+\n");

		/* Returning this Table as a String to be written into the output file */
		return sb.toString();
	}
}
