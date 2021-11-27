package baseball;

import static baseball.Ball.MAX_VALUE;
import static baseball.Ball.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Game {

    private final String END = "2";

    private boolean play = true;
    private List<Ball> computer;
    public final int BALL_SIZE = 3;

    public Game() {
        init();
    }

    private void init() {
        computer = setRandomBallList();
    }

    public List<Ball> setRandomBallList() {
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        while (balls.size() < BALL_SIZE) {
            balls.add(new Ball(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)));
        }
        return new ArrayList<>(balls);
    }

    public List<Ball> setBallList(String input) throws IllegalArgumentException {
        validateSize(input.length());
        validateIsNumber(input);
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            balls.add(new Ball(input.charAt(i)));
        }
        validateSize(balls.size());
        return new ArrayList<>(balls);
    }

    public Hint compare(String input) {
        Hint hint = new Hint(computer);
        List<Ball> user = setBallList(input);
        hint.setHint(user);
        return hint;
    }

    public boolean isCorrect(int strike) {
        if (strike == BALL_SIZE) {
            return true;
        }
        return false;
    }

    public void choicePlay(String input) {
        if (input.equals(END)) {
            play = false;
            return;
        }
        init();
    }

    public boolean start() {
        return play;
    }

    // 유효성 검사
    public static void validateSize(int size) throws IllegalArgumentException {
        if (size != 3) {
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
}
