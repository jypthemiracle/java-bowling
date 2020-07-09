package bowling.exception;

public class NameEmptyOrNullException extends IllegalArgumentException {
	private static String ERROR_MSG = "이름에는 공백이나 빈 값이 올 수 없습니다.";

	public NameEmptyOrNullException() {
		super(ERROR_MSG);
	}
}
