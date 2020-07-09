package bowling.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	@DisplayName("플레이어는 이름을 갖는다.")
	@Test
	void 플레이어는_이름을_갖는다() {
		String name = "PJS";
		PlayerName playerName = PlayerName.of(name);
		Player expect = Player.of(playerName);
		assertThat(expect.getPlayerName()).isEqualTo(name);
	}
}
