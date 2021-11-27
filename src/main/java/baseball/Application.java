package baseball;

import static baseball.Ball.MAX_VALUE;
import static baseball.Ball.MIN_VALUE;
import static baseball.View.inputUI;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Application {

    private static final String END = "2";

    private static boolean START = true;
    private static List<Ball> computer;
    public static final int BALL_SIZE = 3;

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        init();
        while (START) {
            inputUI();
            String input = Console.readLine();
            validate(input);
            Hint hint = compare(input);
            View.hintUI(hint);
            if (!(isCorrect(hint.strike()))) {
                continue;
            }
            View.correctUI();
            choicePlay(Console.readLine());
        }
    }

    private static void init() {
        computer = setRandomBallList();
    }

    public static List<Ball> setRandomBallList() {
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        while (balls.size() < BALL_SIZE) {
            balls.add(new Ball(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)));
        }
        return new ArrayList<>(balls);
    }

    public static List<Ball> setBallList(String input) throws IllegalArgumentException {
        LinkedHashSet<Ball> balls = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            balls.add(new Ball(input.charAt(i)));
        }
        validateSize(balls.size());
        return new ArrayList<>(balls);
    }

    public static Hint compare(String input) {
        Hint hint = new Hint(computer);
        List<Ball> user = setBallList(input);
        hint.setHint(user);
        return hint;
    }

    public static boolean isCorrect(int strike) {
        if (strike == BALL_SIZE) {
            return true;
        }
        return false;
    }

    public static void choicePlay(String input) {
        if (input.equals(END)) {
            START = false;
            return;
        }
        init();
    }

    // 유효성 검사
    private static void validate(String input) {
        validateSize(input.length());
        validateIsNumber(input);
    }

    public static void validateSize(int size) {
        if (size != BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            validateIsNumber(input.charAt(i));
        }
    }

    public static void validateIsNumber(char c) {
        if (!(Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }
}
