package bowling.domain.frame;

import java.util.Optional;

public class NormalFrame implements Frame {

	private final FrameNumber frameNumber;
	private final Frame nextFrame;

	private NormalFrame(final FrameNumber frameNumber) {
		this.frameNumber = frameNumber;
		this.nextFrame = createNextFrame();
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
}
