package bowling.domain.bowl;

import bowling.domain.frame.FrameStatus;
import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;

public class SecondBowl implements Bowl {

	private final Pins pins;
	private FrameStatus frameStatus;

	private SecondBowl(Pins pins, FrameStatus frameStatus) {
		this.pins = pins;
		this.frameStatus = frameStatus;
	}

	public static SecondBowl of(Bowl bowl) {
		return new SecondBowl(bowl.getPins(), bowl.getFrameStatus());
	}

	@Override
	public Bowl bowl(BowlCount bowlCount) {
		pins.knockPins(bowlCount);
		if (pins.isKnockedDownAll()) {
			this.frameStatus = FrameStatus.SPARE;
			return this;
		}
		if (pins.isAllStanding()) {
			this.frameStatus = FrameStatus.GUTTER;
			return this;
		}
		this.frameStatus = FrameStatus.MISS;
		return this;
	}

	@Override
	public Pins getPins() {
		return pins;
	}

	@Override
	public FrameStatus getFrameStatus() {
		return frameStatus;
	}
}
