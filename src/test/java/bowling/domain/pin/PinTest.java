package bowling.domain.pin;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PinTest {

	@DisplayName("핀 객체 하나를 생성할 수 있다. 핀의 기본값은 쓰러지지 않았다는 것이다.")
	@Test
	void 핀_객체를_생성한다() {
		Pin expect = Pin.of();
		assertThat(expect.isKnocked()).isEqualTo(PinState.STANDING);
	}

	@DisplayName("핀을 넘어뜨릴 수 있다.")
	@Test
	void 핀을_넘어뜨린다() {
		Pin expect = Pin.of();
		expect.knockingPin();
		assertThat(expect.isKnocked()).isEqualTo(PinState.KNOCKED);
	}
}
