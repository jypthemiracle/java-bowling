package bowling.exception;

public class PlayCountOutOfRangeException extends IllegalArgumentException {

	private final static String ERROR_MSG = "투구 수는 0에서 10까지만 가질 수 있습니다.";

	public PlayCountOutOfRangeException() {
		super(ERROR_MSG);
	}
}
