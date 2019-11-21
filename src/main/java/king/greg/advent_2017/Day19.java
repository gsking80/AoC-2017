package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day19 {

    List<char[]> network = new ArrayList<char[]>();
    int steps = 0;

    public Day19(FileReader fileReader) {
        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    network.add(lineJustFetched.toCharArray());
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException();
        }
    }

    public String traverse() {
        final StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        int direction = 0;
        steps = 0;
        while (x < network.get(y).length) {
            if (network.get(y)[x] == ' ') {
                x++;
            } else {
                break;
            }
        }
        while (direction >= 0) {
            char current = network.get(y)[x];
            if (current >= 'A' && current <= 'Z') {
                sb.append(current);
            }
            steps++;
            switch (direction) {
                case 0:
                    if ((y+1 < network.size()) && network.get(y+1)[x] != ' ') {
                        y++;
                        continue;
                    }
                    break;
                case 1:
                    if ((x > 0) && network.get(y)[x-1] != ' ') {
                        x--;
                        continue;
                    }
                    break;
                case 2:
                    if ((y > 0) && network.get(y-1)[x] != ' ') {
                        y--;
                        continue;
                    }
                    break;
                case 3:
                    if ((x+1 < network.get(y).length) && network.get(y)[x+1] != ' ') {
                        x++;
                        continue;
                    }
                    break;
            }
            //Change directions
            if (direction % 2 == 0) { // currently E/W
                if ((x > 0) && network.get(y)[x-1] != ' ') {
                    x--;
                    direction = 1;
                } else if ((x+1 < network.get(y).length) && network.get(y)[x+1] != ' ') {
                    x++;
                    direction = 3;
                } else {
                    direction = -1;
                }
            } else { // currently N/S
                if ((y > 0) && network.get(y-1)[x] != ' ') {
                    y--;
                    direction = 2;
                } else if ((y+1 < network.size()) && network.get(y+1)[x] != ' ') {
                    y++;
                    direction = 0;
                } else {
                    direction = -1;
                }
            }
        }
        return sb.toString();
    }

    public int getSteps(){
        return steps;
    }
}
