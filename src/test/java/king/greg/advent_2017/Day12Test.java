package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day12Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day12/Test1.txt").getPath());
        final Day12 day12 = new Day12(fileReader);
        Assertions.assertThat(day12.programCount("0")).isEqualTo(6);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day12/input.txt").getPath());
        final Day12 day12 = new Day12(fileReader);
        Assertions.assertThat(day12.programCount("0")).isEqualTo(288);
    }

    @Test
    public void test2a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day12/Test1.txt").getPath());
        final Day12 day12 = new Day12(fileReader);
        Assertions.assertThat(day12.totalGroups()).isEqualTo(2);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day12/input.txt").getPath());
        final Day12 day12 = new Day12(fileReader);
        Assertions.assertThat(day12.totalGroups()).isEqualTo(211);
    }

}