package bowling.domain.state;

import bowling.domain.pin.Pins;

public interface State {

	String DELIMITER = "|";

	State roll(final Pins knockedPins);

	String toString();
}
