package bowling.domain;

import bowling.exception.NameLengthOverException;

public class PlayerName {

	private static final int NAME_MAXIMUM_LENGTH = 3;
	private final String name;

	private PlayerName(final String name) {
		this.name = name;
	}

	public static PlayerName of(final String name) {
		validNameLength(name);
		return new PlayerName(name);
	}

	private static void validNameLength(final String name) {
		if (name.length() > NAME_MAXIMUM_LENGTH) {
			throw new NameLengthOverException(name);
		}
	}

	public String getName() {
		return name;
	}
}
