package bowling.domain.state;

import bowling.domain.pin.Pins;

public class FirstBowl implements State {

	private final Pins first;

	FirstBowl(Pins first) {
		this.first = first;
	}

	public static FirstBowl of(Pins first) {
		return new FirstBowl(first);
	}

	@Override
	public State roll(final Pins second) {
		Pins knockedOverPins = first.add(second);
		if (knockedOverPins.isKnockedDownAll()) {
			return Spare.of(first);
		}
		if (first.isAllStanding() || second.isAllStanding()) {
			return Gutter.of(first, second);
		}
		return Miss.ofPins(first, second);
	}

	@Override
	public boolean isTurnOver() {
		return false;
	}
}
