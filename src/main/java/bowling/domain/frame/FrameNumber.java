package bowling.domain.frame;

import bowling.exception.FrameNumberOutOfRangeException;

public class FrameNumber {

	private static final int MIN_RANGE = 1;
	private static final int MAX_RANGE = 10;
	private final int number;

	private FrameNumber(int number) {
		this.number = number;
	}

	public static FrameNumber of(int number) {
		validRange(number);
		return new FrameNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public static void validRange(final int number) {
		if (number < MIN_RANGE || number > MAX_RANGE) {
			throw new FrameNumberOutOfRangeException();
		}
	}

	public FrameNumber increaseByOneNumber() {
		return new FrameNumber(number + MIN_RANGE);
	}

	public boolean isFinal() {
		return number == MAX_RANGE;
	}
}
