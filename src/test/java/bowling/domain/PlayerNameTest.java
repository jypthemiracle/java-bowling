package bowling.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import bowling.exception.NameEmptyOrNullException;
import bowling.exception.NameLengthOverException;

public class PlayerNameTest {

	@DisplayName("플레이어 이름을 생성한다.")
	@Test
	void 플레이어_이름을_생성한다() {
		String name = "HEY";
		PlayerName expect = PlayerName.of(name);
		assertThat(expect.getName()).isEqualTo(name);
	}

	@DisplayName("3글자가 넘어가면 오류를 발생시킨다.")
	@Test
	void 이름은_세_글자를_넘기지_못한다() {
		String name = "HEYY";
		assertThatThrownBy(
			() -> PlayerName.of(name)
		).isInstanceOf(NameLengthOverException.class);
	}

	static Stream<String> blankStrings() {
		return Stream.of("", "   ", null);
	}

	@DisplayName("이름에 공백이나 null이 들어오는 경우 오류를 발생시킨다.")
	@MethodSource("blankStrings")
	@ParameterizedTest
	void 이름에_공백이나_NULL이_들어오지_못한다(String name) {
		assertThatThrownBy(
			() -> PlayerName.of(name)
		).isInstanceOf(NameEmptyOrNullException.class);
	}
}
