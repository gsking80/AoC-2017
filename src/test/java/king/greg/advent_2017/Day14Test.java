package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day14Test {

    @Test
    public void test1a() {
        final Day14 day14 = new Day14();
        Assertions.assertThat(day14.usedSquares("flqrgnkx")).isEqualTo(8108);
    }

    @Test
    public void testSolution1() {
        final Day14 day14 = new Day14();
        Assertions.assertThat(day14.usedSquares("hxtvlmkl")).isEqualTo(8214);
    }

    @Test
    public void test2a() {
        final Day14 day14 = new Day14();
        Assertions.assertThat(day14.regions("flqrgnkx")).isEqualTo(1242);
    }

    @Test
    public void testSolution2() {
        final Day14 day14 = new Day14();
        Assertions.assertThat(day14.regions("hxtvlmkl")).isEqualTo(1093);
    }
}