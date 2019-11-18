package king.greg.advent_2017;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Day10 {

	int[] circle;
	int[] lengths;
	int[] denseHash = new int[16];
	
	public Day10(final int size) {
		circle = new int[size];
		for (int i = 0; i < size; i++) {
			circle[i] = i;
		}
	}
	
	public void sparseHash(final int times) {
		int position = 0;
		int skipSize = 0;

		for (int run = 0; run < times; run++) {
			for (final int length : lengths) {
//				System.out.println(length);
				for (int j = 0; j < length / 2; j++) {
//					System.out.println(circle[(position + j) % circle.length] + " - " + circle[(position + (length - 1) - j) % circle.length]);
					int temp = circle[(position + j) % circle.length];
					circle[(position + j) % circle.length] = circle[(position + (length - 1) - j) % circle.length];
					circle[(position + (length - 1) - j) % circle.length] = temp;
				}
				position = (position + length + skipSize) % circle.length;
				skipSize++;
//				System.out.println(Arrays.toString(circle) + ", position = " + position);
			}
		}
	}
	
	public int firstProduct() {
		return circle[0]*circle[1];
	}

	public void hashString(String input) {
		lengths = Pattern.compile(",").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
	}

	public void hashBytes(String input) {
		final String suffixedInput = input + (char)17 + (char)31 + (char)73 + (char)47 + (char)23;
		lengths = suffixedInput.chars().toArray();
	}

	public void denseHash() {
		for (int i = 0; i < 16; i++) {
			int offset = i * 16;
			denseHash[i] = circle[offset] ^ circle[offset+1] ^ circle[offset+2] ^ circle[offset+3] ^ circle[offset+4] ^ circle[offset+5] ^ circle[offset+6] ^ circle[offset+7]
					^ circle[offset+8] ^ circle[offset+9] ^ circle[offset+10] ^ circle[offset+11] ^ circle[offset+12] ^ circle[offset+13] ^ circle[offset+14] ^ circle[offset+15];
		}
	}

	public String knotValue() {
		final StringBuilder builder = new StringBuilder();
		for(final int value: denseHash) {
			builder.append(String.format("%02x", value));
		}
		return builder.toString();
	}

	public String knotHash(final String input) {
		hashBytes(input);
		sparseHash(64);
		denseHash();
		return knotValue();
	}
}
