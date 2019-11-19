package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day17Test {

    @Test
    public void test1a() {

        final Day17 day17 = new Day17(3, 2017);
        Assertions.assertThat(day17.valueAfter(2017)).isEqualTo(638);

    }

    @Test
    public void testSolution1() {

        final Day17 day17 = new Day17(301, 2017);
        Assertions.assertThat(day17.valueAfter(2017)).isEqualTo(1642);

    }

    @Test
    public void testSolution2() {

        Assertions.assertThat(Day17.valueAtIndex(301, 50000000, 1)).isEqualTo(33601318);

    }


}