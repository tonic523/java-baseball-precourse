package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    public static Balls convertBalls(String input) {
        validateInput(input);
        Balls balls = new Balls(3);
        for (int i = 0; i < 3; i++) {
            balls.add(convertBall(
                input.charAt(i)
            ));
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
