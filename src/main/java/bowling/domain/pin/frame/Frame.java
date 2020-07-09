package bowling.domain.pin.frame;

public class Frame {

	private final FrameNumber frameNumber;

	private Frame(FrameNumber frameNumber) {
		this.frameNumber = frameNumber;
	}

	public static Frame of(int number) {
		FrameNumber frameNumber = FrameNumber.of(number);
		return new Frame(frameNumber);
	}

	public int getFrameNumber() {
		return frameNumber.getNumber();
	}
}
