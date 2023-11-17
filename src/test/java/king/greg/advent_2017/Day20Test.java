package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day20Test {

	@Test
	public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day20/Test1.txt").getPath());
		final Day20 day20 = new Day20(fileReader);
		Assertions.assertThat(day20.staysClosest()).isEqualTo(0);
	}

	@Test
	public void testSolution1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day20/input.txt").getPath());
		final Day20 day20 = new Day20(fileReader);
		Assertions.assertThat(day20.staysClosest()).isEqualTo(161);
	}

	@Test
	public void test2a() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day20/Test2.txt").getPath());
		final Day20 day20 = new Day20(fileReader);
		Assertions.assertThat(day20.nonCollided()).isEqualTo(1);
	}

	@Test
	public void testSolution2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day20/input.txt").getPath());
		final Day20 day20 = new Day20(fileReader);
		Assertions.assertThat(day20.nonCollided()).isEqualTo(438);
	}
	
}