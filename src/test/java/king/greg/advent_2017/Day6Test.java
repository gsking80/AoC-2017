package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day6Test {

	@Test
	public void test1() {
		final Integer[] banks = {0,2,7,0};
		Assertions.assertThat(Day6.rebalancer(banks)).isEqualTo(5);
	}
	
	@Test
	public void testSolution() {
		final Integer[] banks = {4,	1,	15,	12,	0,	9,	9,	5,	5,	8,	7,	3,	14,	5,	12,	3};
		Assertions.assertThat(Day6.rebalancer(banks)).isEqualTo(6681);
	}
	
	@Test
	public void testLoop1() {
		final Integer[] banks = {0,2,7,0};
		Assertions.assertThat(Day6.rebalancerLoopSize(banks)).isEqualTo(4);
	}
	
	@Test
	public void testLoopSolution() {
		final Integer[] banks = {4,	1,	15,	12,	0,	9,	9,	5,	5,	8,	7,	3,	14,	5,	12,	3};
		Assertions.assertThat(Day6.rebalancerLoopSize(banks)).isEqualTo(2392);
	}

}
