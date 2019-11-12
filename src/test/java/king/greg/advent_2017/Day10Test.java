package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day10Test {

	@Test
	public void test1a() {
		final Day10 day10 = new Day10(5);
		day10.hash("3, 4, 1, 5");
		Assertions.assertThat(day10.firstProduct()).isEqualTo(12);
	}

}
