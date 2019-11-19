package king.greg.advent_2017;

import java.util.LinkedList;

public class Day17 {

    final LinkedList<Integer> spinlock = new LinkedList<>();

    public Day17(final int steps, final int values) {
        int index = 0;
        spinlock.add(0);
        for (int i = 1; i <= values; i++) {
            index = index + (steps % spinlock.size());
            if (index >= spinlock.size()) {
                index -= spinlock.size();
            }
            index++;
            spinlock.add(index, i);

        }

    }

    public int valueAfter(int value) {
        int index = spinlock.indexOf(value);
        int newIndex = (index + 1) < spinlock.size() ? index + 1 : 0;
        return spinlock.get(newIndex);
    }

    public static int valueAtIndex(final int steps, final int values, final int testIndex) {
        int index = 0;
        int size = 1;
        int value = -1;
        for (int i = 1; i <= values; i++) {
            index = index + (steps % size);
            if (index >= size) {
                index -= size;
            }
            index++;
            if (index == testIndex) {
                value = i;
            }
            size++;

        }
        return value;
    }
}
