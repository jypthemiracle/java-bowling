package bowling.domain.frame;

import java.util.Optional;

import bowling.domain.result.Result;
import bowling.domain.score.Score;
import bowling.domain.score.Scores;
import bowling.util.FrameSize;

public class NormalFrame implements Frame {

	private int index;
	private Scores scores;
	private Frame next;

	private NormalFrame(int index, Scores scores) {
		this.index = index;
		this.scores = scores;
	}

	public static NormalFrame of(int index, Scores scores) {
		return new NormalFrame(index, scores);
	}

	public static NormalFrame createFirstFrame() {
		final int FIRST_INDEX = 0;
		return new NormalFrame(FIRST_INDEX, Scores.of());
	}

	@Override
	public void addScore(Score score) {
		if (scores.isFirstScoreNull()) {
			addFirstScore(score);
			return;
		}
		if (scores.isSecondScoreNull()) {
			addSecondScore(score);
		}
	}

	@Override
	public void addFirstScore(Score firstScore) {
		scores.addFirstScore(firstScore);
	}

	@Override
	public void addSecondScore(Score second) {
		scores.addSecondScore(second);
	}

	@Override
	public void addBonusScore(Score bonus) {
		throw new IllegalArgumentException("일반 프레임에서 보너스 개념이 없습니다.");
	}

	@Override
	public Frame addNextFrame() {
		final int nextIndex = index + 1;
		if (nextIndex == FrameSize.NORMAL_FRAME_SIZE) {
			this.next = FinalFrame.of();
			return this.next;
		}
		this.next = NormalFrame.of(nextIndex, Scores.of());
		return this.next;
	}

	@Override
	public boolean canPlayMore() {
		return scores.canPlayMore();
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public Scores getScores() {
		return scores;
	}

	@Override
	public Optional<Score> calculateFrameTotalScore() {
		if (! scores.hasCheckResult()) {
			return Optional.empty();
		}
		Result result = scores.checkResult();
		Scores nextFrameScore = next.getScores();
		Score totalScore = result.calculateFrameTotalScore(this.scores.calculateFrameTotalScore(), nextFrameScore);
		return Optional.ofNullable(totalScore);
	}
}
