package bowling.domain.pin;

public class PinGenerator implements DomainGenerator<Pin> {

	@Override
	public Pin generate() {
		return Pin.of();
	}

	public Pin generate(final PinState pinState) {
		return new Pin(pinState);
	}
}
