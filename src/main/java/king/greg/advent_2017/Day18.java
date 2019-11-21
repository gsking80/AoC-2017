package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Day18 {

    final List<String[]> program = new ArrayList<>();

    final List<Map<String, Long>> registers = new ArrayList<Map<String, Long>>();
    final List<Queue<Long>> queues = new ArrayList<Queue<Long>>();

    boolean[] waiting = new boolean[2];

    Long currentTone;

    final List<Long> tones = new ArrayList<>();

    public Day18(FileReader fileReader) {

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

    private void execute() {
        registers.clear();
        registers.add(new HashMap<>());
        tones.clear();
        int currentLine = 0;
        while(currentLine < program.size()) {
            final String[] programLine = program.get(currentLine);
            switch(programLine[0]) {
                case "snd":
                    play(programLine[1]);
                    break;
                case "set":
                    setRegister(programLine[1], programLine[2], 0);
                    break;
                case "add":
                    addRegister(programLine[1], programLine[2], 0);
                    break;
                case "mul":
                    mulRegister(programLine[1], programLine[2], 0);
                    break;
                case "mod":
                    modRegister(programLine[1], programLine[2], 0);
                    break;
                case "rcv":
                    rcv(programLine[1]);
                    break;
                case "jgz":
                    currentLine += jgz(programLine[1], programLine[2], 0);
                    break;
                default:
                    throw new RuntimeException(currentLine + " - " + Arrays.toString(programLine));
            }
            if (tones.size() > 0) {
                break;
            }
            currentLine++;
        }
    }

    private void setRegister(final String register, final String value, final int program) {
        registers.get(program).put(register, valueOrRegister(value, program));
    }

    private void addRegister(final String register, final String value, final int program) {
        registers.get(program).put(register, registers.get(program).getOrDefault(register, 0L) + valueOrRegister(value, program));
    }

    private void mulRegister(final String register, final String value, final int program) {
        registers.get(program).put(register, registers.get(program).getOrDefault(register, 0L) * valueOrRegister(value, program));
    }

    private void modRegister(final String register, final String value, final int program) {
        registers.get(program).put(register, registers.get(program).getOrDefault(register, 0L) % valueOrRegister(value, program));
    }

    private long jgz(final String valueX, final String valueY, final int program) {
        long offset = 0;
        if (valueOrRegister(valueX, program) > 0) {
            offset = valueOrRegister(valueY, program) - 1;
        }
        return offset;
    }

    private void play(final String value) {
        currentTone = valueOrRegister(value,0);
    }

    private void send(String value, int sendingProgram) {
        queues.get((sendingProgram + 1) % 2).add(valueOrRegister(value, sendingProgram));
    }

    private void rcv(final String value) {
        if(valueOrRegister(value,0) != 0) {
            tones.add(currentTone);
        }
    }

    private void rcv(final String register, int receivingProgram) {
        if (queues.get(receivingProgram).size() > 0) {
            registers.get(receivingProgram).put(register, queues.get(receivingProgram).remove());
            waiting[receivingProgram] = false;
        } else {
            waiting[receivingProgram] = true;
        }
    }

    private long valueOrRegister(final String input, final int program) {
        long value;
        try {
            value = Long.parseLong(input);
        } catch (final NumberFormatException nfe) {
            value = registers.get(program).getOrDefault(input, 0L);
        }
        return value;
    }

    public long firstRecoveredFrequency() {
        execute();
        return tones.get(0);
    }

    public long programOneSends() {
        registers.clear();
        registers.add(new HashMap<>());
        registers.add(new HashMap<>());
        registers.get(0).put("p",0L);
        registers.get(1).put("p",1L);
        queues.clear();
        queues.add(new LinkedList<Long>());
        queues.add(new LinkedList<Long>());
        int[] sends = new int[2];
        int[] currentLine = new int[2];
        while(currentLine[0] < program.size() && currentLine[1] < program.size() && !(waiting[0] && waiting[1])) {
            for (int i = 0; i <= 1; i++) {
                final String[] programLine = program.get(currentLine[i]);
                switch (programLine[0]) {
                    case "snd":
                        send(programLine[1], i);
                        sends[i]++;
                        break;
                    case "set":
                        setRegister(programLine[1], programLine[2], i);
                        break;
                    case "add":
                        addRegister(programLine[1], programLine[2], i);
                        break;
                    case "mul":
                        mulRegister(programLine[1], programLine[2], i);
                        break;
                    case "mod":
                        modRegister(programLine[1], programLine[2], i);
                        break;
                    case "rcv":
                        rcv(programLine[1], i);
                        break;
                    case "jgz":
                        currentLine[i] += jgz(programLine[1], programLine[2], i);
                        break;
                    default:
                        throw new RuntimeException(currentLine + " - " + Arrays.toString(programLine));
                }
                if (!waiting[i]) {
                    currentLine[i]++;
                }
            }
        }
        return sends[1];
    }

}
