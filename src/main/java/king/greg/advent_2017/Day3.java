package king.greg.advent_2017;

public class Day3 {
	
	public static int calculateSteps(final int start) {
		
// 		https://oeis.org/A214526
//		https://oeis.org/A141481
		
		final double L = Math.ceil(0.5 * (Math.sqrt(start) - 1));
		final double dist = L + Math.abs( ((start - 1) % (2 * L) ) - L );
		
		return (int)dist;
	}

}
