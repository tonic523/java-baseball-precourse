package baseball;

import java.util.Objects;

public class Ball {

    private int number;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;


    public Ball(int number) throws IllegalArgumentException {
        validate_number(number);
        this.number = number;
    }

    public Ball(char c) throws IllegalArgumentException {
        validate_char(c);
        this.number = c - '0';
    }

    private void validate_number(int number) throws IllegalArgumentException {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private void validate_char(char c) throws IllegalArgumentException {
        if (c < MIN_VALUE + '0' || c > MAX_VALUE + '0') {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ball)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }
}
