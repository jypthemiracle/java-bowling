package bowling.domain;

public class Player {
	private final PlayerName playerName;

	private Player(PlayerName playerName) {
		this.playerName = playerName;
	}

	public static Player of(PlayerName playerName) {
		return new Player(playerName);
	}

	public String getPlayerName() {
		return playerName.getName();
	}
}
