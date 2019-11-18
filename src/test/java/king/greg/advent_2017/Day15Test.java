package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day15Test {

    @Test
    public void test1a() {
        Assertions.assertThat(Day15.generateNext(65,Day15.FACTOR_A, 1)).isEqualTo(1092455);
        Assertions.assertThat(Day15.generateNext(8921,Day15.FACTOR_B, 1)).isEqualTo(430625591);
    }

    @Test
    public void test1b() {
        Assertions.assertThat(Day15.matches(65,8921, 5)).isEqualTo(1);
    }

    @Test
    public void test1c() {
        Assertions.assertThat(Day15.matches(65, 8921, 40000000)).isEqualTo(588);
    }

    @Test
    public void testSolution1() {
        Assertions.assertThat(Day15.matches(722, 354, 40000000)).isEqualTo(612);
    }

    @Test
    public void test2a() {
        Assertions.assertThat(Day15.matches(65, 8921, 5000000, true)).isEqualTo(309);
    }

    @Test
    public void testSolution2() {
        Assertions.assertThat(Day15.matches(722, 354, 5000000, true)).isEqualTo(285);
    }

}