package bowling.domain.frame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bowling.domain.score.Score;

public class NormalFrameTest {

	private NormalFrame frame;
	private FinalFrame finalFrame;

	@BeforeEach
	void setUp() {
		frame = NormalFrame.createFirstFrame();
		finalFrame = FinalFrame.of();
	}

	@DisplayName("새로 추가한 프레임의 경우 게임을 추가로 플레이할 수 있다.")
	@Test
	void 새로_추가한_프레임은_게임_플레이가_가능하다() {
		boolean canPlayMoreCertain = frame.canPlayMore();
		assertThat(canPlayMoreCertain).isEqualTo(true);

		boolean canPlayMoreCertainForFinalFrame = finalFrame.canPlayMore();
		assertThat(canPlayMoreCertainForFinalFrame).isEqualTo(true);
	}

	@DisplayName("한 타구가 진행된 프레임의 경우 게임을 추가로 플레이할 수 있다.")
	@Test
	void 한_타구가_진행된_프레임은_게임_플레이가_가능하다() {
		Score firstScore = Score.ofScore(5);

		frame.addScore(firstScore);
		boolean canPlayMoreCertain = frame.canPlayMore();
		assertThat(canPlayMoreCertain).isEqualTo(true);

		finalFrame.addScore(firstScore);
		boolean canPlayMoreCertainForFinalFrame = finalFrame.canPlayMore();
		assertThat(canPlayMoreCertainForFinalFrame).isEqualTo(true);
	}

	@DisplayName("두 번째 타구가 진행된 프레임의 경우 게임을 추가로 플레이할 수 없다.")
	@Test
	void 두번째_타구가_진행된_프레임은_게임_플레이가_불가능하다() {
		Score firstScore = Score.ofScore(5);
		Score secondScore = Score.ofScore(4);

		frame.addScore(firstScore);
		frame.addScore(secondScore);
		boolean canPlayMoreCertain = frame.canPlayMore();
		assertThat(canPlayMoreCertain).isEqualTo(false);

		finalFrame.addScore(firstScore);
		finalFrame.addScore(secondScore);
		boolean canPlayMoreCertainForFinalFrame = finalFrame.canPlayMore();
		assertThat(canPlayMoreCertainForFinalFrame).isEqualTo(false);
	}

	@DisplayName("해당 프레임의 총 점수를 구한다.")
	@CsvSource({"5, 5, 7"})
	@ParameterizedTest
	void 프레임_하나의_최종점수를_구한다(int firstScore, int secondScore, int thirdScore) {
		NormalFrame frame = NormalFrame.createFirstFrame();
		frame.addScore(Score.ofScore(5));
		frame.addScore(Score.ofScore(5));
		frame.addNextFrame().addScore(Score.ofScore(7));

		Score score = frame.calculateFrameTotalScore();
		assertThat(score.getScore()).isEqualTo(firstScore + secondScore + thirdScore);
	}
}
