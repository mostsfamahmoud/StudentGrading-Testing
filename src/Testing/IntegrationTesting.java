package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Dev.FileHandler;
import Dev.Output;
import Dev.Student;
import Dev.Subject;

class IntegrationTesting {
	
	boolean isFileValid = false;
	FileHandler fileHandler = null;
	
	@BeforeEach
	void createFileHandler() {
        fileHandler = new FileHandler();
	}

	// Test File Handler (Read Operation)
    @Test
    public void Integration_testReadFile() {
    	
        String expectedContent = "Software Testing, CSE337s, 100\n"
        		+ "Engy Mohamed, 1900630s, 10 ,7 ,12 , 55\n"
        		+ "Aliaa Nabil, 1900949s, 8, 8, 15, 60\n"
        		+ "Esraa Amr Abdelmoneam , 1900061s, 10, 10, 12, 55\n"
        		+ "Abdelrahman Ali Mohammed Ali, 1900913s, 10, 10 , 20, 45\n"
        		+ "Mostafa Mahmoud Ali Ahmed, 1900034s, 10, 10, 20, 45\n";

        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(expectedContent, actualContent);
    }
    
    @Test
    public void Integration_testSubjectInfoMatching() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Subject subject = fileHandler.setSubjectInfo(Lines);

        assertEquals("Software Testing", subject.getSubjectName());
        assertEquals("CSE337s", subject.getSubjectCode());
        assertEquals(100, subject.getFullMark());
    }
    
    @Test
    public void Integration_ValidateSubjectInfo() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Subject subject = fileHandler.setSubjectInfo(Lines);
        
        assertTrue(subject.checkSubjectName(subject.getSubjectName()));
        assertTrue(subject.checkSubjectCode(subject.getSubjectCode()));
        assertTrue(subject.checkFullMark(subject.getFullMark()));
    }
    
    
    @Test
    public void Integration_testStudentsInfoMatching() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);

        // Verify the number of students
        assertEquals(5, students.size());

        // Verify the information of the first student
        Student student1 = students.get(0);
        assertEquals("Engy Mohamed", student1.getStudentName());
        assertEquals("1900630s", student1.getStudentNumber());
        assertEquals(10, student1.getActivitiesMark());
        assertEquals(7, student1.getPracticalMark());
        assertEquals(12, student1.getMidtermExamMark());
        assertEquals(55, student1.getFinalExamMark());
        
        // Verify the information of the second student
        Student student2 = students.get(1);
        assertEquals("Aliaa Nabil", student2.getStudentName());
        assertEquals("1900949s", student2.getStudentNumber());
        assertEquals(8, student2.getActivitiesMark());
        assertEquals(8, student2.getPracticalMark());
        assertEquals(15, student2.getMidtermExamMark());
        assertEquals(60, student2.getFinalExamMark());

        // Verify the information of the third student
        Student student3 = students.get(2);
        assertEquals("Esraa Amr Abdelmoneam ", student3.getStudentName());
        assertEquals("1900061s", student3.getStudentNumber());
        assertEquals(10, student3.getActivitiesMark());
        assertEquals(10, student3.getPracticalMark());
        assertEquals(12, student3.getMidtermExamMark());
        assertEquals(55, student3.getFinalExamMark());

        // Verify the information of the fourth student
        Student student4 = students.get(3);
        assertEquals("Abdelrahman Ali Mohammed Ali", student4.getStudentName());
        assertEquals("1900913s", student4.getStudentNumber());
        assertEquals(10, student4.getActivitiesMark());
        assertEquals(10, student4.getPracticalMark());
        assertEquals(20, student4.getMidtermExamMark());
        assertEquals(45, student4.getFinalExamMark());
        
        // Verify the information of the fifth student
        Student student5 = students.get(4);
        assertEquals("Mostafa Mahmoud Ali Ahmed", student5.getStudentName());
        assertEquals("1900034s", student5.getStudentNumber());
        assertEquals(10, student5.getActivitiesMark());
        assertEquals(10, student5.getPracticalMark());
        assertEquals(20, student5.getMidtermExamMark());
        assertEquals(45, student5.getFinalExamMark());
    }
    
    @Test
    public void Integration_ValidateStudentsInfo() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);

        // Verify the number of students
        assertEquals(5, students.size());

        // Verify the information of the first student
        for(int i = 0; i < students.size(); i++)
        {
            Student st = students.get(i);
            assertTrue(st.checkStudentName(st.getStudentName()));
            assertTrue(st.checkStudentNumber(st.getStudentNumber()));
            assertTrue(st.checkActivitiesMark(st.getActivitiesMark()));
            assertTrue(st.checkOralMark(st.getPracticalMark()));
            assertTrue(st.checkMidtermMark(st.getMidtermExamMark()));
            assertTrue(st.checkFinalMark(st.getFinalExamMark()));
        }
    }
    
    @Test
    public void Integration_ValidateStudentsGPA() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);

        // Verify the number of students
        assertEquals(5, students.size());

        // Verify the information of the first student
        Student student1 = students.get(0);
        student1.calculateFullMark();
        student1.calculateGrade_GPA();
		assertEquals("B+", student1.getGrade());
		assertEquals(3.3, student1.getGPA());
        
        // Verify the information of the second student
        Student student2 = students.get(1);
        student2.calculateFullMark();
        student2.calculateGrade_GPA();
		assertEquals("A-", student2.getGrade());
		assertEquals(3.7, student2.getGPA());

        // Verify the information of the third student
        Student student3 = students.get(2);
        student3.calculateFullMark();
        student3.calculateGrade_GPA();
		assertEquals("B+", student3.getGrade());
		assertEquals(3.3, student3.getGPA());

        // Verify the information of the fourth student
        Student student4 = students.get(3);
        student4.calculateFullMark();
        student4.calculateGrade_GPA();
		assertEquals("B+", student4.getGrade());
		assertEquals(3.3, student4.getGPA());
        
        // Verify the information of the fifth student
        Student student5 = students.get(4);
        student5.calculateFullMark();
        student5.calculateGrade_GPA();
		assertEquals("B+", student5.getGrade());
		assertEquals(3.3, student5.getGPA());
    }
    
    
    @Test
    public void Integration_testWriteFile() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);
        Subject subject = fileHandler.setSubjectInfo(Lines);
        
        StringBuilder sb = new StringBuilder();
        
        
        sb.append("Subject Name: " + subject.getSubjectName() + " Max Mark: " + subject.getFullMark() + "\n\n");
        
        // Verify the number of students
        assertEquals(5, students.size());
        
        for(int i = 0; i < students.size(); i++)
        {
            Student st = students.get(i);
            st.calculateFullMark();
        	sb.append(st.getStudentName()+" " + st.getStudentNumber() + " " + st.getGPA()+ " " + st.getGrade() + "\n");
        }
        
        try {
			fileHandler.WriteFile(sb.toString(), "OUT2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Read the content of the written file
        try {
            actualContent = fileHandler.ReadFile("OUT2.txt");
        } catch (IOException e) {
            Assertions.fail("Failed to read file");
            return;
        }

        // Assert that the actual content matches the expected content
        Assertions.assertEquals(sb.toString(), actualContent);
        
    }
    
    @Test
    public void Integration_ValidateOutput() {
    	
        fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile("sample_OG.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Act
        String[] Lines = null;
        try {
        	Lines = fileHandler.SplitFile(actualContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Student> students = fileHandler.setStudentsInfo(Lines);
        Subject subject = fileHandler.setSubjectInfo(Lines);
        
        Output output = new Output(students,subject);
        
        try {
			fileHandler.WriteFile(output.outTableString(), "OUT3.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String expectedOutput = "Subject Name: Software Testing		Max Mark: 100\n"
        		+ "\n"
        		+ "+-------------------------------+-----------------+--------+-------+\n"
        		+ "| Student name                  | Student number  | GPA    | Grade |\n"
        		+ "+-------------------------------+-----------------+--------+-------+\n"
        		+ "| Engy Mohamed                  | 1900630s        | 3.3    | B+    |\n"
        		+ "| Aliaa Nabil                   | 1900949s        | 3.7    | A-    |\n"
        		+ "| Esraa Amr Abdelmoneam         | 1900061s        | 3.3    | B+    |\n"
        		+ "| Abdelrahman Ali Mohammed Ali  | 1900913s        | 3.3    | B+    |\n"
        		+ "| Mostafa Mahmoud Ali Ahmed     | 1900034s        | 3.3    | B+    |\n"
        		+ "+-------------------------------+-----------------+--------+-------+\n"; 
        
        // Read the content of the written file
        try {
            actualContent = fileHandler.ReadFile("OUT3.txt");
        } catch (IOException e) {
            Assertions.fail("Failed to read file");
            return;
        }

        // Assert that the actual content matches the expected content
        Assertions.assertEquals(expectedOutput, actualContent);
        
    }
}
