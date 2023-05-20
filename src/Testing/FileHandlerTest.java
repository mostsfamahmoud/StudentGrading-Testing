package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Dev.FileHandler;
import Dev.Student;
import Dev.Subject;

class FileHandlerTest {

    @Test
    public void testReadFile1() {
        // Arrange
        String filePath = "sample_OG.txt";
        String expectedContent = "Software Testing, CSE337s, 100\n"
        		+ "Engy Mohamed, 1900630s, 10 ,7 ,12 , 55\n"
        		+ "Aliaa Nabil, 1900949s, 8, 8, 15, 60\n"
        		+ "Esraa Amr Abdelmoneam , 1900061s, 10, 10, 12, 55\n"
        		+ "Abdelrahman Ali Mohammed Ali, 1900913s, 10, 10 , 20, 45\n"
        		+ "Mostafa Mahmoud Ali Ahmed, 1900034s, 10, 10, 20, 45\n";

        // Act
        FileHandler fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(expectedContent, actualContent);
    }
    
    @Test
    public void testReadFile2() {
        // Arrange
        String filePath = "sample1.txt";
        String expectedContent = "Mathematics,MATH101,100\n"
        		+ "John Doe,12345678,8,9,18,56\n"
        		+ "Jane Smith,98765432,7,8,16,45\n"
        		+ "Alice Johnson,543210s,9,7,19,58\n"
        		+ "Bob Wilson,987650s,8,9,17,55\n"
        		+ "Sarah Brown,13579s,6,8,14,40\n"
        		+ "Michael Davis,24680s,7,7,15,50\n"
        		+ "Emily Adams,86420s,9,8,18,52\n"
        		+ "Daniel Lee,97531s,8,9,16,48\n";

        // Act
        FileHandler fileHandler = new FileHandler();
        
        String actualContent = null;
        try {
            actualContent = fileHandler.ReadFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(expectedContent, actualContent);
    }
    
    @Test
    public void testWriteFile() {
        // Test input string
        String inputString = "Mathematics,MATH101,100\n"
        		+ "John Doe,12345678,8,9,18,56\n"
        		+ "Jane Smith,98765432,7,8,16,45\n"
        		+ "Alice Johnson,543210s,9,7,19,58\n"
        		+ "Bob Wilson,987650s,8,9,17,55\n"
        		+ "Sarah Brown,13579s,6,8,14,40\n"
        		+ "Michael Davis,24680s,7,7,15,50\n"
        		+ "Emily Adams,86420s,9,8,18,52\n"
        		+ "Daniel Lee,97531s,8,9,16,48\n";

        // Test file path
        String outputFilePath = "OUT.txt";
        
        FileHandler fileHandler = new FileHandler();

        // Call the WriteFile method
        try {
            fileHandler.WriteFile(inputString, outputFilePath);
        } catch (IOException e) {
            Assertions.fail("Failed to write file");
        }

        // Read the content of the written file
        String actualContent;
        try {
            actualContent = fileHandler.ReadFile(outputFilePath);
        } catch (IOException e) {
            Assertions.fail("Failed to read file");
            return;
        }

        // Assert that the actual content matches the expected content
        Assertions.assertEquals(inputString, actualContent);
    }

    @Test
    public void testSplitFile() {
        // Arrange
        String sampleFile = "Software Testing, CSE337s, 100\n"
        		+ "Engy Mohamed, 1900630s, 10 ,7 ,12 , 55\n"
        		+ "Aliaa Nabil, 1900949s, 8, 8, 15, 60\n"
        		+ "Esraa Amr Abdelmoneam, 1900061s, 10, 10, 12, 55\n"
        		+ "Abdelrahman Ali Mohammed Ali, 1900913s, 10, 10 , 20, 45\n"
        		+ "Mostafa Mahmoud Ali Ahmed, 1900034s, 10, 10, 20, 45\n";

        // Arrange
        FileHandler fileHandler = new FileHandler();
        
        // Act
        String[] result = null;
        try {
            result = fileHandler.SplitFile(sampleFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        String[] expectedLines = {
                "Software Testing",
                "CSE337s",
                "100",
                "Engy Mohamed",
                "1900630s",
                "10",
                "7",
                "12",
                "55",
                "Aliaa Nabil",
                "1900949s",
                "8",
                "8",
                "15",
                "60",
                "Esraa Amr Abdelmoneam",
                "1900061s",
                "10",
                "10",
                "12",
                "55",
                "Abdelrahman Ali Mohammed Ali",
                "1900913s",
                "10",
                "10",
                "20",
                "45",
                "Mostafa Mahmoud Ali Ahmed",
                "1900034s",
                "10",
                "10",
                "20",
                "45"
        };

        	Assertions.assertArrayEquals(expectedLines, result);
       }
    
    
    @Test
    public void testSetSubjectInfo() {
        FileHandler fileHandler = new FileHandler();

        String[] Lines = {
                "Software Testing",
                "CSE337s",
                "100",
                "Engy Mohamed",
                "1900630s",
                "10",
                "7",
                "12",
                "55",
                "Aliaa Nabil",
                "1900949s",
                "8",
                "8",
                "15",
                "60",
                "Esraa Amr Abdelmoneam",
                "1900061s",
                "10",
                "10",
                "12",
                "55",
                "Abdelrahman Ali Mohammed Ali",
                "1900913s",
                "10",
                "10",
                "20",
                "45",
                "Mostafa Mahmoud Ali Ahmed",
                "1900034s",
                "10",
                "10",
                "20",
                "45"
        };

        Subject subject = fileHandler.setSubjectInfo(Lines);

        assertEquals("Software Testing", subject.getSubjectName());
        assertEquals("CSE337s", subject.getSubjectCode());
        assertEquals(100, subject.getFullMark());
    }
    
    @Test
    public void testSetStudentsInfo() {
        FileHandler fileHandler = new FileHandler();

        String[] lines = {
            "Software Testing",
            "CSE337s",
            "100",
            "Engy Mohamed",
            "1900630s",
            "10",
            "7",
            "12",
            "55",
            "Aliaa Nabil",
            "1900949s",
            "8",
            "8",
            "15",
            "60",
            "Esraa Amr Abdelmoneam",
            "1900061s",
            "10",
            "10",
            "12",
            "55",
            "Abdelrahman Ali Mohammed Ali",
            "1900913s",
            "10",
            "10",
            "20",
            "45",
            "Mostafa Mahmoud Ali Ahmed",
            "1900034s",
            "10",
            "10",
            "20",
            "45"
        };

        ArrayList<Student> students = fileHandler.setStudentsInfo(lines);

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
        assertEquals("Esraa Amr Abdelmoneam", student3.getStudentName());
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

    }
}
