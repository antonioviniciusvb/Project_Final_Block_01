package project_final_block_01.util;

public class Validator {
	
	public static String patternOnlyOneNumber = "^[0-9]$";
	
	public static boolean test(String subject, String pattern) {
		
		return subject.matches(pattern);
		
	}

}
