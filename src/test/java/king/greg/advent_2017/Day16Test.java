package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class Day16Test {

    @Test
    public void test1a() throws IOException {
        final Day16 day16 = new Day16("abcde");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day16/Test1.txt").getPath());
        final BufferedReader buf = new BufferedReader(fileReader);
        Assertions.assertThat(day16.dance(buf.readLine())).isEqualTo("baedc");
        buf.close();
    }

    @Test
    public void testSolution1() throws IOException {
        final Day16 day16 = new Day16("abcdefghijklmnop");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day16/input.txt").getPath());
        final BufferedReader buf = new BufferedReader(fileReader);
        Assertions.assertThat(day16.dance(buf.readLine())).isEqualTo("pkgnhomelfdibjac");
        buf.close();
    }

    @Test
    public void test2a() throws IOException {
        final Day16 day16 = new Day16("abcde");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day16/Test1.txt").getPath());
        final BufferedReader buf = new BufferedReader(fileReader);
        Assertions.assertThat(day16.dance(buf.readLine(), 1000000000)).isEqualTo("abcde");
        buf.close();
    }

    @Test
    public void testSolution2() throws IOException {
        final Day16 day16 = new Day16("abcdefghijklmnop");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day16/input.txt").getPath());
        final BufferedReader buf = new BufferedReader(fileReader);
        Assertions.assertThat(day16.dance(buf.readLine(), 1000000000)).isEqualTo("pogbjfihclkemadn");
        buf.close();
    }

}