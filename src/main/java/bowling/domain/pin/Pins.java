package bowling.domain.pin;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import bowling.exception.BowlCountOverThanPinsCountException;

public class Pins {

	public static final int PIN_LIST_SIZE = 10;
	private List<Pin> pins;

	Pins(final List<Pin> pinList) {
		this.pins = Collections.unmodifiableList(pinList);
	}

	public List<Pin> getPins() {
		return pins;
	}

	public int getKnockedPinCounts() {
		return (int)pins.stream()
			.filter(Pin::isKnocked)
			.count();
	}

	public int getStandingPinCounts() {
		return (int)pins.stream()
			.filter(pin -> !pin.isKnocked())
			.count();
	}

	public Pins knockPins(final BowlCount bowlCount) {
		checkKnockCountsWithBowlCount(bowlCount);
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

	public void checkKnockCountsWithBowlCount(final BowlCount bowlCount) {
		if (bowlCount.isGreaterThan(getStandingPinCounts())) {
			throw new BowlCountOverThanPinsCountException();
		}
	}

	public boolean isKnockedDownAll() {
		return getKnockedPinCounts() == PIN_LIST_SIZE;
	}

	public boolean isAllStanding() {
		return getStandingPinCounts() == PIN_LIST_SIZE;
	}
}
