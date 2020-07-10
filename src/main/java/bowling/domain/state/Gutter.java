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
		if (isFirstOnlyGutter()) {
			return EXPRESSION + State.DELIMITER + second.getKnockedPinCounts();
		}
		if (isSecondOnlyGutter()) {
			return first.getKnockedPinCounts() + State.DELIMITER + EXPRESSION;
		}
		if (isAllGutter()) {
			return EXPRESSION + State.DELIMITER + EXPRESSION;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isTurnOver() {
		return true;
	}

	private boolean isFirstOnlyGutter() {
		return first.isGutter() && !second.isGutter();
	}

	private boolean isSecondOnlyGutter() {
		return !first.isGutter() && second.isGutter();
	}

	private boolean isAllGutter() {
		return first.isGutter() && second.isGutter();
	}
}
