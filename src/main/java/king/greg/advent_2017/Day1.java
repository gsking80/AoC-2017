package king.greg.advent_2017;

public class Day1 {

	public static int captcha (final String input) {
		int sum = 0;
		
		for (int i = 0;i < input.length();i++) {
			if (input.charAt(i) == (input.charAt((i + 1) % input.length()))) {
				sum += Character.getNumericValue(input.charAt(i));
			}
		}	
		return sum;
	}
	
	public static int captchaHalf (final String input) {
		int sum = 0;
		
		for (int i = 0;i < input.length();i++) {
			final int j = (i + input.length()/2) % (input.length());
			System.out.println(input + " length: " + input.length() + " i: " + i + " j: " + j);
			if (input.charAt(i) == input.charAt(j)) {
				sum += Character.getNumericValue(input.charAt(i));
			}
		}	
		return sum;
	}
}
