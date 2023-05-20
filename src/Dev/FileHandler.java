package Dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
	
    /*
     * Function to read a file from a specific path and returns a String
     * */
    public String ReadFile(String filePath) throws IOException
    {
        String line;
        StringBuilder file = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        /* check if the line is empty */
        while((line = reader.readLine()) != null)
        {
            file.append(line).append("\n");
        }
        reader.close();

        return file.toString();
    }
    
    public String[] SplitFile(String file) throws IOException
    {
		String[] Lines = file.replaceAll("\n", ",").split(",");

		int n = 1;
		for (int i = 1; i < Lines.length; i++) {
			if (i != (6 * n - 3))
				Lines[i] = Lines[i].trim();
			else
				n++;
		}
		
		return Lines;
    }

    /*
    * Function to write the new formatted file into a specific path
    * */
    public void WriteFile(String inString, String outputFilePath) throws IOException
    {
        /* check if the inputPath file is empty */
        if ((inString == null) || (inString.trim().length() == 0))
            return;

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        writer.write(inString);
        writer.close();
    }
    
    public Subject setSubjectInfo(String[] Lines)
    {
		Subject subject = new Subject();
		subject.setSubjectName(Lines[0]);
		subject.setSubjectCode(Lines[1]);
		subject.setFullMark(Integer.parseInt(Lines[2]));
		
		return subject;
    }
    
    public ArrayList<Student> setStudentsInfo(String[] Lines)
    {
		ArrayList<Student> students = new ArrayList<>();

		for (int i = 3; i < Lines.length; i = i + 6) {
			Student st = new Student();
			st.setStudentName(Lines[i]);
			st.setStudentNumber(Lines[i + 1]);
			st.setActivitiesMark(Integer.parseInt(Lines[i + 2]));
			st.setPracticalMark(Integer.parseInt(Lines[i + 3]));
			st.setMidtermExamMark(Integer.parseInt(Lines[i + 4]));
			st.setFinalExamMark(Integer.parseInt(Lines[i + 5]));

			students.add(st);
		}
		
		return students;
    }
}
