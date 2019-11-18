package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day13Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day13/Test1.txt").getPath());
        final Day13 day13 = new Day13(fileReader);
        Assertions.assertThat(day13.severity(0)).isEqualTo(24);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day13/input.txt").getPath());
        final Day13 day13 = new Day13(fileReader);
        Assertions.assertThat(day13.severity(0)).isEqualTo(1844);
    }

    @Test
    public void test2a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day13/Test1.txt").getPath());
        final Day13 day13 = new Day13(fileReader);
        Assertions.assertThat(day13.earliestSafeStart()).isEqualTo(10);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day13/input.txt").getPath());
        final Day13 day13 = new Day13(fileReader);
        Assertions.assertThat(day13.earliestSafeStart()).isEqualTo(3897604);
    }

}