package baseball;

public class Game {

    private boolean play = true;

    public static void validateSize(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumber(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            validateIsNumber(input.charAt(i));
        }
    }

    public static void validateIsNumber(char c) throws IllegalArgumentException {
        if (!(Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    public void setPlay(int number) {
        if (number == 2) {
            play = false;
        }
    }

    public boolean isPlay() {
        return play;
    }
}
