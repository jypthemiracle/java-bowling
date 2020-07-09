package bowling.exception;

public class BowlCountOverThanPinsCountException extends IllegalArgumentException {

	private static String ERROR_MSG = "투구 수는 핀의 수를 넘어설 수 없습니다.";

	public BowlCountOverThanPinsCountException() {
		super(ERROR_MSG);
	}
}
