package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Miss implements State {

	private final Pins first;
	private final Pins second;

	private Miss(Pins first, Pins second) {
		this.first = first;
		this.second = second;
	}

	public static Miss ofPins(Pins first, Pins second) {
		return new Miss(first, second);
	}

	@Override
	public State roll(Pins knockedPins) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return String.valueOf(first.getKnockedPinCounts() + second.getKnockedPinCounts());
	}
}
