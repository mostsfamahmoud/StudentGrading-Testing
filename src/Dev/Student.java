 package Dev;

public class Student {
	
	private String studentName;
	private String studentNumber;
	
	private int activitiesMark;
	private int practicalMark;
	private int midtermExamMark;
	private int finalExamMark;
	private int totalMark;
	
	private String grade;
	private double GPA;
	
	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	public String getGrade() {
		calculateGrade_GPA();
		return grade;
	}

	public double getGPA() {
		calculateGrade_GPA();
		return GPA;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public int getStudentNameLength()
	{
		return studentName.length();
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getActivitiesMark() {
		return activitiesMark;
	}

	public void setActivitiesMark(int activitiesMark) {
		this.activitiesMark = activitiesMark;
	}

	public int getPracticalMark() {
		return practicalMark;
	}

	public void setPracticalMark(int practicalMark) {
		this.practicalMark = practicalMark;
	}

	public int getMidtermExamMark() {
		return midtermExamMark;
	}

	public void setMidtermExamMark(int midtermExamMark) {
		this.midtermExamMark = midtermExamMark;
	}

	public int getFinalExamMark() {
		return finalExamMark;
	}

	public void setFinalExamMark(int finalExamMark) {
		this.finalExamMark = finalExamMark;
	}
	
	
	public void calculateFullMark()
	{
		totalMark = activitiesMark + practicalMark 
				+ finalExamMark + midtermExamMark;
	}
	
	public void calculateGrade_GPA() 
	{
		
        if ((totalMark >= 97) && (totalMark <= 100)) {
            grade = "A+";
            GPA = 4.0;
        } 
        else if ((totalMark >= 93) && (totalMark < 97)) {
            grade = "A";
            GPA = 4.0;
        } 
        else if ((totalMark >= 89)&& (totalMark < 93)) {
            grade = "A-";
            GPA = 3.7;
        } 
        else if ((totalMark >= 84) && (totalMark < 89)) {
            grade = "B+";
            GPA = 3.3;
        } 
        else if ((totalMark >= 80) && (totalMark < 84)) {
            grade = "B";
            GPA = 3.0;
        } 
        else if ((totalMark >= 76) && (totalMark < 80)) {
            grade = "B-";
            GPA = 2.7;
        } 
        else if ((totalMark >= 73) && (totalMark < 76)) {
            grade = "C+";
            GPA = 2.3;
        } 
        else if ((totalMark >= 70) && (totalMark < 73)) {
            grade = "C";
            GPA = 2.0;
        } 
        else if ((totalMark >= 67) && (totalMark < 70)) {
            grade = "C-";
            GPA = 1.7;
        } 
        else if ((totalMark >= 64) && (totalMark < 67)) {
            grade = "D+";
            GPA = 1.3;
        } 
        else if ((totalMark >= 60) && (totalMark < 64)) {
            grade = "D";
            GPA = 1.0;
        } 
        else if (totalMark < 60) {
            grade = "F";
            GPA = 0.0;
        }
        else {
        	System.out.println("out of range !");
        }
    }
/*
	@Override
	public String toString() {
		return "StudentName : " + studentName + "\nStudentNumber : " + studentNumber + 
				"\nActivitiesMark : " + activitiesMark + "\nPracticalMark : " + practicalMark + "\nMidtermExamMark : " + midtermExamMark
				+ "\nFinalExamMark : " + finalExamMark;
	}
	*/
	
	
	/******************************** TESTING FUNCTIONS *********************************/

	public boolean checkStudentName(String name)
	{
		if(name.isEmpty())
		{
			System.out.println("Invalid name: Name shouldn't be EMPTY\n");
			return false;
		}
		
		if(name.startsWith(" "))
		{
			System.out.println("Invalid name: Name shouldn't Start with a space\n");
			return false;
		}
		
		for(int i = 0; i < name.length(); i++)
		{
			char ch = name.charAt(i);
			
			if ( !((Character.isLetter(ch)) || (Character.isSpaceChar(ch))) )
			{
				System.out.println("Invalid name: Name must be only alphabetic or space\n");
				return false;
			}
		}
		return true;
	}
	
	
	/* The length of Student number field must be Alphanumeric characters of exact length of 8 characters.
	 * It should start with numbers and might End with only one Alphabetic character
	 */
	public boolean checkStudentNumber(String studentNumber)
	{
		/* The length must be exactly 8 Alphanumeric characters */
		if(studentNumber.length() != 8)
		{
			return false;
		}
		
		/* It should start with numbers and might end with only one char */
		
		// Remove the last character from the string
	    String numericPart = studentNumber.substring(0, 7);
	    
	    // Check if the numeric part of the string is numeric
	    if (!numericPart.matches("\\d+")) 
	    {
	    	return false;
	    }
	    
	    //Check for the last char
	    char lastChar = studentNumber.charAt(7);
	    if(!((Character.isLetter(lastChar)) || (Character.isDigit(lastChar))))
	    {
	    	return false;
	    }
	    
	    return true;
	}
	
	/* Activities Mark should be greater than 0 and smaller than or equal to 10  */
	public boolean checkActivitiesMark(int activitiesMark)
	{
		if(!((activitiesMark >= 0) && (activitiesMark <=10)))
		{
			return false;
		}
		return true;
	}
	
	/* Oral Mark should be greater than 0 and smaller than or equal to 10  */
	public boolean checkOralMark(int oralMark)
	{
		if(!((oralMark >= 0) && (oralMark <=10)))
		{
			return false;
		}
		return true;
	}
	
	/* Midterm Mark should be greater than 0 and smaller than or equal to 20  */
	public boolean checkMidtermMark(int MidtermMark)
	{
		if(!((MidtermMark >= 0) && (MidtermMark <=20)))
		{
			return false;
		}
		return true;
	}
	
	/* Final Mark should be greater than 0 and smaller than or equal to 60 */
	public boolean checkFinalMark(int FinalMark)
	{
		if(!((FinalMark >= 0) && (FinalMark <=60)))
		{
			return false;
		}
		return true;
	}
}
