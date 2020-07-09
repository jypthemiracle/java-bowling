package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.pin.frame.BowlCount;
import bowling.exception.PlayCountOutOfRangeException;

public class BowlCountTest {

	@DisplayName("투구 수를 생성할 수 있다.")
	@Test
	void 투구수를_생성한다() {
		int count = 0;
		BowlCount bowlCount = BowlCount.of(count);
		assertThat(bowlCount.getCount()).isEqualTo(count);
	}

	@DisplayName("투구 수가 0에서 10 범위를 벗어나는 객체를 생성하고자 하면 오류를 반환한다.")
	@ValueSource(ints = {-1, 11})
	@ParameterizedTest
	void 투구_수의_범위를_벗어나면_오류를_반환한다(int count) {
		assertThatThrownBy(
			() -> BowlCount.of(count)
		).isInstanceOf(PlayCountOutOfRangeException.class);
	}
}
