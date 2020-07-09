package bowling.exception;

public class FrameNumberOutOfRangeException extends IllegalArgumentException {

	public static String ERROR_MSG = "프레임 번호는 1에서 10 사이의 숫자만 입력되어야 합니다.";

	public FrameNumberOutOfRangeException() {
		super(ERROR_MSG);
	}
}
