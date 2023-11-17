package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day21Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day21/Test1.txt").getPath());
        final Day21 day21 = new Day21(fileReader);
        day21.iterate(2);
        Assertions.assertThat(day21.pixelsOn()).isEqualTo(12);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day21/input.txt").getPath());
        final Day21 day21 = new Day21(fileReader);
        day21.iterate(5);
        Assertions.assertThat(day21.pixelsOn()).isEqualTo(208);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day21/input.txt").getPath());
        final Day21 day21 = new Day21(fileReader);
        day21.iterate(18);
        Assertions.assertThat(day21.pixelsOn()).isEqualTo(2480380);
    }

}