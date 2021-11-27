package baseball;

public class Ball {

    private int number;

    public Ball(int number) throws IllegalArgumentException {
        validate_number(number);
        this.number = number;
    }

    public Ball(char c) throws IllegalArgumentException {
        validate_char(c);
        this.number = c - '0';
    }

    private void validate_number(int number) throws IllegalArgumentException {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
    }

    private void validate_char(char c) throws IllegalArgumentException {
        if (c < '1' || c > '9') {
            throw new IllegalArgumentException();
        }
    }
}
