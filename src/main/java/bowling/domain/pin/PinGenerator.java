package bowling.domain.pin;

public class PinGenerator implements DomainGenerator<Pin> {

	@Override
	public Pin generate() {
		return Pin.of();
	}
}
