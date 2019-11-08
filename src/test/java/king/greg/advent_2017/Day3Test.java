package king.greg.advent_2017;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Day3Test {

	@Test
	public void test1() {
		assertThat(Day3.calculateSteps(1)).isEqualTo(0);
	}
	
	@Test
	public void test2() {
		assertThat(Day3.calculateSteps(12)).isEqualTo(3);
	}
	
	@Test
	public void test3() {
		assertThat(Day3.calculateSteps(23)).isEqualTo(2);
	}
	
	@Test
	public void test4() {
		assertThat(Day3.calculateSteps(1024)).isEqualTo(31);
	}

	@Test
	public void testSolution() {
		assertThat(Day3.calculateSteps(347991)).isEqualTo(480);
	}
	
}
