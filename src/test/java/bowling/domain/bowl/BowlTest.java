package bowling.domain.bowl;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.domain.frame.FrameStatus;
import bowling.domain.pin.BowlCount;

public class BowlTest {

	@DisplayName("첫 투구 때 쓰러진 핀이 10개이면 스트라이크를 반환한다.")
	@Test
	void 첫_투구때_스트라이크를_반환한다() {
		BowlCount bowlCount = BowlCount.of(10);
		FirstBowl firstBowl = FirstBowl.of();
		firstBowl.bowl(bowlCount);
		assertThat(firstBowl.getFrameStatus()).isEqualTo(FrameStatus.STRIKE);
	}

	@DisplayName("첫 투구 때 쓰러진 핀이 1개에서 9개 범위 내부에 있다면 플레이하고 있음을 반환한다.")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	@ParameterizedTest
	void 첫_투구때_플레이_하고_있음을_반환한다(int count) {
		BowlCount bowlCount = BowlCount.of(count);
		FirstBowl firstBowl = FirstBowl.of();
		firstBowl.bowl(bowlCount);
		assertThat(firstBowl.getFrameStatus()).isEqualTo(FrameStatus.PLAYING);
	}
}
