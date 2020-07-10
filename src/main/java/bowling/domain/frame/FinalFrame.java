package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.pin.Pins;

public class FinalFrame implements Frame {

	private final FrameNumber frameNumber;

	private FinalFrame(final FrameNumber frameNumber) {
		this.frameNumber = frameNumber;
	}

	public static FinalFrame of(final FrameNumber frameNumber) {
		return new FinalFrame(frameNumber);
	}

	@Override
	public Optional<Frame> getNext() {
		return Optional.empty();
	}

	@Override
	public int getFrameNumber() {
		return frameNumber.getNumber();
	}

	@Override
	public void bowl(Pins pins) {
		//
	}

	@Override
	public boolean isTurnOver() {
		return false;
	}
}
