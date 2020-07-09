package bowling.domain.pin;

import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PinsGenerator implements DomainGenerator<Pins> {

	@Override
	public Pins generate() {
		return IntStream.range(0, Pins.PIN_LIST_SIZE)
			.mapToObj(count -> Pin.of())
			.collect(collectingAndThen(Collectors.toList(), Pins::new));
	}
}
