package king.greg.advent_2017;

import java.util.HashMap;
import java.util.Map;

public class Day25 {

    final Map<Long,Integer> tape = new HashMap<>();
    char state;
    char nextState;
    long position;

    public long checksumAfter(final char startState, final long steps) {
        state = startState;
        position = 0;
        for (long i = 0; i < steps; i++) {
            switch(state) {
                case 'A':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position++;
                        nextState = 'B';
                    } else {
                        tape.put(position, 1);
                        position--;
                        nextState = 'E';
                    }
                    break;
                case 'B':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position++;
                        nextState = 'C';
                    } else {
                        tape.put(position, 1);
                        position++;
                        nextState = 'F';
                    }
                    break;
                case 'C':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position--;
                        nextState = 'D';
                    } else {
                        tape.put(position, 0);
                        position++;
                        nextState = 'B';
                    }
                    break;
                case 'D':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position++;
                        nextState = 'E';
                    } else {
                        tape.put(position, 0);
                        position--;
                        nextState = 'C';
                    }
                    break;
                case 'E':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position--;
                        nextState = 'A';
                    } else {
                        tape.put(position, 0);
                        position++;
                        nextState = 'D';
                    }
                    break;
                case 'F':
                    if (getValue(position).equals(0)) {
                        tape.put(position, 1);
                        position++;
                        nextState = 'A';
                    } else {
                        tape.put(position, 1);
                        position++;
                        nextState = 'C';
                    }
                    break;
            }
            state = nextState;
        }
        return tape.values().stream().filter(i -> i.equals(1)).count();
    }

    private Integer getValue(final Long position) {
        return tape.getOrDefault(position, 0);
    }
}
