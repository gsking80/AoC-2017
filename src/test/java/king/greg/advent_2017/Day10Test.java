package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day10Test {

	@Test
	public void test1a() {
		final Day10 day10 = new Day10(5);
		day10.hashString("3,4,1,5");
		day10.sparseHash(1);
		Assertions.assertThat(day10.firstProduct()).isEqualTo(12);
	}

	@Test
	public void testSolution1() throws IOException {
		final Day10 day10 = new Day10(256);
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day10/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		day10.hashString(buf.readLine());
		buf.close();
		day10.sparseHash(1);
		Assertions.assertThat(day10.firstProduct()).isEqualTo(62238);
	}

	@Test
	public void test2a() {
		final Day10 day10 = new Day10(256);
		Assertions.assertThat(day10.knotHash("")).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
	}

	@Test
	public void test2b() {
		final Day10 day10 = new Day10(256);
		Assertions.assertThat(day10.knotHash("AoC 2017")).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd");
	}

	@Test
	public void test2c() {
		final Day10 day10 = new Day10(256);
		day10.hashBytes("1,2,3");
		day10.sparseHash(64);
		day10.denseHash();
		Assertions.assertThat(day10.knotValue()).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
	}

	@Test
	public void test2d() {
		final Day10 day10 = new Day10(256);
		day10.hashBytes("1,2,4");
		day10.sparseHash(64);
		day10.denseHash();
		Assertions.assertThat(day10.knotValue()).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
	}

	@Test
	public void testSolution2() throws IOException {
		final Day10 day10 = new Day10(256);
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day10/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		day10.hashBytes(buf.readLine());
		buf.close();
		day10.sparseHash(64);
		day10.denseHash();
		Assertions.assertThat(day10.knotValue()).isEqualTo("2b0c9cc0449507a0db3babd57ad9e8d8");
	}
}
