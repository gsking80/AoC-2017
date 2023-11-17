package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day11Test {

    @Test
    public void test1a() {
        final Day11 day11 = new Day11();
        day11.track("ne,ne,ne");
        Assertions.assertThat(day11.minimumSteps()).isEqualTo(3);
    }

    @Test
    public void test1b() {
        final Day11 day11 = new Day11();
        day11.track("ne,ne,sw,sw");
        Assertions.assertThat(day11.minimumSteps()).isEqualTo(0);
    }

    @Test
    public void test1c() {
        final Day11 day11 = new Day11();
        day11.track("ne,ne,s,s");
        Assertions.assertThat(day11.minimumSteps()).isEqualTo(2);
    }

    @Test
    public void test1d() {
        final Day11 day11 = new Day11();
        day11.track("se,sw,se,sw,sw");
        Assertions.assertThat(day11.minimumSteps()).isEqualTo(3);
    }

    @Test
    public void testSolution1() throws IOException {
        final Day11 day11 = new Day11();
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("day11/input.txt").getPath());
        final BufferedReader buf = new BufferedReader(fileReader);
        day11.track(buf.readLine());
        Assertions.assertThat(day11.minimumSteps()).isEqualTo(834);
        Assertions.assertThat(day11.getFarthest()).isEqualTo(1569);
    }

}