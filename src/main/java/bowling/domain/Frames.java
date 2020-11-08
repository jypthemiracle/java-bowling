package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Frames {
	private static final int MAX_FRAME_COUNT = 10;
	private final List<Frame> frames;

	public Frames() {
		this.frames = new ArrayList<>();
	}

	public void pitch(int count) {
		if (isEnd()) {
			throw new IllegalArgumentException("이미 프레임이 끝났어요.");
		}
		Frame frame = findFrame();
		frame.pitch(count);
	}

	private Frame findFrame() {
		if (frames.isEmpty()) {
			NormalFrame frame = NormalFrame.firstFrame();
			frames.add(frame);
			return frame;
		}
		if (getLastFrame().isEnd()) {
			Frame frame = frames.size() == MAX_FRAME_COUNT - 1
				? new FinalFrame()
				: getLastFrame().next();
			frames.add(frame);
			return frame;
		}
		return getLastFrame();
	}

	private boolean isFinalFrame() {
		return frames.size() == MAX_FRAME_COUNT;
	}

	boolean isEnd() {
		return isFinalFrame() && getLastFrame().isEnd();
	}

	private Frame getLastFrame() {
		if (frames.isEmpty()) {
			throw new IllegalArgumentException("프레임이 비어있습니다.");
		}
		return frames.get(frames.size() - 1);
	}

	public int getIndex() {
		if (frames.isEmpty() || getLastFrame().isEnd()) {
			return frames.size() + 1;
		}
		return frames.size();
	}

	public List<Frame> getFrames() {
		return Collections.unmodifiableList(frames);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Frames frames1 = (Frames)o;
		return Objects.equals(frames, frames1.frames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(frames);
	}
}
