package king.greg.advent_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day7 {
	
	public class Disc {
		int weight;
		String name;
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public List<String> getPrograms() {
			return programs;
		}
		public void setPrograms(List<String> programs) {
			this.programs = programs;
		}
		List<String> programs;
		
		public int calcTotalWeight() {
			int totalWeight = weight;
			List<Integer> weights = new ArrayList<Integer>();
			for (String program: programs) {
				weights.add(circus.get(program).calcTotalWeight());
			}
			boolean offWeight = false;
			System.out.print(name + " [" + weight + "] -- ");
			for (int i = 0; i < programs.size(); i++) {
				System.out.print (programs.get(i) + " (" + weights.get(i) + ") ");
				totalWeight += weights.get(i);
				if (!weights.get(i).equals(weights.get(0))) {
					offWeight = true;
				}
			}
			System.out.println("");
			if (offWeight) {
				System.out.println("THIS ONE!");
				throw new RuntimeException("Found it!");
			}
			return totalWeight;
		}
		
	}
	
	private Map<String,Disc> circus = new HashMap<String,Disc>();
	
	public void loadCircus(final FileReader fileReader) {
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			
			
			while(true) {
				final String lineJustFetched = buf.readLine();
				if(null == lineJustFetched) {
					break;
				} else {
					final String[] pieces = lineJustFetched.split(" ");
					final Disc disc = new Disc();
					disc.setWeight(Integer.valueOf(pieces[1].substring(1, pieces[1].length()-1)));
					disc.name = pieces[0];
					final List<String> subPrograms = new ArrayList<String>();
					for (int i = 3; i < pieces.length; i++) {
						subPrograms.add(pieces[i].replaceAll(",", ""));
					}
					disc.setPrograms(subPrograms);
					circus.put(pieces[0], disc);
				}
			}
		} catch (IOException ioe) {
			
		}
	}
	
	public String findBaseProgram() {
		final Set<String> programs = circus.keySet();
		final Set<String> childPrograms = new HashSet<String>();
		for (Disc disc: circus.values()) {
			childPrograms.addAll(disc.getPrograms());
		}
		programs.removeAll(childPrograms);
		return (String) programs.toArray()[0];
	}
	
	public String checkBalance(final String currentDisc ) {
		circus.get(currentDisc).calcTotalWeight();
		return "";
	}

}

