package Dev;


public class Subject {
	
	private String subjectName;
	private String subjectCode;
	private int fullMark;
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	public void setFullMark(int fullMark) {
		this.fullMark = fullMark;
	}
	
	public int getFullMark() {
		return fullMark;
	}

	/*
	 * Checks if the subject name is valid.
	 * Subject name should not be empty, should not start with a space,
	 * and should contain only alphabetic characters or spaces.
	 */

	
	public boolean checkSubjectName(String subjectName)
	{
		/*subject name shouldn't be empty */
		if(subjectName.isEmpty())
		{
			System.out.println("Invalid name: Subject Name shouldn't be empty\n");
			return false;
		}
		
		if(subjectName.startsWith(" "))
		{
			System.out.println("Invalid name: Subject Name shouldn't Start with a space\n");
			return false;
		}
		
		for(int i = 0; i < subjectName.length(); i++)
		{
			char ch = subjectName.charAt(i);
			
			if ( !((Character.isLetter(ch)) || (Character.isSpaceChar(ch))) )
			{
				System.out.println("Invalid name: Subject Name must be only alphabetic or space\n");
				return false;
			}
		}
		
		return true;
	}

	/*
	 * Checks if the subject code length is valid.
	 * Subject code should be exactly 6 or 7 characters long.
	 */
	
	public boolean subjectCodeLength(String subjectCode) {
		
		if (!((subjectCode.length() == 7) || (subjectCode.length() == 6))) {
			System.out.println("Invalid subject code: The length should be exactly 6 or 7");
			return false;
		}
		return true;
	}
	
	/*
	 * Checks if the alphabetic part of the subject code is valid.
	 * The first 3 characters of the subject code should be alphabetic.
	 */
	public boolean subjectCodeAlphabeticPart(String subjectCode) {
		String alphabeticPart = subjectCode.substring(0, 3);
		for (int i = 0; i < alphabeticPart.length(); i++) {
			char ch = alphabeticPart.charAt(i);

			if (!((Character.isLetter(ch)))) {
				System.out.println("Invalid name: The first 3 characters must be alphabetic\n");
				return false;
			}
		}
		return true;
	}
	

	/*
	 * Checks if the numeric part of the subject code is valid.
	 * The next 3 characters after the alphabetic part should be numeric.
	 */
	public boolean subjectCodeNumericPart(String subjectCode) {
		String numericPart = subjectCode.substring(3,6);
		// Check if the numeric part of the string is numeric
		if (!numericPart.matches("\\d+")) {
			System.out.println("Invalid subject code: The second 3 characters must be numeric");
			return false;
		}
		return true;
	}
	/*
	 * Checks if the last character of the subject code is valid.
	 * The last character should be 's' if it exists.
	 */
	public boolean subjectCodeLastChar(String subjectCode) {
		// Check for the last char
		if (subjectCode.length() == 7) 
		{
			char lastChar = subjectCode.charAt(6);

			if (lastChar != 's') {
				System.out.println("Invalid subject code: Last char must be only 's' if exist");
				return false;
			}
		}

		return true;
	}
	
	public boolean checkSubjectCode(String subjectCode) {
		if ((subjectCodeLength(subjectCode)) && (subjectCodeAlphabeticPart(subjectCode)) &&
		(subjectCodeNumericPart(subjectCode)) && (subjectCodeLastChar(subjectCode))){
			return true;
		}
		return false;
	}
	
	
	/*
	public boolean checkSubjectCode(String subjectCode) 
	{
		//The length must be exactly 7 or 6 
		if (!((subjectCode.length() == 7) || (subjectCode.length() == 6))) {
			System.out.println("Invalid subject code: The length should be exactly 6 or 7");
			return false;
		}

		String numericPart = subjectCode.substring(3, 5);
		String alphabeticPart = subjectCode.substring(0, 2);

		for (int i = 0; i < alphabeticPart.length(); i++) {
			char ch = alphabeticPart.charAt(i);

			if (!((Character.isLetter(ch)))) {
				System.out.println("Invalid name: The first 3 characters must be alphabetic\n");
				return false;
			}
		}

		// Check if the numeric part of the string is numeric
		if (!numericPart.matches("\\d+")) {
			System.out.println("Invalid subject code: The second 3 characters must be numeric");
			return false;
		}

		// Check for the last char
		if (subjectCode.length() == 7) 
		{
			char lastChar = subjectCode.charAt(6);

			if (lastChar != 's') {
				System.out.println("Invalid subject code: Last char must be only 's' if exist");
				return false;
			}
		}

		return true;
	}
*/
	
	/* Full Mark should be 100  */
	public boolean checkFullMark(int fullMark)
	{
		if((fullMark != 100))
		{
			System.out.println("Invalid Full Mark: Should be 100");
			return false;
		}
		
		return true;
	}
}
