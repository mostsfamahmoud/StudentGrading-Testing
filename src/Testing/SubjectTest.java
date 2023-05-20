package Testing;

import Dev.Subject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubjectTest {

	/*
2. Subject-code: It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic 
followed by 3 numeric characters. The sevens should be s if exists.
*/
	/************************* Unit Testing: Subject Name *******************************/
	
	@Test
    public void testEmptyName() {
        assertFalse(new Subject().checkSubjectName(""));
    }
    
    @Test
    public void testSpaceAtBeginning() {
        assertFalse(new Subject().checkSubjectName(" SoftwareTesting"));
    }
    
    @Test
    public void testNumericCharacters() {
        assertFalse(new Subject().checkSubjectName("DataBase123"));
    }
    
    @Test
    public void testSpecialCharacters() {
        assertFalse(new Subject().checkSubjectName("Software@Testing"));
        assertFalse(new Subject().checkSubjectName("Data_Base Systems"));
    }
    
    @Test
    public void testSingleLetter() {
        assertTrue(new Subject().checkSubjectName("S"));
    }
    
    @Test
    public void testSingleSpace() {
        assertFalse(new Subject().checkSubjectName(" "));
    }
    
    @Test
    public void testValidName() {
        assertTrue(new Subject().checkSubjectName("Data Structures and Algorthims"));
    }
    
	/************************* Unit Testing: Subject Code *******************************/
   
    @Test
    public void testSubjectCodeLength() {
        assertTrue(new Subject().subjectCodeLength("AB1234"));
        assertTrue(new Subject().subjectCodeLength("ABC123"));
        assertTrue(new Subject().subjectCodeLength("ABCD12s"));
        assertFalse(new Subject().subjectCodeLength("AB123"));
    }

    @Test
    public void testSubjectCodeAlphabeticPart() {
        assertFalse(new Subject().subjectCodeAlphabeticPart("AB1234"));
        assertTrue(new Subject().subjectCodeAlphabeticPart("ACB234"));
        assertFalse(new Subject().subjectCodeAlphabeticPart("1B1234"));
        assertFalse(new Subject().subjectCodeAlphabeticPart("123ABC"));
    }

    @Test
    public void testSubjectCodeNumericPart() {
        assertTrue(new Subject().subjectCodeNumericPart("AB1234"));
        assertTrue(new Subject().subjectCodeNumericPart("AB2345"));
        assertFalse(new Subject().subjectCodeNumericPart("ABCDdd"));
        assertFalse(new Subject().subjectCodeNumericPart("AB1C34"));
    }

    @Test
    public void testSubjectCodeLastChar() {
        assertTrue(new Subject().subjectCodeLastChar("AB1234s"));
        assertTrue(new Subject().subjectCodeLastChar("ABC123s"));
        assertFalse(new Subject().subjectCodeLastChar("AB1234S"));
        assertFalse(new Subject().subjectCodeLastChar("AB1234t"));
    }
 
    @Test
    public void testCheckSubjectCode() {
        assertFalse(new Subject().checkSubjectCode("AB1234"));
        assertTrue(new Subject().checkSubjectCode("ABC123s"));
        assertFalse(new Subject().checkSubjectCode("ABC1234"));
        assertFalse(new Subject().checkSubjectCode("ABC12"));
    }
    
    
	/************************* Unit Testing: Subject FullMark *******************************/
    @Test
    public void testCheckFullMark() {
        Subject fullMarkValidation = new Subject();
        
        // Test with valid mark
        assertTrue(fullMarkValidation.checkFullMark(100));
  
        // Test with mark less than Expected
        assertFalse(fullMarkValidation.checkFullMark(90));
        
        // Test with mark greater than Expected
        assertFalse(fullMarkValidation.checkFullMark(120));
    }

}
