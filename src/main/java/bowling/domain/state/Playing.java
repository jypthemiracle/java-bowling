package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Playing implements State {

	private final Pins first;
	private Pins second;

	private Playing(Pins first) {
		this.first = first;
	}

	public static Playing of(Pins knockedPins) {
		return new Playing(knockedPins);
	}

	@Override
	public State roll(Pins knockedPins) {
		this.second = knockedPins;
		if (second.isKnockedDownAll()) {
			return Spare.of(first);
		}
		if (second.isGutter()) {
			return Gutter.of(first, second);
		}
		return Miss.ofPins(first, second);
	}
}
