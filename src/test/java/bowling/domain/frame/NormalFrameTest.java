package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
