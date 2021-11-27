package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> list = new ArrayList<>();

    public Balls() {}

    public void add(Ball ball) throws IllegalArgumentException {
        validateDuplication(ball);
        list.add(ball);
    }

    private void validateDuplication(Ball ball) throws IllegalArgumentException {
        if (list.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }
}
