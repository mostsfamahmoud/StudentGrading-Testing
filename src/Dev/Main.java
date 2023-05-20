package Dev;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		FileHandler fileHandler = new FileHandler();

		String file = fileHandler.ReadFile("sample_OG.txt");
		
		String[] Lines = fileHandler.SplitFile(file);

		Subject subject = fileHandler.setSubjectInfo(Lines);
		ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);

		/* Create output file with formated data*/
		
		Output output = new Output(students,subject);
		
		fileHandler.WriteFile(output.outTableString(), "OUT.txt");
	}
}
