package bowling.domain.bowl;

import bowling.domain.frame.FrameStatus;
import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;

public interface Bowl {

	Bowl bowl(BowlCount bowlCount);

	Pins getPins();

	FrameStatus getFrameStatus();
}
