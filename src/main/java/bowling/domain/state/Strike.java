package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Strike implements State {

	public static final String EXPRESSION = "X";

	public static Strike of() {
		return new Strike();
	}

	@Override
	public State roll(final Pins pins) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return EXPRESSION;
	}
}
