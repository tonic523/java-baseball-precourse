package baseball;

import java.util.Objects;

public class Ball {

    private int number;
    private int position;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    public Ball(int number, int position) {
        validateNumber(number);
        this.number = number;
        this.position = position;
    }

    public void validateNumber(int number) throws IllegalArgumentException {
        if (MIN_VALUE > number || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return this.number;
    }

    public int getPosition() {
        return this.position;
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

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
