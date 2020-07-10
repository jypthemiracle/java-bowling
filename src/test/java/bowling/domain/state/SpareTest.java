package bowling.domain.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bowling.domain.pin.BowlCount;
import bowling.domain.pin.Pins;
import bowling.domain.pin.PinsGenerator;

public class SpareTest {

	@DisplayName("스페어의 점수를 출력한다.")
	@Test
	void 스페어일때() {
		String result = "9|/";
		Pins first = new PinsGenerator().generate().knockPins(BowlCount.of(9));
		State spare = Spare.of(first);
		assertThat(spare.toString()).isEqualTo(result);
	}
}
