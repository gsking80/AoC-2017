package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day7Test {

	@Test
	public void test1() throws FileNotFoundException {
		final Day7 circus = new Day7();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day7/Test1.txt").getPath());
		circus.loadCircus(fileReader);
		Assertions.assertThat(circus.findBaseProgram()).isEqualTo("tknk");
		circus.checkBalance("tknk");
	}
	
	@Test
	public void testSolution() throws FileNotFoundException {
		final Day7 circus = new Day7();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day7/input.txt").getPath());
		circus.loadCircus(fileReader);
		Assertions.assertThat(circus.findBaseProgram()).isEqualTo("eqgvf");
	}
	
	@Test
	public void test2() throws FileNotFoundException {
		final Day7 circus = new Day7();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day7/Test1.txt").getPath());
		circus.loadCircus(fileReader);
		circus.checkBalance("tknk");
	}
	
	@Test
	public void testSolution2() throws FileNotFoundException {
		final Day7 circus = new Day7();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day7/input.txt").getPath());
		circus.loadCircus(fileReader);
		circus.checkBalance("eqgvf");
	}

}
