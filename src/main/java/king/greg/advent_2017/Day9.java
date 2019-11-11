package king.greg.advent_2017;

public class Day9 {

	String stream;
	int position = -1;
	int garbageCount = 0;

	public int scoreString(final String input) {
		stream = input;
		return scoreGroup(0);
	}

	private int scoreGroup(final int depth) {
		int score = depth;
		boolean garbage = false;
		while (position < stream.length() - 1) {
			position++;
			if (garbage) {
				switch (stream.charAt(position)) {
				case '!':
					position++;
					break;
				case '>':
					garbage = false;
					break;
				default:
					garbageCount++;
				}
			} else {
				switch (stream.charAt(position)) {
				case '{':
					score += scoreGroup(depth + 1);
					break;
				case '}':
					return score;
				case '<':
					garbage = true;
					break;
				}
			}
		}
		return score;
	}

	public int garbageCount(final String input) {
		stream = input;
		scoreGroup(0);
		return garbageCount;
	}

}
