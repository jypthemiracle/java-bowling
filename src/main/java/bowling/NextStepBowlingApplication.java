package bowling;

import bowling.domain.player.Player;
import bowling.view.InputView;

public class NextStepBowlingApplication {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		final Player player = Player.of(inputView.inputPlayerName());
	}
}
