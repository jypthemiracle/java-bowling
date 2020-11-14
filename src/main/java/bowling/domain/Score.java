package bowling.domain;

import java.util.Objects;

public class Score {
	private int score;
	private int remainder;

	public Score(int score, int remainder) {
		this.score = score;
		this.remainder = remainder;
	}

	public int getScore() {
		return score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Score score1 = (Score)o;
		return score == score1.score &&
			remainder == score1.remainder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(score, remainder);
	}
}
