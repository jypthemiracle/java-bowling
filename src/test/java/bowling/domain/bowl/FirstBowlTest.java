package bowling.domain.bowl;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;
import bowling.domain.state.FirstBowl;
import bowling.domain.state.Spare;
import bowling.domain.state.State;

public class FirstBowlTest {

	@DisplayName("두 번쨰 투구에 남은 핀을 모두 떨어뜨리면 스페어를 반환한다.")
	@Test
	void 스페어가_반환된다() {
		Pins first = createPins(5);
		Pins second = createPins(5);
		FirstBowl firstBowl = FirstBowl.of(first);
		State actual = firstBowl.roll(second);
		assertThat(actual).isInstanceOf(Spare.class);
	}

	Pins createPins(int count) {
		BowlCount bowlCount = BowlCount.of(count);
		final Pins pins = Pins.of();
		return pins.knockPins(bowlCount);
	}
}
