package baseball;

import camp.nextstep.edu.missionutils.Console;
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
            Balls user = convertBalls(Console.readLine());
            Hint hint = new Hint(computer, user);
            View.hintUI(hint);
            if (hint.strike() != 3) {
                continue;
            }
            end = Integer.parseInt(Console.readLine());
            if (end == 2) {
                System.out.println("게임 종료");
                break;
            }
            computer = createRandomBalls(3);
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

    public static Balls convertBalls(String input) throws IllegalArgumentException{
        validateInput(input);
        Balls balls = new Balls(3);
        for (int i = 0; i < 3; i++) {
            balls.add(convertBall(input.charAt(i)));
        }
        return balls;
    }

    public static Ball convertBall(char c) throws IllegalArgumentException {
        validateIsNumber(c);
        return new Ball(c - '0');
    }

    public static void validateIsNumber(char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInput(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
