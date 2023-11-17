package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day18Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day18/Test1.txt").getPath());
        final Day18 day18 = new Day18(fileReader);
        Assertions.assertThat(day18.firstRecoveredFrequency()).isEqualTo(4);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day18/input.txt").getPath());
        final Day18 day18 = new Day18(fileReader);
        Assertions.assertThat(day18.firstRecoveredFrequency()).isEqualTo(4601);
    }

    @Test
    public void test1b() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day18/Test2.txt").getPath());
        final Day18 day18 = new Day18(fileReader);
        Assertions.assertThat(day18.programOneSends()).isEqualTo(3);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day18/input.txt").getPath());
        final Day18 day18 = new Day18(fileReader);
        Assertions.assertThat(day18.programOneSends()).isEqualTo(6858);
    }

}