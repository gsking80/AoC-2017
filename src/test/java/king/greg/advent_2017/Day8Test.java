package king.greg.advent_2017;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.Test;

public class Day8Test {

	@Test
	public void test1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day8/Test1.txt").getPath());
		final Day8 day8 = new Day8();
		day8.execute(fileReader);
		assertThat(day8.maxRegisterValue()).isEqualTo(1);
	}
	
	@Test
	public void testSolution1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day8/input.txt").getPath());
		final Day8 day8 = new Day8();
		day8.execute(fileReader);
		assertThat(day8.maxRegisterValue()).isEqualTo(5221);
	}
	
	@Test
	public void test2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day8/Test1.txt").getPath());
		final Day8 day8 = new Day8();
		day8.execute(fileReader);
		assertThat(day8.maxRegisterAllTime()).isEqualTo(10);
	}
	
	@Test
	public void testSolution2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day8/input.txt").getPath());
		final Day8 day8 = new Day8();
		day8.execute(fileReader);
		assertThat(day8.maxRegisterAllTime()).isEqualTo(7491);
	}

}
