package king.greg.advent_2017;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day25Test {

    @Test
    public void testSolution1() {
        final Day25 day25 = new Day25();
        Assertions.assertThat(day25.checksumAfter('A', 12459852)).isEqualTo(4217);
    }

}