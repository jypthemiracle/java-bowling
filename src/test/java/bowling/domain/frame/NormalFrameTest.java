package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;

public class NormalFrameTest {

	@DisplayName("일반 프레임은 다음 프레임을 가지고 있다.")
	@Test
	void 일반_프레임은_다음_프레임을_보유한다() {
		FrameNumber frameNumber = FrameNumber.of(1);
		Frame expect = NormalFrame.of(frameNumber.increaseByOneNumber());
		Frame actual = NormalFrame.of(frameNumber);
		assertThat(actual.getNext().get().getFrameNumber()).isEqualTo(expect.getFrameNumber());
	}

	@DisplayName("마지막 이전의 프레임은 마지막 프레임을 가지고 있다.")
	@Test
	void 마지막_이전_프레임은_마지막_프레임을_보유한다() {
		FrameNumber frameNumber = FrameNumber.of(9);
		Frame expect = NormalFrame.of(frameNumber);
		assertThat(expect.getNext().get()).isInstanceOf(FinalFrame.class);
	}

	@DisplayName("현재 Frame이 진행중 상태일 경우 다음 프레임으로 넘어갈 수 없다.")
	@Test
	void 진행중이면_넘어가지_못한다() {
		Pins pins = Pins.of().knockPins(BowlCount.of(5));
		FrameNumber frameNumber = FrameNumber.of(1);
		Frame frame = NormalFrame.of(frameNumber);
		frame.bowl(pins);
		assertThat(frame.isTurnOver()).isFalse();
	}

	@DisplayName("현재 Frame이 Strike일 경우 다음 프레임으로 넘어갈 수 있다.")
	@Test
	void 스트라이크면_넘어가지_못한다() {
		Pins pins = Pins.of().knockPins(BowlCount.of(10));
		FrameNumber frameNumber = FrameNumber.of(1);
		Frame frame = NormalFrame.of(frameNumber);
		frame.bowl(pins);
		assertThat(frame.toString()).isEqualTo("X");
		assertThat(frame.isTurnOver()).isTrue();
	}

	@DisplayName("현재 Frame이 SPARE 일 경우 다음 프레임으로 넘어갈 수 있다.")
	@Test
	void 스페어면_넘어간다() {
		Pins first = Pins.of().knockPins(BowlCount.of(5));
		Pins second = Pins.of().knockPins(BowlCount.of(5));

		FrameNumber frameNumber = FrameNumber.of(1);
		Frame frame = NormalFrame.of(frameNumber);

		frame.bowl(first);
		frame.bowl(second);

		assertThat(frame.toString()).isEqualTo("5|/");
		assertThat(frame.isTurnOver()).isTrue();
	}

	@DisplayName("현재 Frame이 MISS 일 경우 다음 프레임으로 넘어갈 수 있다.")
	@Test
	void 미스면_넘어간다() {
		Pins first = Pins.of().knockPins(BowlCount.of(5));
		Pins second = Pins.of().knockPins(BowlCount.of(4));

		FrameNumber frameNumber = FrameNumber.of(1);
		Frame frame = NormalFrame.of(frameNumber);

		frame.bowl(first);
		frame.bowl(second);

		assertThat(frame.toString()).isEqualTo("9");
		assertThat(frame.isTurnOver()).isTrue();
	}

	@DisplayName("현재 Frame이 GUTTER 일 경우 다음 프레임으로 넘어갈 수 있다.")
	@Test
	void gutter() {
		Pins first = Pins.of().knockPins(BowlCount.of(0));
		Pins second = Pins.of().knockPins(BowlCount.of(0));

		FrameNumber frameNumber = FrameNumber.of(1);
		Frame frame = NormalFrame.of(frameNumber);

		frame.bowl(first);
		frame.bowl(second);

		assertThat(frame.toString()).isEqualTo("-");
		assertThat(frame.isTurnOver()).isTrue();
	}
}
