package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;
import bowling.domain.pin.PinsGenerator;
import bowling.domain.state.Gutter;
import bowling.domain.state.State;

public class GutterTest {

	@DisplayName("첫 번째와 두 번째 투구가 모두 거터일 경우, -|-를 출력한다.")
	@Test
	void 첫번째와_두번째_모두_거터일때() {
		String result = "-|-";
		State gutter = Gutter.of(Pins.GUTTER, Pins.GUTTER);
		assertThat(gutter.toString()).isEqualTo(result);
	}

	@DisplayName("첫 번째만 거터일 경우, -|{점수}를 출력한다.")
	@Test
	void 첫번째만_거터일때() {
		String result = "-|6";
		State gutter = Gutter.of(Pins.GUTTER, new PinsGenerator().generate().knockPins(BowlCount.of(6)));
		assertThat(gutter.toString()).isEqualTo(result);
	}

	@DisplayName("첫 번째만 거터일 경우, {점수}|-를 출력한다.")
	@Test
	void 두번째만_거터일때() {
		String result = "6|-";
		State gutter = Gutter.of(new PinsGenerator().generate().knockPins(BowlCount.of(6)), Pins.GUTTER);
		assertThat(gutter.toString()).isEqualTo(result);
	}
}
