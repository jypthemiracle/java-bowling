package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FinalFrameTest {

	@DisplayName("마지막 프레임은 다음 프레임을 보유하지 않는다.")
	@Test
	void 마지막_프레임은_다음_프레임을_보유하지_않는다() {
		FrameNumber frameNumber = FrameNumber.of(10);
		Frame expect = FinalFrame.of(frameNumber);
		assertThat(expect.getNext().isPresent()).isEqualTo(false);
	}
}
