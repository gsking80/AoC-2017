package king.greg.advent_2017;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day9Test {

	@Test
	public void test1a() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{}")).isEqualTo(1);
	}
	
	@Test
	public void test1b() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{{}}}")).isEqualTo(6);
	}
	
	@Test
	public void test1c() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{},{}}")).isEqualTo(5);
	}
	
	@Test
	public void test1d() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{{},{},{{}}}}")).isEqualTo(16);
	}
	
	@Test
	public void test1e() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{<a>,<a>,<a>,<a>}")).isEqualTo(1);
	}
	
	@Test
	public void test1f() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{<ab>},{<ab>},{<ab>},{<ab>}}")).isEqualTo(9);
	}
	
	@Test
	public void test1g() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{<!!>},{<!!>},{<!!>},{<!!>}}")).isEqualTo(9);
	}
	
	@Test
	public void test1h() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.scoreString("{{<a!>},{<a!>},{<a!>},{<ab>}}")).isEqualTo(3);
	}
	
	@Test
	public void testSolution1() throws IOException {
		final Day9 day9= new Day9();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day9/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		Assertions.assertThat(day9.scoreString(buf.readLine())).isEqualTo(12505);
		buf.close();
	}
	
	@Test
	public void test2a() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<>")).isEqualTo(0);
	}
	
	@Test
	public void test2b() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<random characters>")).isEqualTo(17);
	}
	
	@Test
	public void test2c() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<<<<>")).isEqualTo(3);
	}
	
	@Test
	public void test2d() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<{!>}>")).isEqualTo(2);
	}
	
	@Test
	public void test2e() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<!!>")).isEqualTo(0);
	}
	
	@Test
	public void test2f() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<!!!>>")).isEqualTo(0);
	}
	
	@Test
	public void test2g() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("<{o\"i!a,<{i<a>")).isEqualTo(10);
	}
	
	@Test
	public void testSolution2() throws IOException {
		final Day9 day9= new Day9();
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day9/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		Assertions.assertThat(day9.garbageCount(buf.readLine())).isEqualTo(6671);
		buf.close();
	}
	
	@Test
	public void test2h() {
		final Day9 day9= new Day9();
		Assertions.assertThat(day9.garbageCount("{{<!!>},{<!!>},{<!!>},{<!!>}}")).isEqualTo(0);
	}

}
