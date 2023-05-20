package Testing;

import Dev.Student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {
	
	/************************* Unit Testing: Student Name *******************************/
	@Test
    public void testEmptyName() {
        assertFalse(new Student().checkStudentName(""));
    }
    
    @Test
    public void testSpaceAtBeginning() {
        assertFalse(new Student().checkStudentName(" abdelrahman"));
    }
    
    @Test
    public void testNumericCharacters() {
        assertFalse(new Student().checkStudentName("engy123"));
    }
    
    @Test
    public void testSpecialCharacters() {
        assertFalse(new Student().checkStudentName("aliaa@mo"));
    }
    
    @Test
    public void testSingleLetter() {
        assertTrue(new Student().checkStudentName("J"));
    }
    
    @Test
    public void testSingleSpace() {
        assertFalse(new Student().checkStudentName(" "));
    }
    
    @Test
    public void testValidName() {
        assertTrue(new Student().checkStudentName("mostafa mahmoud"));
    }
    
	/************************* Unit Testing: Student GPA AND GRADE *******************************/
    // To Discuss
    // test cases of calculate total mark to be added 
    
    /*
	@Test
	void testCalculateGrade_APlus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(100);
		/*
		calculator.setActivitiesMark(10);
		calculator.setMidtermExamMark(20);
		calculator.setPracticalMark(10);
		calculator.setFinalExamMark(60);
		//to be used in testing function of calculateFullMark()
		
		calculator.calculateGrade_GPA();
		assertEquals("A+", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
    */
    
	@Test
	//boundary test
	void testCalculateGrade_APlus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(100);
		calculator.calculateGrade_GPA();
		assertEquals("A+", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//positive test
	void testCalculateGrade_APlus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(98);
		calculator.calculateGrade_GPA();
		assertEquals("A+", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//boundary test
	void testCalculateGrade_APlus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(97);
		calculator.calculateGrade_GPA();
		assertEquals("A+", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//negative check
	void testCalculateGrade_APlus_4() {
		Student calculator = new Student();
		calculator.setTotalMark(96);
		calculator.calculateGrade_GPA();
		assertNotEquals("A+", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//negative check
	void testCalculateGrade_APlus_5() {
		Student calculator = new Student();
		calculator.setTotalMark(101);
		calculator.calculateGrade_GPA();
		assertNotEquals("A+", calculator.getGrade());
		assertNotEquals(4.0, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_A_1() {
		Student calculator = new Student();
		calculator.setTotalMark(93);
		calculator.calculateGrade_GPA();
		assertEquals("A", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_A_2() {
		Student calculator = new Student();
		calculator.setTotalMark(95);
		calculator.calculateGrade_GPA();
		assertEquals("A", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_A_3() {
		Student calculator = new Student();
		calculator.setTotalMark(90);
		calculator.calculateGrade_GPA();
		assertNotEquals("A", calculator.getGrade());
		assertNotEquals(4.0, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_A_4() {
		Student calculator = new Student();
		calculator.setTotalMark(98);
		calculator.calculateGrade_GPA();
		assertNotEquals("A", calculator.getGrade());
		assertEquals(4.0, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_AMinus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(89);
		calculator.calculateGrade_GPA();
		assertEquals("A-", calculator.getGrade());
		assertEquals(3.7, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_AMinus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(90);
		calculator.calculateGrade_GPA();
		assertEquals("A-", calculator.getGrade());
		assertEquals(3.7, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_AMinus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(95);
		calculator.calculateGrade_GPA();
		assertNotEquals("A-", calculator.getGrade());
		assertNotEquals(3.7, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_BPlus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(84);
		calculator.calculateGrade_GPA();
		assertEquals("B+", calculator.getGrade());
		assertEquals(3.3, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_BPlus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(87);
		calculator.calculateGrade_GPA();
		assertEquals("B+", calculator.getGrade());
		assertEquals(3.3, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_BPlus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(81);
		calculator.calculateGrade_GPA();
		assertNotEquals("B+", calculator.getGrade());
		assertNotEquals(3.3, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_B_1() {
		Student calculator = new Student();
		calculator.setTotalMark(80);
		calculator.calculateGrade_GPA();
		assertEquals("B", calculator.getGrade());
		assertEquals(3.0, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_B_2() {
		Student calculator = new Student();
		calculator.setTotalMark(82);
		calculator.calculateGrade_GPA();
		assertEquals("B", calculator.getGrade());
		assertEquals(3.0, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_B_3() {
		Student calculator = new Student();
		calculator.setTotalMark(77);
		calculator.calculateGrade_GPA();
		assertNotEquals("B", calculator.getGrade());
		assertNotEquals(3.0, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_BMinus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(76);
		calculator.calculateGrade_GPA();
		assertEquals("B-", calculator.getGrade());
		assertEquals(2.7, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_BMinus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(78);
		calculator.calculateGrade_GPA();
		assertEquals("B-", calculator.getGrade());
		assertEquals(2.7, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_BMinus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(75);
		calculator.calculateGrade_GPA();
		assertNotEquals("B-", calculator.getGrade());
		assertNotEquals(2.7, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_CPlus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(73);
		calculator.calculateGrade_GPA();
		assertEquals("C+", calculator.getGrade());
		assertEquals(2.3, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_CPlus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(74);
		calculator.calculateGrade_GPA();
		assertEquals("C+", calculator.getGrade());
		assertEquals(2.3, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_CPlus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(68);
		calculator.calculateGrade_GPA();
		assertNotEquals("C+", calculator.getGrade());
		assertNotEquals(2.3, calculator.getGPA());
	}
	
	
	
	@Test
	//boundary test
	void testCalculateGrade_C_1() {
		Student calculator = new Student();
		calculator.setTotalMark(70);
		calculator.calculateGrade_GPA();
		assertEquals("C", calculator.getGrade());
		assertEquals(2.0, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_C_2() {
		Student calculator = new Student();
		calculator.setTotalMark(72);
		calculator.calculateGrade_GPA();
		assertEquals("C", calculator.getGrade());
		assertEquals(2.0, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_C_3() {
		Student calculator = new Student();
		calculator.setTotalMark(68);
		calculator.calculateGrade_GPA();
		assertNotEquals("C", calculator.getGrade());
		assertNotEquals(2.0, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_CMinus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(67);
		calculator.calculateGrade_GPA();
		assertEquals("C-", calculator.getGrade());
		assertEquals(1.7, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_CMinus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(69);
		calculator.calculateGrade_GPA();
		assertEquals("C-", calculator.getGrade());
		assertEquals(1.7, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_CMinus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(65);
		calculator.calculateGrade_GPA();
		assertNotEquals("C-", calculator.getGrade());
		assertNotEquals(1.7, calculator.getGPA());
	}
	
	
	@Test
	//boundary test
	void testCalculateGrade_DPlus_1() {
		Student calculator = new Student();
		calculator.setTotalMark(64);
		calculator.calculateGrade_GPA();
		assertEquals("D+", calculator.getGrade());
		assertEquals(1.3, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_DPlus_2() {
		Student calculator = new Student();
		calculator.setTotalMark(65);
		calculator.calculateGrade_GPA();
		assertEquals("D+", calculator.getGrade());
		assertEquals(1.3, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_DPlus_3() {
		Student calculator = new Student();
		calculator.setTotalMark(63);
		calculator.calculateGrade_GPA();
		assertNotEquals("D+", calculator.getGrade());
		assertNotEquals(1.3, calculator.getGPA());
	}
	
	
	
	@Test
	//boundary test
	void testCalculateGrade_D_1() {
		Student calculator = new Student();
		calculator.setTotalMark(60);
		calculator.calculateGrade_GPA();
		assertEquals("D", calculator.getGrade());
		assertEquals(1.0, calculator.getGPA());
	}
	
	
	@Test
	//positive test
	void testCalculateGrade_D_2() {
		Student calculator = new Student();
		calculator.setTotalMark(63);
		calculator.calculateGrade_GPA();
		assertEquals("D", calculator.getGrade());
		assertEquals(1.0, calculator.getGPA());
	}
	
	@Test
	//negative test
	void testCalculateGrade_D_3() {
		Student calculator = new Student();
		calculator.setTotalMark(55);
		calculator.calculateGrade_GPA();
		assertNotEquals("D", calculator.getGrade());
		assertNotEquals(1.0, calculator.getGPA());
	}
	
	
	
	@Test
	//boundary test
	void testCalculateGrade_F_1() {
		Student calculator = new Student();
		calculator.setTotalMark(60);
		calculator.calculateGrade_GPA();
		assertNotEquals("F", calculator.getGrade());
		assertNotEquals(0.0, calculator.getGPA());
	}
	
	@Test
	//positive test
	void testCalculateGrade_F_2() {
		Student calculator = new Student();
		calculator.setTotalMark(50);
		calculator.calculateGrade_GPA();
		assertEquals("F", calculator.getGrade());
		assertEquals(0.0, calculator.getGPA());
	}
	
	@Test
	//positive test
	void testCalculateGrade_F_3() {
		Student calculator = new Student();
		calculator.setTotalMark(15);
		calculator.calculateGrade_GPA();
		assertEquals("F", calculator.getGrade());
		assertEquals(0.0, calculator.getGPA());
	}
	
	@Test
	//negative check
	void testCalculateGrade_F_4() {
		Student calculator = new Student();
		calculator.setTotalMark(70);
		calculator.calculateGrade_GPA();
		assertNotEquals("F", calculator.getGrade());
		assertNotEquals(0.0, calculator.getGPA());
	}
	
	/************************* Unit Testing: Student MARKS *******************************/
    //Testing_Validation
    
    @Test
    public void testCheckActivitiesMark() {
        Student markValidation = new Student();
        
        // Test with valid mark
        assertTrue(markValidation.checkActivitiesMark(8));
        
        // Test with mark less than minimum value
        assertFalse(markValidation.checkActivitiesMark(-2));
        
        // Test with mark greater than maximum value
        assertFalse(markValidation.checkActivitiesMark(12));
    }
    
    @Test
    public void testCheckOralMark() {
        Student oralValidation = new Student();
        
        // Test with valid mark
        assertTrue(oralValidation.checkOralMark(9));
        
        // Test with mark less than minimum value
        assertFalse(oralValidation.checkOralMark(-1));
        
        // Test with mark greater than maximum value
        assertFalse(oralValidation.checkOralMark(11));
    }
    
    @Test
    public void testCheckMidtermMark() {
        Student markValidation = new Student();
        
        // Test with valid mark
        assertTrue(markValidation.checkMidtermMark(18));
        
        // Test with mark less than minimum value
        assertFalse(markValidation.checkMidtermMark(-3));
        
        // Test with mark greater than maximum value
        assertFalse(markValidation.checkMidtermMark(21));
    }
    
    @Test
    public void testCheckFinalMark() {
        Student finalMarkValidation = new Student();
        
        // Test with valid mark
        assertTrue(finalMarkValidation.checkFinalMark(56));
        
        // Test with valid mark
        assertTrue(finalMarkValidation.checkFinalMark(18));
        
        // Test with mark less than minimum value
        assertFalse(finalMarkValidation.checkFinalMark(-4));
        
        // Test with mark greater than maximum value
        assertFalse(finalMarkValidation.checkFinalMark(63));
    }
    
    /************************* Unit Testing: Student Number *******************************/
    
    @Test
    public void testValidStudentNumber() {
        Student studentNumberValidation = new Student();
        assertTrue(studentNumberValidation.checkStudentNumber("1234567A"));
        assertTrue(studentNumberValidation.checkStudentNumber("9876543B"));
        assertTrue(studentNumberValidation.checkStudentNumber("53695327"));
    }
    
    @Test
    public void testStartWithNonNumeric() {
        Student studentNumberValidation = new Student();
        assertFalse(studentNumberValidation.checkStudentNumber("AB125A7B"));
        assertFalse(studentNumberValidation.checkStudentNumber("_DS24567"));
    }
    
    @Test
    public void testNonNumericNumericPart() {
        Student studentNumberValidation = new Student();
        assertFalse(studentNumberValidation.checkStudentNumber("12345A7B"));
        assertFalse(studentNumberValidation.checkStudentNumber("12-34567"));
    }
    
    @Test
    public void testInvalidLastCharacter() {
        Student studentNumberValidation = new Student();
        assertFalse(studentNumberValidation.checkStudentNumber("1234567#"));
        assertFalse(studentNumberValidation.checkStudentNumber("1234567*"));
    }
    
    @Test
    public void testInvalidLength() {
        Student studentNumberValidation = new Student();
        assertFalse(studentNumberValidation.checkStudentNumber("1234567"));
        assertFalse(studentNumberValidation.checkStudentNumber("123456789"));
    }
}