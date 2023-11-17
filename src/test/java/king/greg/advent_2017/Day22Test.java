package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day22Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/Test1.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(7)).isEqualTo(5);
    }

    @Test
    public void test1b() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/Test1.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(70)).isEqualTo(41);
    }

    @Test
    public void test1c() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/Test1.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(10000)).isEqualTo(5587);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/input.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(10000)).isEqualTo(5369);
    }

    @Test
    public void test2a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/Test1.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(100, true)).isEqualTo(26);
    }

    @Test
    public void test2b() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/Test1.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(10000000, true)).isEqualTo(2511944);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day22/input.txt").getPath());
        final Day22 day22 = new Day22(fileReader);
        Assertions.assertThat(day22.bursts(10000000, true)).isEqualTo(2510774);
    }

}