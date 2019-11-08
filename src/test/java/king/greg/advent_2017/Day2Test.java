package king.greg.advent_2017;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import org.junit.Test;

public class Day2Test {

	@Test
	public void test1() throws FileNotFoundException, URISyntaxException {


			final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day2/Sample.txt").getPath());
			assertThat(Day2.checksum(fileReader)).isEqualTo(18);
	}
	
	@Test
	public void testInput() throws FileNotFoundException, URISyntaxException {

			final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day2/input.txt").getPath());
			assertThat(Day2.checksum(fileReader)).isEqualTo(44887);
	}
	
	
	@Test
	public void testDivisor1() throws FileNotFoundException, URISyntaxException {

			final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day2/Sample2.txt").getPath());
			assertThat(Day2.checksumDivisor(fileReader)).isEqualTo(9);
	}
	
	@Test
	public void testDivisorInput() throws FileNotFoundException, URISyntaxException {

			final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day2/input.txt").getPath());
			assertThat(Day2.checksumDivisor(fileReader)).isEqualTo(242);
	}

}
