package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day12 {

    final Map<String, Set<String>> programMap = new HashMap<>();
    final Set<String> programs = new HashSet<>();

    public Day12(final FileReader fileReader) {

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

    private void process(final String programDetails) {
        final String[] program = programDetails.split(" <-> ");
        final Set<String> programGroups = new HashSet<>(Arrays.asList(program[1].split(", ")));
        programMap.put(program[0], programGroups);
    }

    public int programCount(String program) {
        programs.clear();
        programs.add(program);
        evaluatePrograms(programMap.get(program));

        return programs.size();
    }

    private void evaluatePrograms(final Set<String> programsToEvaluate) {
        for (final String program : programsToEvaluate) {
            if (programs.contains(program)) {
                // do nothing
            } else {
                programs.add(program);
                evaluatePrograms(programMap.get(program));
            }
        }
    }

    public int totalGroups() {
        int groupCount = 0;
        final Set<String> evaluatedPrograms = new HashSet<>();
        final Set<String> programsToEvaluate = programMap.keySet();
        for (final String program : programsToEvaluate) {
            if (evaluatedPrograms.contains(program)) {
                // do nothing
            } else {
                programCount(program);
                evaluatedPrograms.addAll(programs);
                groupCount++;
            }
        }
        return groupCount;
    }
}
