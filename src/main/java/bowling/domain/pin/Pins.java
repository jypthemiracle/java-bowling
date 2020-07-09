package bowling.domain.pin;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pins {

	public static final int PIN_LIST_SIZE = 10;
	private final List<Pin> pins;

	private Pins(final List<Pin> pinList) {
		this.pins = Collections.unmodifiableList(pinList);
	}

	public static Pins of(final PinGenerator pinGenerator) {
		return new Pins(createPinList(pinGenerator));
	}

	public static List<Pin> createPinList(final PinGenerator pinGenerator) {
		return IntStream.range(0, PIN_LIST_SIZE)
			.mapToObj(index -> PinFactory.create(pinGenerator))
			.collect(Collectors.toList());
	}

	public List<Pin> getPins() {
		return pins;
	}
}
