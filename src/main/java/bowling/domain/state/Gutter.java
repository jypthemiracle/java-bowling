package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Gutter implements State {

	private static final String EXPRESSION = "-";

	private Gutter() {
	}

	public static Gutter of() {
		return new Gutter();
	}

	@Override
	public State roll(Pins knockedPins) {
		return null;
	}

	@Override
	public String toString() {
		return EXPRESSION;
	}
}
