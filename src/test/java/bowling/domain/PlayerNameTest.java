package bowling.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
