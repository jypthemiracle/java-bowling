package bowling.domain.pin;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import bowling.domain.pin.frame.BowlCount;

public class Pins {

	public static final int PIN_LIST_SIZE = 10;
	private List<Pin> pins;

	Pins(final List<Pin> pinList) {
		this.pins = Collections.unmodifiableList(pinList);
	}

	public List<Pin> getPins() {
		return pins;
	}

	public int knockedPinCounts() {
		return (int)pins.stream()
			.filter(Pin::isKnocked)
			.count();
	}

	public Pins knockPins(BowlCount bowlCount) {
		AtomicInteger number = new AtomicInteger(0);
		this.pins = pins.stream()
			.map(pin -> {
				if (bowlCount.compareKnockingCounts(number.get())) {
					return pin;
				}
				if (!pin.isKnocked()) {
					pin.knockingPin();
					number.getAndIncrement();
					return pin;
				}
				return pin;
			})
			.collect(Collectors.toList());
		return this;
	}

	public int getStandingPinCounts() {
		return (int)pins.stream()
			.filter(pin -> !pin.isKnocked())
			.count();
	}
}
