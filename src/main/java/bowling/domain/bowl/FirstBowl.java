package bowling.domain.bowl;

import bowling.domain.frame.FrameStatus;
import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;
import bowling.domain.pin.PinsGenerator;

public class FirstBowl implements Bowl {

	private final Pins pins;
	private FrameStatus frameStatus;

	private FirstBowl(final Pins pins, final FrameStatus frameStatus) {
		this.pins = pins;
		this.frameStatus = frameStatus;
	}

	public static FirstBowl of() {
		return new FirstBowl(new PinsGenerator().generate(), FrameStatus.PLAYING);
	}

	public FirstBowl bowl(BowlCount bowlCount) {
		pins.knockPins(bowlCount);
		if (pins.isKnockedDownAll()) {
			this.frameStatus = FrameStatus.STRIKE;
			return this;
		}
		this.frameStatus = FrameStatus.PLAYING;
		return this;
	}

	public FrameStatus getFrameStatus() {
		return frameStatus;
	}
}
