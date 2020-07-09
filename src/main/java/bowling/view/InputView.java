package bowling.view;

import java.util.Scanner;

import bowling.domain.PlayerName;

public class InputView {
	private static final String ASK_NAME_MESSAGE = "플레이어 이름은?(3 english letters)";
	private static final Scanner Scanner = new Scanner(System.in);

	public PlayerName inputPlayerName() {
		System.out.print(ASK_NAME_MESSAGE);
		return PlayerName.of(Scanner.nextLine());
	}
}
