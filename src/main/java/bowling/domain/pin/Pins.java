package bowling.domain.pin;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import bowling.exception.BowlCountOverThanPinsCountException;

public class Pins {

	public static final int PIN_LIST_SIZE = 10;
	private List<Pin> pins;

	Pins(final List<Pin> pinList) {
		this.pins = Collections.unmodifiableList(pinList);
	}

	public static Pins of() {
		return new PinsGenerator().generate();
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
		return pins.stream()
			.filter(Pin::isStanding)
			.limit(bowlCount.getCount())
			.map(Pin::knockingPin)
			.collect(collectingAndThen(Collectors.toList(), Pins::new));
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

	public boolean isGutter() {
		return getKnockedPinCounts() == 0;
	}

	public Pins add(final Pins knockOverPins) {
		List<Pin> all = new ArrayList<>(pins);
		all.addAll(knockOverPins.pins);
		return new Pins(all);
	}
}
