package bowling.domain.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;

public class PlayingTest {

	@DisplayName("두번째 투구에 남은 핀들을 넘어트리면 스페어를 반환한다.")
	@Test
	void 두번째_투구때_스페어를_반환한다() {
		Pins first = createPins(5);
		Pins second = createPins(5);
		Playing playing = Playing.of(first);

		State spare = playing.roll(second);

		assertThat(spare).isInstanceOf(Spare.class);
	}

	@DisplayName("두번째 투구에 남은 핀들을 못 넘어트리면 MISS를 반환한다.")
	@Test
	void 두번째_투구때_미스를_반환한다() {
		Pins first = createPins(5);
		Pins second = createPins(4);
		Playing playing = Playing.of(first);

		State miss = playing.roll(second);

		assertThat(miss).isInstanceOf(Miss.class);
	}

	@DisplayName("두번째 투구에도 핀들을 못 넘어트리면 GUTTER를 반환한다.")
	@Test
	void 두번째_투구때_거터를_반환한() {
		Pins first = createPins(0);
		Pins second = createPins(0);
		Playing playing = Playing.of(first);

		State gutter = playing.roll(second);

		assertThat(gutter).isInstanceOf(Gutter.class);
	}

	Pins createPins(int count) {
		BowlCount bowlCount = BowlCount.of(count);
		final Pins pins = Pins.of();

		return pins.knockPins(bowlCount);
	}
}
