package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.pin.Pins;
import bowling.domain.state.Ready;
import bowling.domain.state.State;

public class NormalFrame implements Frame {

	private final FrameNumber frameNumber;
	private final Frame nextFrame;
	private State state;

	private NormalFrame(final FrameNumber frameNumber) {
		this.frameNumber = frameNumber;
		this.nextFrame = createNextFrame();
		this.state = new Ready();
	}

	public static NormalFrame of(final FrameNumber frameNumber) {
		return new NormalFrame(frameNumber);
	}

	private Frame createNextFrame() {
		final FrameNumber nextFrameNumber = frameNumber.increaseByOneNumber();
		if (nextFrameNumber.isFinal()) {
			return FinalFrame.of(nextFrameNumber);
		}
		return new NormalFrame(nextFrameNumber);
	}

	@Override
	public Optional<Frame> getNext() {
		return Optional.of(nextFrame);
	}

	@Override
	public int getFrameNumber() {
		return frameNumber.getNumber();
	}

	@Override
	public void bowl(final Pins pins) {
		state = state.roll(pins);
	}

	@Override
	public boolean isTurnOver() {
		return state.isTurnOver();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
