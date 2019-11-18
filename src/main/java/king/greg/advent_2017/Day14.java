package king.greg.advent_2017;

import java.math.BigInteger;

public class Day14 {

    final String[] disk = new String[128];

    public long usedSquares(final String key) {

        long used = 0;

        for (int i = 0; i < 128; i++) {
            final Day10 day10 = new Day10(256);
            final String keyValue = key + "-" + i;
            final String knotHash = day10.knotHash(keyValue);
            final String binaryString = String.format("%" + knotHash.length()*4 + "s", new BigInteger(knotHash, 16).toString(2)).replace(' ', '0');
            disk[i] = binaryString;
            final long ones = binaryString.chars().filter(ch -> ch == '1').count();
//            System.out.println(keyValue);
//            System.out.println(knotHash);
//            System.out.println(binaryString);
            used += ones;
        }

        return used;
    }

    public int regions(final String key) {
        int regions = 0;
        usedSquares(key);

        for (int x = 0; x < 128; x++) {
            for (int y = 0; y < 128; y++) {
                if(fill(x,y)) {
                    regions++;
                }
            }
        }
        return regions;
    }

    private boolean fill(final int x, final int y) {
        if (x < 0 || x > 127 || y < 0 || y > 127 || disk[y].charAt(x) != '1') {
            return false;
        }
        final StringBuilder sb = new StringBuilder(disk[y]);
        sb.setCharAt(x, 'x');
        disk[y] = sb.toString();
        fill(x-1, y);
        fill(x+1, y);
        fill(x, y-1);
        fill(x, y+1);
        return true;
    }
}
