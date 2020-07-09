package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.pin.frame.FrameNumber;
import bowling.exception.FrameNumberOutOfRangeException;

public class FrameNumberTest {

	@DisplayName("각각의 프레임마다 프레임 번호를 생성할 수 있다.")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@ParameterizedTest
	void 프레임_번호를_생성한다(int number) {
		FrameNumber frameNumber = FrameNumber.of(number);
		assertThat(frameNumber.getNumber()).isEqualTo(number);
	}

	@DisplayName("프레임 번호가 1에서 10 사이가 아니라면 오류를 반환한다.")
	@ValueSource(ints = {-1, 0, 11})
	@ParameterizedTest
	void 프레임_번호가_범위_내부에_있다(int number) {
		assertThatThrownBy(
			() -> FrameNumber.of(number)
		).isInstanceOf(FrameNumberOutOfRangeException.class);
	}
}
