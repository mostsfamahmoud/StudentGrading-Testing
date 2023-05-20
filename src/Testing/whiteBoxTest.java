package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Dev.Student;
import Dev.Subject;

class whiteBoxTest {
	
	Student student = null;
	
	@BeforeEach
	void createStudent() {
		student = new Student();
	}
	
	
	//Statment Coverage
    
    @Test
    public void StatmentCoverage_testEmptyName() {
        String name = "";
        Student nameChecker = new Student();
        boolean result = nameChecker.checkStudentName(name);
        assertFalse(result);
        
    }
    
    @Test
    public void StatmentCoverage_testSpaceStartName() {
        String name = " John";
        Student nameChecker = new Student();
        boolean result = nameChecker.checkStudentName(name);
        assertFalse(result);
    }
    
  
    
    @Test
    public void StatmentCoverage_testNonAlphabeticCharacters() {
        String name = "John123";
        Student nameChecker = new Student();
        boolean result = nameChecker.checkStudentName(name);
        assertFalse(result);
    }
    
    @Test
    public void StatmentCoverage_testValidNameWithSpaces() {
        String name = "Jane Smith";
        Student nameChecker = new Student();
        boolean result = nameChecker.checkStudentName(name);
        assertTrue(result);
    }
    
    
    //Branch Coverage
    
        @Test
        public void testValidAlphabeticPart() {
            Subject validator = new Subject();
            assertFalse(validator.subjectCodeAlphabeticPart("AB223"));
        }
        
        @Test
        public void testNonAlphabeticCharacter() {
            Subject validator = new Subject();
            assertFalse(validator.subjectCodeAlphabeticPart("AB23"));
        }
        
      
        
        @Test
        public void testSingleAlphabeticCharacter() {
            Subject validator = new Subject();
            assertFalse(validator.subjectCodeAlphabeticPart("X123"));
        }
        
        @Test
        public void testLongerAlphabeticPart() {
            Subject validator = new Subject();
            assertTrue(validator.subjectCodeAlphabeticPart("XYZ123"));
        }
        
        @Test
        public void testSpecialCharacters() {
            Subject validator = new Subject();
            assertFalse(validator.subjectCodeAlphabeticPart("!@123"));
        }
   

    
    //condition coverage

        @Test
        public void testAllConditionsTrue() {
            String subjectCode = "COM101s";
            Subject codeChecker = new Subject();
            boolean result = codeChecker.checkSubjectCode(subjectCode);
            assertTrue(result);
        }

        @Test
        public void testOneConditionFalse() {
            String subjectCode = "MATH20";
            Subject codeChecker = new Subject();
            boolean result = codeChecker.checkSubjectCode(subjectCode);
           assertFalse(result);
        }

        @Test
        public void testTwoConditionsFalse() {
            String subjectCode = "CS1010A";
            Subject codeChecker = new Subject();
            boolean result = codeChecker.checkSubjectCode(subjectCode);
            assertFalse(result);
        }

        @Test
        public void testThreeConditionsFalse() {
            String subjectCode = "COMP101";
            Subject codeChecker = new Subject();
            boolean result = codeChecker.checkSubjectCode(subjectCode);
            assertFalse(result);
        }
        
        @Test
        public void testFourConditionsFalse() {
            String subjectCode = "CS1010A9";
            Subject codeChecker = new Subject();
            boolean result = codeChecker.checkSubjectCode(subjectCode);
            assertFalse(result);
        }
        
    	@Test
    	void PathCoverage_StudentNameTest() {
    		
    		//case 1 "empty false "
    		assertFalse(student.checkStudentName(""));
    	
    		//case 2 " start with space false "
    		assertFalse(student.checkStudentName(" ahmed"));
    		
    		//case 3 " has a special character "
    		assertFalse(student.checkStudentName("a_med"));

    		//case 4 " valid name "
    		assertTrue(student.checkStudentName("abdelrahman"));
    		
    		//case 5 " has number inside "
    		assertFalse(student.checkStudentName("a7md"));
    			
    	}
    	
    	@Test
    	void dataFlow_ADUP_StudentNameTest() {
    		//test case 1
    		assertFalse(student.checkStudentName(""));
    		//test case 2
    		assertFalse(student.checkStudentName(" Mostafa"));
    		//test case 3
    		assertFalse(student.checkStudentName("Mo$tafa"));
    		//test case 4
    		assertTrue(student.checkStudentName("Engy"));
    		
    	}

}
