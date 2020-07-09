package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.pin.frame.FrameNumber;

public class FrameNumberTest {

	@DisplayName("각각의 프레임마다 프레임 번호를 생성할 수 있다.")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@ParameterizedTest
	void 프레임_번호를_생성한다(int index) {
		FrameNumber frameNumber = FrameNumber.of(index);
		assertThat(frameNumber.getNumber()).isEqualTo(index);
	}
}
