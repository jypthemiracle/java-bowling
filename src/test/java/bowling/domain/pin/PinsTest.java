package bowling.domain.pin;

import static bowling.domain.pin.Pins.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PinsTest {

	@DisplayName("10개의 Pin을 가진 일급 콜렉션 Pins을 생성할 수 있다.")
	@Test
	void 열개의_핀을_갖는다() {
		Pins expect = Pins.of(new PinGenerator());
		assertThat(expect.getPins().size()).isEqualTo(PIN_LIST_SIZE);
	}
}
