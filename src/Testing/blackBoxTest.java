package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Dev.Student;

class blackBoxTest {
	Student s = null;

	@BeforeEach
	public void createStudent() throws Exception {
		s = new Student();
	}
	
	// boundary value analysis test
	@Test
	void BVA_TestGPAGradeAPlus() {
	
		
		//negative ( max value +1 )
		s.setTotalMark(101);
		s.calculateGrade_GPA();
		assertNotEquals("A+", s.getGrade());
		assertNotEquals(4.0, s.getGPA());
		
		
		// boundary value ( max )
		s.setTotalMark(100);
		s.calculateGrade_GPA();
		assertEquals("A+", s.getGrade());
		assertEquals(4.0, s.getGPA());
		
		
		// positive value ( max - 1)
		s.setTotalMark(99);
		s.calculateGrade_GPA();
		assertEquals("A+", s.getGrade());
		assertEquals(4.0, s.getGPA());
		
		// nominal value
		s.setTotalMark(98);
		s.calculateGrade_GPA();
		assertEquals("A+", s.getGrade());
		assertEquals(4.0, s.getGPA());
		
		// boundary ( min )
		s.setTotalMark(97);
		s.calculateGrade_GPA();
		assertEquals("A+", s.getGrade());
		assertEquals(4.0, s.getGPA());
		
		//negative ( min - 1 )
		s.setTotalMark(96);
		s.calculateGrade_GPA();
		assertNotEquals("A+", s.getGrade());
		assertEquals(4.0, s.getGPA());
		
		}
	
	
	//Equivalence class partitioning test
	@Test
	void ECP_TestFinalExamMark() {
		
		// class 1 ( above 60 )
		s.setFinalExamMark(80);
		assertFalse(s.checkFinalMark(s.getFinalExamMark()));
		
		// class 2 ( 0 --> 60 )
		s.setFinalExamMark(45);
		assertTrue(s.checkFinalMark(s.getFinalExamMark()));
		
		// class 3 ( below 0 )
		s.setFinalExamMark(-20);
		assertFalse(s.checkFinalMark(s.getFinalExamMark()));
	}
	
	
	//Decision Table Based Testing
	@Test
	void DecisionTable_StudentNumberTest() {
		
		//case1 
		 assertTrue(s.checkStudentNumber("1234567A"));
		//case2
		 assertTrue(s.checkStudentNumber("12345678"));
		//case3
		 assertFalse(s.checkStudentNumber("A234567A"));
		//case4
		 assertFalse(s.checkStudentNumber("A2345678"));
		//case5
		 assertFalse(s.checkStudentNumber("123456A"));
		//case6
		 assertFalse(s.checkStudentNumber("1234567"));
		//case7 
		 assertFalse(s.checkStudentNumber("A23456A"));
		//case8
		 assertFalse(s.checkStudentNumber("A234567"));
	}
	
	//Cause-Effect Graphing Test
	    @Test
	    public void CauseEffect_testValidStudentNumber() {
	        assertTrue(s.checkStudentNumber("9876543B")); 
	        assertTrue(s.checkStudentNumber("53695327")); 
	        assertFalse(s.checkStudentNumber("AB125A7B"));
	        assertFalse(s.checkStudentNumber("_DS24567"));
	        assertFalse(s.checkStudentNumber("1234567#"));
	        assertFalse(s.checkStudentNumber("1234567*"));
	        assertFalse(s.checkStudentNumber("123456789"));
	    }

	
}


