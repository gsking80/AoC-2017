package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day24Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day24/Test1.txt").getPath());
        final Day24 day24 = new Day24(fileReader);
        Assertions.assertThat(day24.strongestBridge(0)).isEqualTo(31);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day24/input.txt").getPath());
        final Day24 day24 = new Day24(fileReader);
        Assertions.assertThat(day24.strongestBridge(0)).isEqualTo(1511);
    }

    @Test
    public void test2a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day24/Test1.txt").getPath());
        final Day24 day24 = new Day24(fileReader);
        Assertions.assertThat(day24.longestBridge(0)).isEqualTo(19);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day24/input.txt").getPath());
        final Day24 day24 = new Day24(fileReader);
        Assertions.assertThat(day24.longestBridge(0)).isEqualTo(1471);
    }

}