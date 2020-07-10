package bowling.domain.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;
import bowling.domain.pin.PinsGenerator;

public class MissTest {

	@DisplayName("미스가 났을 때 점수를 모두 출력할 수 있다.")
	@Test
	void 미스가_난다() {
		String result = "3|3";
		Pins first = new PinsGenerator().generate().knockPins(BowlCount.of(3));
		Pins second = new PinsGenerator().generate().knockPins(BowlCount.of(3));
		State miss = Miss.ofPins(first, second);
		assertThat(miss.toString()).isEqualTo(result);
	}
}
