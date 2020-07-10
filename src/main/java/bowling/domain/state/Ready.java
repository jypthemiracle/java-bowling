package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Ready implements State {

	@Override
	public State roll(Pins knockedPins) {
		if (knockedPins.isKnockedDownAll()) {
			return Strike.of();
		}
		return Playing.of(knockedPins);
	}
}
