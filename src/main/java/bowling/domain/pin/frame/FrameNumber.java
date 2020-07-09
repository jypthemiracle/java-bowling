package bowling.domain.pin.frame;

public class FrameNumber {

	private final int number;

	private FrameNumber(int number) {
		this.number = number;
	}

	public static FrameNumber of(int number) {
		return new FrameNumber(number);
	}

	public int getNumber() {
		return number;
	}
}
