package bowling.domain.pin;

import java.util.ArrayList;
import java.util.List;

public class PinsGeneratorMock extends PinsGenerator {

	public Pins generate(int knockedPinsCount) {
		PinGenerator pinGenerator = new PinGenerator();
		List<Pin> pinsList = new ArrayList<>();
		for (int index = 0; index < knockedPinsCount; index++) {
			pinsList.add(pinGenerator.generate(PinState.KNOCKED));
		}
		for (int index = knockedPinsCount; index < Pins.PIN_LIST_SIZE; index++) {
			pinsList.add(pinGenerator.generate(PinState.STANDING));
		}
		Pins pins = new Pins(pinsList);
		return pins;
	}
}
