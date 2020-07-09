package bowling.domain.pin;

public class Pin {

	private PinState isKnocked;

	Pin(final PinState isKnocked) {
		this.isKnocked = isKnocked;
	}

	public static Pin of() {
		return new Pin(PinState.STANDING);
	}

	public boolean isKnocked() {
		return isKnocked == PinState.KNOCKED;
	}

	public PinState knockOver() {
		return isKnocked = PinState.KNOCKED;
	}
}
