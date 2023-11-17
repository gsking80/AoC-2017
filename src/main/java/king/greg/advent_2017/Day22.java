package king.greg.advent_2017;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day22 {

    Map<Point,Integer> grid;
    Point node;
    int direction;

    public Day22(FileReader fileReader) {
        try {
            final BufferedReader buf = new BufferedReader(fileReader);
            grid = new HashMap<>();

            int y = 0;

            while(true) {
                final String lineJustFetched = buf.readLine();
                if(null == lineJustFetched) {
                    break;
                } else {
                    for (int x = 0; x < lineJustFetched.length(); x++) {
                        grid.put(new Point(x,y), lineJustFetched.charAt(x) == '#' ? 2 : 0);
                    }
                    y++;
                }
            }
            node = new Point(y/2, y/2);
            direction = 0;
        } catch (IOException ioe) {
            throw new RuntimeException();
        }
    }

    public int bursts(final int bursts) {
        return bursts(bursts, false);
    }

    public int bursts(final int bursts, final boolean weaken) {
        int infections = 0;

        for (int i = 0; i < bursts; i++) {
            int currentInfected = grid.getOrDefault(node, 0);
            switch(currentInfected) {
                case 0:  // clean
                    direction = (direction + 3) % 4;  //turn left
                    currentInfected++;
                    if (weaken) {
                        break;
                    }
                case 1:  // weakened
                    currentInfected++;
                    infections++;
                    break;
                case 2:  // infected
                    direction = (direction + 1) % 4;  //turn right
                    currentInfected++;
                    if (!weaken) {
                        currentInfected++;
                    }
                    break;
                case 3:  // flagged
                    direction = (direction + 2) % 4;  //reverse
                    currentInfected++;
                    break;
            }

            currentInfected %= 4;
            grid.put(new Point(node.x, node.y), currentInfected); //swap

            switch (direction) {
                case 0:
                    node.y -= 1;
                    break;
                case 1:
                    node.x += 1;
                    break;
                case 2:
                    node.y += 1;
                    break;
                case 3:
                    node.x -= 1;
                    break;
                default:
                    throw new RuntimeException(direction + " " + i);
            }
        }

        return infections;
    }
}
