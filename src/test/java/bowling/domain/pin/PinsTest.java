package bowling.domain.pin;

import static bowling.domain.pin.Pins.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.pin.frame.BowlCount;
import bowling.exception.BowlCountOverThanPinsCountException;

public class PinsTest {

	public PinsGenerator pinsGenerator;

	@BeforeEach
	void setUp() {
		pinsGenerator = new PinsGenerator();
	}

	@DisplayName("10개의 Pin을 가진 일급 콜렉션 Pins을 생성할 수 있다.")
	@Test
	void 열개의_핀을_갖는다() {
		Pins expect = pinsGenerator.generate();
		assertThat(expect.getPins().size()).isEqualTo(PIN_LIST_SIZE);
	}

	@DisplayName("넘어진 핀의 갯수를 구할 수 있다.")
	@ValueSource(ints = {3, 4, 5})
	@ParameterizedTest
	void 넘어진_핀의_개수를_반환한다(int knockedPinCounts) {
		PinsGeneratorMock pinsGeneratorMock = new PinsGeneratorMock();
		Pins expect = pinsGeneratorMock.generate(knockedPinCounts);
		assertThat(expect.getKnockedPinCounts()).isEqualTo(knockedPinCounts);
	}

	@DisplayName("핀을 넘어뜨린 이후, 현재 서 있는 핀의 개수를 구할 수 있다.")
	@ValueSource(ints = {3, 4, 5})
	@ParameterizedTest
	void 서있는_핀의_개수를_반환한다(int count) {
		final int expectedStandingCounts = PIN_LIST_SIZE - count;

		Pins pins = pinsGenerator.generate();
		BowlCount bowlCount = BowlCount.of(count);
		pins.knockPins(bowlCount);
		final int standingCounts = pins.getStandingPinCounts();
		assertThat(standingCounts).isEqualTo(expectedStandingCounts);
	}

	@DisplayName("투구 수가 핀의 개수보다 많을 경우 오류를 반환한다.")
	@ValueSource(ints = {7, 8, 9})
	@ParameterizedTest
	void 투구수는_핀수보다_많으면_오류를_반환한다(int count) {
		Pins pins = pinsGenerator.generate();
		BowlCount bowlCount = BowlCount.of(count);
		pins.knockPins(bowlCount);

		assertThatThrownBy(
			() -> pins.knockPins(bowlCount)
		).isInstanceOf(BowlCountOverThanPinsCountException.class);
	}
}
