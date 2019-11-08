package king.greg.advent_2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day6 {

	public static int rebalancer(Integer[] banks) {
		int rebalances = 0;
		
		final List<Integer[]> states = new ArrayList<Integer[]>();
		states.add(Arrays.copyOf(banks, banks.length));
		
		while(true) {
			int rebalanceLocation = Arrays.asList(banks).indexOf(Collections.max(Arrays.asList(banks)));
			int blocks = banks[rebalanceLocation];
			banks[rebalanceLocation] = 0;
			while (blocks > 0) {
				rebalanceLocation++;
				if (rebalanceLocation >= banks.length) {
					rebalanceLocation = 0;
				}
				banks[rebalanceLocation]++;
				blocks--;
			}
			rebalances++;
			for (Integer[] state: states) {
				if  (Arrays.equals(state, banks)) {
					return rebalances;
				}
			}
			states.add(Arrays.copyOf(banks, banks.length));
		}
	}
	
	public static int rebalancerLoopSize(Integer[] banks) {
		
		final List<Integer[]> states = new ArrayList<Integer[]>();
		states.add(Arrays.copyOf(banks, banks.length));
		
		while(true) {
			int rebalanceLocation = Arrays.asList(banks).indexOf(Collections.max(Arrays.asList(banks)));
			int blocks = banks[rebalanceLocation];
			banks[rebalanceLocation] = 0;
			while (blocks > 0) {
				rebalanceLocation++;
				if (rebalanceLocation >= banks.length) {
					rebalanceLocation = 0;
				}
				banks[rebalanceLocation]++;
				blocks--;
			}
			for (int i = 0; i < states.size(); i++) {
				if  (Arrays.equals(states.get(i), banks)) {
					return states.size() - i;
				}
			}
			states.add(Arrays.copyOf(banks, banks.length));
		}
	}
	
}
