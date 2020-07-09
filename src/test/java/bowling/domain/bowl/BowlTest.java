package bowling.domain.bowl;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@DisplayName("첫 투구와 둘째 투구를 합쳐 SPARE를 확인할 수 있다.")
	@CsvSource({"1, 9", "2, 8", "3, 7", "4, 6", "5, 5", "6, 4", "7, 3", "8, 2", "9, 1"})
	@ParameterizedTest
	void 첫_투구와_둘째_투구를_합쳐_스페어를_반환한다(int firstCount, int secondCount) {
		BowlCount firstBowlCount = BowlCount.of(firstCount);
		BowlCount secondBowlCount = BowlCount.of(secondCount);
		FirstBowl firstBowl = FirstBowl.of();
		firstBowl.bowl(firstBowlCount);
		SecondBowl secondBowl = SecondBowl.of(firstBowl);
		secondBowl.bowl(secondBowlCount);
		assertThat(secondBowl.getFrameStatus()).isEqualTo(FrameStatus.SPARE);
	}

	@DisplayName("첫 투구와 둘째 투구를 합쳐 MISS를 확인할 수 있다.")
	@CsvSource({"1, 8", "2, 7", "3, 5", "4, 5", "5, 2", "6, 1", "7, 2", "8, 1", "8, 1"})
	@ParameterizedTest
	void 첫_투구와_둘째_투구를_합쳐_미스를_반환한다(int firstCount, int secondCount) {
		BowlCount firstBowlCount = BowlCount.of(firstCount);
		BowlCount secondBowlCount = BowlCount.of(secondCount);
		FirstBowl firstBowl = FirstBowl.of();
		firstBowl.bowl(firstBowlCount);
		SecondBowl secondBowl = SecondBowl.of(firstBowl);
		secondBowl.bowl(secondBowlCount);
		assertThat(secondBowl.getFrameStatus()).isEqualTo(FrameStatus.MISS);
	}
}
