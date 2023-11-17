package king.greg.advent_2017;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day23Test {

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day23/input.txt").getPath());
        final Day23 day23 = new Day23(fileReader);
        Assertions.assertThat(day23.execute()).isEqualTo(8281);
    }

    @Test
    public void testSolution2() {
        Assertions.assertThat(Day23.nonPrimes(109300, 126300, 17)).isEqualTo(911);
    }

}