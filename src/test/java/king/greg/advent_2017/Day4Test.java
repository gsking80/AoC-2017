package king.greg.advent_2017;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Day4Test {

	@Test
	public void test1() {
		assertThat(Day4.validPassphrase("aa bb cc dd ee")).isTrue();
	}
	
	@Test
	public void test2() {
		assertThat(Day4.validPassphrase("aa bb cc dd aa")).isFalse();
	}
	
	@Test
	public void test3() {
		assertThat(Day4.validPassphrase("a bb cc dd aaa")).isTrue();
	}
	
	@Test
	public void testSolution() throws IOException {

		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day4/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		
		int validPhrases = 0;
		
		while(true) {
			final String lineJustFetched = buf.readLine();
			if(null == lineJustFetched) {
				break;
			} else {
				if (Day4.validPassphrase(lineJustFetched)) {
					validPhrases++;
				}
			}
		}
		
		buf.close();
		
		assertThat(validPhrases).isEqualTo(386);
	}
	
	@Test
	public void testAnagram1() {
		assertThat(Day4.validAnagramPassphrase("abcde fghij")).isTrue();
	}
	
	@Test
	public void testAnagram2() {
		assertThat(Day4.validAnagramPassphrase("abcde xyz ecdab")).isFalse();
	}
	
	@Test
	public void testAnagram3() {
		assertThat(Day4.validAnagramPassphrase("a ab abc abd abf abj")).isTrue();
	}
	
	@Test
	public void testAnagram4() {
		assertThat(Day4.validAnagramPassphrase("iiii oiii ooii oooi oooo")).isTrue();
	}
	
	@Test
	public void testAnagram5() {
		assertThat(Day4.validAnagramPassphrase("oiii ioii iioi iiio")).isFalse();
	}
	
	@Test
	public void testAnagram6() {
		assertThat(Day4.validAnagramPassphrase("abcde bcdef abdce")).isFalse();
	}
	
	@Test
	public void testAnagramSolution() throws IOException {

		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day4/input.txt").getPath());
		final BufferedReader buf = new BufferedReader(fileReader);
		
		int validPhrases = 0;
		
		while(true) {
			final String lineJustFetched = buf.readLine();
			if(null == lineJustFetched) {
				break;
			} else {
				if (Day4.validAnagramPassphrase(lineJustFetched)) {
					validPhrases++;
				}
			}
		}
		
		buf.close();
		
		assertThat(validPhrases).isEqualTo(208);
	}

}
