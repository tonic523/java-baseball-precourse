package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        int end = 1;
        Balls computer = createRandomBalls(3);

        while (end == 1) {
            View.inputUI();

        }
    }

    public static Balls createRandomBalls(int size) {
        Balls balls = new Balls(3);
        Set<Ball> ballSet = new LinkedHashSet<>();
        while (ballSet.size() < size) {
            ballSet.add(new Ball(Randoms.pickNumberInRange(1, 9)));
        }
        Iterator<Ball> ballIterator = ballSet.iterator();
        while (ballIterator.hasNext()) {
            balls.add(ballIterator.next());
        }
        return balls;
    }

    public static Balls convertBalls(String input) {
        validateInput(input);
        Balls balls = new Balls(3);
        for (int i = 0; i < 3; i++) {
            balls.add(convertBall(input.charAt(i)));
        }
        return balls;
    }

    public static Ball convertBall(char c) {
        validateIsNumber(c);
        return new Ball(c - '0');
    }

    public static void validateIsNumber(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
