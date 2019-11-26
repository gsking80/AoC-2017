package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day24 {

    final List<List<Integer>> dominoes = new ArrayList<>();
    int longestBridge = 0;
    int strongestBridge = 0;

    public Day24(FileReader fileReader) {

        try {
            final BufferedReader buf = new BufferedReader(fileReader);

            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    final String[] dominoBits = lineJustFetched.split("/");
                    final List<Integer> domino = new ArrayList<>();
                    domino.add(Integer.valueOf(dominoBits[0]));
                    domino.add(Integer.valueOf(dominoBits[1]));
                    dominoes.add(domino);
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException();
        }

    }

    public int strongestBridge(final int startingValue) {
        int strongestValue = 0;

        strongestValue = buildStrongestBridge(startingValue, dominoes);

        return strongestValue;
    }

    public int longestBridge(final int startingValue) {

        buildLongestBridge(startingValue, dominoes, 0, 0);

        return strongestBridge;
    }

    private void buildLongestBridge(final int currentValue, final List<List<Integer>> remainingDominoes, final int currentLength, final int currentStrength) {

        final List<List<Integer>> leftoverDominoes = new ArrayList<>();
        leftoverDominoes.addAll(remainingDominoes);

        for (final List<Integer> domino : remainingDominoes) {
            if (domino.contains(currentValue)) {
//                System.out.println("+ " + Arrays.toString(domino.toArray()));
                leftoverDominoes.remove(domino);
                int dominoStrength = 0;
                int nextValue = currentValue;
                for(final Integer value: domino) {
                    if (value != currentValue) {
                        nextValue = value;
                    }
                    dominoStrength += value;
                }
                buildLongestBridge(nextValue, leftoverDominoes, currentLength + 1, currentStrength + dominoStrength);
                leftoverDominoes.add(domino);
//                System.out.println("- " + Arrays.toString(domino.toArray()));
            }
        }

        if (currentLength > longestBridge) {
            longestBridge = currentLength;
            strongestBridge = currentStrength;
        } else if (currentLength == longestBridge && currentStrength > strongestBridge) {
            strongestBridge = currentStrength;
        }

    }

    private int buildStrongestBridge(final int currentValue, final List<List<Integer>> remainingDominoes) {
        int strongestBridge = 0;

        final List<List<Integer>> leftoverDominoes = new ArrayList<>();
        leftoverDominoes.addAll(remainingDominoes);

        for (final List<Integer> domino : remainingDominoes) {
            if (domino.contains(currentValue)) {
//                System.out.println("+ " + Arrays.toString(domino.toArray()));
                leftoverDominoes.remove(domino);
                int possibleStrongest = 0;
                int nextValue = currentValue;
                for(final Integer value: domino) {
                    if (value != currentValue) {
                        nextValue = value;
                    }
                    possibleStrongest += value;
                }
                possibleStrongest += buildStrongestBridge(nextValue, leftoverDominoes);
                if (possibleStrongest > strongestBridge) {
                    strongestBridge = possibleStrongest;
                }
                leftoverDominoes.add(domino);
//                System.out.println("- " + Arrays.toString(domino.toArray()));
            }
        }


        return strongestBridge;
    }
}
