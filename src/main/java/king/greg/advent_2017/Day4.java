package king.greg.advent_2017;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day4 {

	public static boolean validPassphrase(final String passphrase) {
		
		final String[] phraseWords = passphrase.split(" ");
		
		final Set<String> wordSet = new HashSet<String>();
		for (final String word : phraseWords) {
			wordSet.add(word);
		}
		
		return wordSet.size() == phraseWords.length;

	}
	
	public static boolean validAnagramPassphrase(final String passphrase) {
		
		final String[] phraseWords = passphrase.split(" ");
		
		for (int i = 0; i < phraseWords.length; i++) {
			 for (int j = i + 1; j < phraseWords.length; j++) {
			 here:
				if (j > phraseWords.length) {
					continue;
				} else if (phraseWords[i].length() != phraseWords[j].length()) {
					continue;
				} else {
					final Map<Character, Integer> charMap = new HashMap<Character, Integer>();
					for (int x = 0; x < phraseWords[i].length(); x++) {
						if (charMap.containsKey(phraseWords[i].charAt(x))) {
							charMap.put(phraseWords[i].charAt(x), charMap.get(phraseWords[i].charAt(x)) + 1);
						} else {
							charMap.put(phraseWords[i].charAt(x), 1);
						}
						if (charMap.containsKey(phraseWords[j].charAt(x))) {
							charMap.put(phraseWords[j].charAt(x), charMap.get(phraseWords[j].charAt(x)) - 1);
						} else {
							charMap.put(phraseWords[j].charAt(x), -1);
						}
					}
					for (final Integer count: charMap.values()) {
						if (!count.equals(0)) {
							break here;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
}
