package baseball;

import java.util.Objects;

public class Ball {

    private int number;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    public Ball(int number) {
        validateNumber(number);
        this.number = number;
    }

    public void validateNumber(int number) throws IllegalArgumentException {
        if (MIN_VALUE > number || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }
}
