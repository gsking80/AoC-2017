package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day2 {
	
	public static int checksum(final FileReader fileReader) {
		int checksum = 0;
		
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			
			
			while(true) {
				final String lineJustFetched = buf.readLine();
				if(null == lineJustFetched) {
					break;
				} else {
					final String[] numbersArray = lineJustFetched.split("\t");
					final ArrayList<Integer> numbers = new ArrayList<Integer>();
					for (String numberString : numbersArray) {
						numbers.add(Integer.valueOf(numberString));
					}
					checksum += (Collections.max(numbers) - Collections.min(numbers));
				}
			}
		} catch (IOException ioe) {
			
		}
		
		return checksum;
	}
	
	public static int checksumDivisor(final FileReader fileReader) {
		int checksum = 0;
		
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			
			
			while(true) {
				final String lineJustFetched = buf.readLine();
				if(null == lineJustFetched) {
					break;
				} else {
					System.out.println(lineJustFetched);
					final String[] numbersArray = lineJustFetched.split("\t");
					here: for (int i = 0; i < numbersArray.length; i++) {
						for (int j = 0; j < numbersArray.length; j++) {
							if (i == j) {
								continue;
							} else if (Integer.valueOf(numbersArray[i]) >= Integer.valueOf(numbersArray[j])) {
								if ((Integer.valueOf(numbersArray[i]) % Integer.valueOf(numbersArray[j])) == 0) {
									System.out.println(i + " " + j);
									checksum += (Integer.valueOf(numbersArray[i])/Integer.valueOf(numbersArray[j]));
									break here;
								}
							} else {
								if ((Integer.valueOf(numbersArray[j]) % Integer.valueOf(numbersArray[i])) == 0) {
									System.out.println(i + " " + j);
									checksum += (Integer.valueOf(numbersArray[j])/Integer.valueOf(numbersArray[i]));
									break here;
								}
							}
						}
						
					}
					
				}
				System.out.println(checksum);
			}
		} catch (IOException ioe) {
			
		}
		
		return checksum;
	}

}
