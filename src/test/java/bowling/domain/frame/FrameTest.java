package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.pin.frame.Frame;

public class FrameTest {

	@DisplayName("프레임 하나를 생성한다. 각각의 프레임은 번호를 갖는다.")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@ParameterizedTest
	void 프레임을_생성한다(int frameNumber) {
		Frame expect = Frame.of(frameNumber);
		assertThat(expect.getFrameNumber()).isEqualTo(frameNumber);
	}
}
