package baseball;

import static baseball.Ball.MAX_VALUE;
import static baseball.Ball.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.List;

public class Game {

    private boolean play = true;
    private List<Ball> computer;
    private final int BALL_SIZE = 3;

    public Game() {
        computer = setComputer();
    }

    public List<Ball> setComputer() {
        LinkedHashSet<Ball> computer = new LinkedHashSet<>();
        while (computer.size() < BALL_SIZE) {
            computer.add(new Ball(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)));
        }
        return (List<Ball>) computer;
    }

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
