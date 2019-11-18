package king.greg.advent_2017;

import java.util.*;
import java.util.regex.Pattern;

public class Day16 {

    LinkedList<Character> programs = new LinkedList<>();

    Day16(final String start) {
        for (int i = 0; i < start.length(); i++) {
            programs.add(start.charAt(i));
        }
    }

    public String dance(final String dance) {
        return dance(dance, 1);
    }

    public String dance(final String dance, final long times) {
        final String[] moves = dance.split(",");
        final List<String> seen = new ArrayList<>();
        for (long j = 0; j < times; j++) {
            for (final String move : moves) {
                switch (move.charAt(0)) {
                    case 's':
                        final int spin = Integer.valueOf(move.substring(1)) % programs.size();
                        for (int i = 0; i < spin; i++) {
                            programs.addFirst(programs.pollLast());
                        }
                        break;
                    case 'x':
                        final int[] exchange = Pattern.compile("/").splitAsStream(move.substring(1)).mapToInt(Integer::valueOf).toArray();
                        swap(exchange[0], exchange[1]);
                        break;
                    case 'p':
                        final int partner1loc = programs.indexOf(move.charAt(1));
                        final int partner2loc = programs.indexOf(move.charAt(3));
                        swap(partner1loc, partner2loc);
                        break;
                    default:
                        throw new RuntimeException(move);
                }
//            System.out.println(Arrays.toString(programs.toArray()));
            }
            final StringBuilder sb = new StringBuilder();
            for (final Character program : programs) {
                sb.append(program);
            }
            final String danced = sb.toString();
            if (seen.contains(danced)) {
                return seen.get((int)(times % j) - 1);
            } else {
                seen.add(danced);
            }
        }
        return seen.get(seen.size() - 1);
    }

    private void swap(final int a, final int b) {
        final Character temp = programs.get(a);
        programs.set(a, programs.get(b));
        programs.set(b, temp);
    }

}
