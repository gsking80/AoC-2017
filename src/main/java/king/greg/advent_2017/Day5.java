package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

	public static int jumpCount(final FileReader fileReader) {
		
		final List<Integer> mazeList = new ArrayList<Integer>();
		
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			
			while(true) {
				final String lineJustFetched = buf.readLine();
				if(null == lineJustFetched) {
					break;
				} else {
					mazeList.add(Integer.valueOf(lineJustFetched));
				}
			}
		} catch (IOException ioe) {
			
		}
		
		final Integer[] maze = (Integer[]) mazeList.toArray(new Integer[0]);
		
		int jumps = 0;
		int position = 0;
		
		while (position < maze.length) {
			final int jump = maze[position];
			maze[position]++;
			jumps++;
			position += jump;
		}
		
		return jumps;
	}
	
	public static int jumpCount2(final FileReader fileReader) {
		
		final List<Integer> mazeList = new ArrayList<Integer>();
		
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			
			while(true) {
				final String lineJustFetched = buf.readLine();
				if(null == lineJustFetched) {
					break;
				} else {
					mazeList.add(Integer.valueOf(lineJustFetched));
				}
			}
		} catch (IOException ioe) {
			
		}
		
		final Integer[] maze = (Integer[]) mazeList.toArray(new Integer[0]);
		
		int jumps = 0;
		int position = 0;
		
		while (position < maze.length) {
			final int jump = maze[position];
			if (jump >= 3) {
				maze[position]--;
			} else {
				maze[position]++;
			}
			jumps++;
			position += jump;
		}
		
		return jumps;
	}
	
	
}
