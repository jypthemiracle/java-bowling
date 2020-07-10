package bowling.domain.frame;

public enum FrameStatus {

	PLAYING(""),
	STRIKE("X"),
	SPARE(""),
	MISS(" "),
	GUTTER("-");

	private String expression;

	FrameStatus(String expression) {
		this.expression = expression;
	}

	public String getExpression() {
		return expression;
	}
}
