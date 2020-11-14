package bowling.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	void 점수_객체를_생성한다() {
		Score score = new Score(10, 2);
		assertThat(score).isEqualTo(new Score(10, 2));
	}
}
