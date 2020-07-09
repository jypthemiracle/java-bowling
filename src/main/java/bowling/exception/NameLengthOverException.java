package bowling.exception;

public class NameLengthOverException extends IllegalArgumentException {
	private static String ERROR_MSG = "이름의 길이가 3글자를 초과하였습니다. : %s";

	public NameLengthOverException(String value) {
		super(String.format(ERROR_MSG, value));
	}
}
