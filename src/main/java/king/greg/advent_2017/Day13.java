package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Day13 {

    final Map<Integer, Integer> scanners = new HashMap<>();
    int maxDepth = 0;

    public Day13(FileReader fileReader) {

        try {
            final BufferedReader buf = new BufferedReader(fileReader);

            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    process(lineJustFetched);
                }
            }
        } catch (IOException ioe) {

        }

    }

    private void process(final String input) {
        final int[] scanner = Pattern.compile(": ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        if (scanner[0] > maxDepth) {
            maxDepth = scanner[0];
        }
        scanners.put(scanner[0],scanner[1]);
    }

    public int severity(final int startingTime) {
        int severity = 0;

        for (int depth = 0; depth <= maxDepth; depth++) {
            final int range = scanners.getOrDefault(depth, 0);
            if (((depth + startingTime) % ((range - 1) * 2)) == 0) {
                severity += (depth * range);
            }
        }

        return severity;
    }

    public boolean caught(final int startingTime) {
        for (int depth = 0; depth <= maxDepth; depth++) {
            final int range = scanners.getOrDefault(depth, 0);
            if (range == 0) {
                continue;
            }
            if (((depth + startingTime) % ((range - 1) * 2)) == 0) {
//                System.out.println("Caught! Depth = " + depth + ", Starting time = " + startingTime);
                return true;
            }
        }
        return false;
    }

    public int earliestSafeStart() {
        int delay = 0;

        while (true) {
            if (!caught(delay)) {
                return delay;
            }
            delay++;
        }
    }
}
