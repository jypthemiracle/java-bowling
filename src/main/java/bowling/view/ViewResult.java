package bowling.view;

import java.util.Arrays;
import java.util.Optional;

import bowling.domain.result.Result;
import bowling.domain.score.Score;
import bowling.domain.score.Scores;

public enum ViewResult {
	STRIKE(Result.STRIKE) {
		@Override
		String renderString(Scores scores) {
			return "   X   ";
		}
	},
	SPARE(Result.SPARE) {
		@Override
		String renderString(Scores scores) {
			return String.format("  %d|/   ", scores.getFirst().getScore());
		}
	},
	MISS(Result.MISS) {
		@Override
		String renderString(Scores scores) {
			return String.format("   %d|%d   ", scores.getFirst().getScore(), scores.getSecond().getScore());
		}
	},
	GUTTER(Result.GUTTER) {
		@Override
		String renderString(Scores scores) {
			return "   -   ";
		}
	};

	private final Result result;

	ViewResult(Result result) {
		this.result = result;
	}

	public static String printScores(Scores scores) {
		Optional<Score> first = Optional.ofNullable(scores.getFirst());
		Optional<Score> second = Optional.ofNullable(scores.getSecond());

		if (! first.isPresent()) {
			return "      ";
		}
		if (scores.checkResult() != Result.STRIKE && ! second.isPresent()) {
			return String.format("   %s    ", first.get().getScore());
		}
		ViewResult viewResult = ViewResult.findByResult(scores.checkResult());
		return viewResult.renderString(scores);
	}

	private static ViewResult findByResult(Result result) {
		return Arrays.stream(values())
			.filter(viewResult -> viewResult.result == result)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("we cannot find any matched frame with given result"));
	}

	abstract String renderString(Scores scores);
}
