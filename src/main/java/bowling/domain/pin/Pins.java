package bowling.domain.pin;

import java.util.Collections;
import java.util.List;

public class Pins {

	public static final int PIN_LIST_SIZE = 10;
	private final List<Pin> pins;

	Pins(final List<Pin> pinList) {
		this.pins = Collections.unmodifiableList(pinList);
	}

	public List<Pin> getPins() {
		return pins;
	}
}
