package baseball;

public class Game {

    public static void validateSize(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
