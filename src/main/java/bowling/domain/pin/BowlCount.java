package bowling.domain.pin;

import bowling.exception.PlayCountOutOfRangeException;

public class BowlCount {

	private static final int MIN_COUNT = 0;
	private static final int MAX_COUNT = 10;
	private final int count;

	private BowlCount(final int count) {
		this.count = count;
	}

	public static BowlCount of(final int count) {
		validRange(count);
		return new BowlCount(count);
	}

	public static void validRange(final int count) {
		if (count < MIN_COUNT || count > MAX_COUNT) {
			throw new PlayCountOutOfRangeException();
		}
	}

	public int getCount() {
		return count;
	}

	public boolean isGreaterThan(int knockedPinCounts) {
		return count > knockedPinCounts;
	}
}
