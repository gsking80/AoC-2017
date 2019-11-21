package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class Day19Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day19/Test1.txt").getPath());
        final Day19 day19 = new Day19(fileReader);
        Assertions.assertThat(day19.traverse()).isEqualTo("ABCDEF");
        Assertions.assertThat(day19.getSteps()).isEqualTo(38);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day19/input.txt").getPath());
        final Day19 day19 = new Day19(fileReader);
        Assertions.assertThat(day19.traverse()).isEqualTo("YOHREPXWN");
        Assertions.assertThat(day19.getSteps()).isEqualTo(16734);
    }

}