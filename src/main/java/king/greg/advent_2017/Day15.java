package king.greg.advent_2017;

public class Day15 {

    final static long FACTOR_A = 16807;
    final static long FACTOR_B = 48271;
    final static long DIVISOR = 2147483647;

    final static long matches (final long aStart, final long bStart, final long iterations) {
        return matches(aStart, bStart, iterations, false);
    }

    final static long matches (final long aStart, final long bStart, final long iterations, final boolean phase2) {
        long a = aStart;
        long b = bStart;
        long matches = 0;
        for (long i = 0; i < iterations; i++) {
            a = generateNext(a, FACTOR_A, phase2 ? 4 : 1);
            b = generateNext(b, FACTOR_B, phase2 ? 8 : 1);
            if (pairMatch(a, b)) {
                matches++;
            }
        }
        return matches;
    }

    private static boolean pairMatch(long a, long b) {
//        final String binaryA = String.format("%32s", BigInteger.valueOf(a).toString(2)).replace(' ', '0');
//        final String binaryB = String.format("%32s", BigInteger.valueOf(b).toString(2)).replace(' ', '0');
//        return binaryA.substring(16).equals(binaryB.substring(16));

        return (a % 65536) == (b % 65536);
    }

    final static long generateNext(final long input, final long factor, final long multiple) {
        final long result = (input * factor) % DIVISOR;
        if (result % multiple == 0) {
            return result;
        }
        return generateNext(result, factor, multiple);
    }

}
