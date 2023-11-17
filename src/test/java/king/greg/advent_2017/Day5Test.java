package king.greg.advent_2017;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.Test;

public class Day5Test {

	
	@Test
	public void test1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day5/Test1.txt").getPath());
		assertThat(Day5.jumpCount(fileReader)).isEqualTo(5);
	}
	
	
	@Test
	public void testSolution() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day5/input.txt").getPath());
		assertThat(Day5.jumpCount(fileReader)).isEqualTo(387096);
	}
	
	@Test
	public void test1Count2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day5/Test1.txt").getPath());
		assertThat(Day5.jumpCount2(fileReader)).isEqualTo(10);
	}
	
	
	@Test
	public void testSolutionCount2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day5/input.txt").getPath());
		assertThat(Day5.jumpCount2(fileReader)).isEqualTo(28040648);
	}

}
