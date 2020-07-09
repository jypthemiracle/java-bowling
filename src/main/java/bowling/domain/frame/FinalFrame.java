package bowling.domain.frame;

import java.util.Optional;

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
		return 0;
	}
}
