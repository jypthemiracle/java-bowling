package bowling.domain.state;

import bowling.domain.pin.Pins;

public class Gutter implements State {

	private static final String EXPRESSION = "-";
	private final Pins first;
	private final Pins second;

	private Gutter(Pins first, Pins second) {
		this.first = first;
		this.second = second;
	}

	public static Gutter of(Pins first, Pins second) {
		return new Gutter(first, second);
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
