package baseball;

import java.util.List;

public class Game {

	private final String START = "1";
	private final String END = "2";

	private boolean isPlay = true;
	private Balls computer;
	private Hint hint;

	public Game(List<Integer> computer) {
		this.computer = new Balls(computer);
	}

	public boolean checkhint(Hint hint) {
		if (hint.strike() == Balls.SIZE) {
			return true;
		}
		return false;
	}

    public Hint compare(Balls user) {
	    return new Hint(computer, user);
    }

	public void choicePlay(String input) {
		validateInput(input);
		if (input.equals(END)) {
			isPlay = false;
			return;
		}
	}

	// 컴퓨터 재설정

	public boolean isPlay() {
		return isPlay;
	}

	public Balls getComputer() {
		return computer;
	}

	public void validateInput(String input) {
		if (!(input.equals(START)) && !(input.equals(END))) {
			throw new IllegalArgumentException();
		}
	}
}