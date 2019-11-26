package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day23 {

    final List<String[]> program = new ArrayList<>();
    final Map<String,Long> registers = new HashMap<>();

    public Day23(FileReader fileReader) {

        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    program.add(lineJustFetched.split(" "));
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException();
        }

    }

    public long execute() {
        long mulCount = 0;

        registers.clear();

        int currentLine = 0;
        while(currentLine < program.size()) {
            final String[] programLine = program.get(currentLine);
            switch(programLine[0]) {
                case "set":
                    setRegister(programLine[1], programLine[2]);
                    break;
                case "sub":
                    subRegister(programLine[1], programLine[2]);
                    break;
                case "mul":
                    mulRegister(programLine[1], programLine[2]);
                    mulCount++;
                    break;
                case "jnz":
                    currentLine += jnz(programLine[1], programLine[2]);
                    break;
                default:
                    throw new RuntimeException(currentLine + " - " + Arrays.toString(programLine));
            }
            currentLine++;
        }

        return mulCount;
    }

    private void setRegister(final String register, final String value) {
        registers.put(register, valueOrRegister(value));
    }

    private void subRegister(final String register, final String value) {
        registers.put(register, valueOrRegister(register) - valueOrRegister(value));
    }

    private void mulRegister(final String register, final String value) {
        registers.put(register, valueOrRegister(register) * valueOrRegister(value));
    }

    private long jnz(final String valueX, final String valueY) {
        long offset = 0;
        if (valueOrRegister(valueX) != 0) {
            offset = valueOrRegister(valueY) - 1;
        }
        return offset;
    }

    private long valueOrRegister(final String input) {
        long value;
        try {
            value = Long.parseLong(input);
        } catch (final NumberFormatException nfe) {
            value = registers.getOrDefault(input, 0L);
        }
        return value;
    }

    public static int nonPrimes(int lower, int upper, int stepSize) {
        int nonPrimes = 0;

        for (int i = lower; i <= upper; i += stepSize) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    nonPrimes++;
                    break;
                }
            }
        }

        return nonPrimes;
    }
}
