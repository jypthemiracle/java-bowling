package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.pin.Pins;

public interface Frame {

	Optional<Frame> getNext();

	int getFrameNumber();

	void bowl(Pins pins);

	boolean isTurnOver();
}
