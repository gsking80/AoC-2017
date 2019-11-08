package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day8 {

	Map<String,Integer> registers = new HashMap<String, Integer>();
	Integer maxRegisterAllTime = 0;
	
	public void execute(final FileReader fileReader) {
		
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
	
	private void process(final String command) {
		final String[] terms = command.split(" ");
		switch (terms[5]) {
		case ">":
			if (registers.getOrDefault(terms[4], 0) > Integer.valueOf(terms[6])) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		case "<":
			if (registers.getOrDefault(terms[4], 0) < Integer.valueOf(terms[6])) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		case ">=":
			if (registers.getOrDefault(terms[4], 0) >= Integer.valueOf(terms[6])) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		case "<=":
			if (registers.getOrDefault(terms[4], 0) <= Integer.valueOf(terms[6])) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		case "==":
			if (registers.getOrDefault(terms[4], 0).equals(Integer.valueOf(terms[6]))) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		case "!=":
			if (!(registers.getOrDefault(terms[4], 0).equals(Integer.valueOf(terms[6])))) {
				compute(terms[0],terms[1],terms[2]);
			}
			break;
		default:
			throw new RuntimeException(command);
		}
	}
	
	private void compute(final String register, final String command, final String value) {
		Integer newValue = registers.getOrDefault(register, 0);
		switch(command) {
		case "inc":
			newValue += Integer.valueOf(value);
			break;
		case "dec":
			newValue -= Integer.valueOf(value);
			break;
		default:
			throw new RuntimeException(register + command + value);
		}
		registers.put(register, newValue);
		if(newValue > maxRegisterAllTime) {
			maxRegisterAllTime = newValue;
		}
	}
	
	public Integer maxRegisterValue() {
		return registers.size() > 0 ? Collections.max(registers.values()) : null;
	}
	
	public Integer maxRegisterAllTime() {
		return maxRegisterAllTime;
	}
	
}
