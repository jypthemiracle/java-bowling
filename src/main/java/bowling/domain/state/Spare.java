package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Spare implements State {

	public static final String EXPRESSION = "/";
	private final Pins first;

	private Spare(Pins first) {
		this.first = first;
	}

	public static Spare of(Pins pins) {
		return new Spare(pins);
	}

	@Override
	public State roll(Pins knockedPins) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return first.getKnockedPinCounts() + State.DELIMITER + EXPRESSION;
	}
}
