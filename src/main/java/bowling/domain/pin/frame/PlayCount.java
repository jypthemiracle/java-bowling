package bowling.domain.pin.frame;

import bowling.exception.PlayCountOutOfRangeException;

public class PlayCount {

	private static final int MIN_COUNT = 0;
	private static final int MAX_COUNT = 10;
	private final int count;

	private PlayCount(final int count) {
		this.count = count;
	}

	public static PlayCount of(final int count) {
		validRange(count);
		return new PlayCount(count);
	}

	public static void validRange(final int count) {
		if (count < MIN_COUNT || count > MAX_COUNT) {
			throw new PlayCountOutOfRangeException();
		}
	}

	public int getCount() {
		return count;
	}
}
