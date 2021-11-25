package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

    private List<Ball> balls;

    public Balls(int size) {
        balls = new ArrayList<Ball>(3);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void add(Ball ball) {
        balls.add(ball.getPosition(), ball);
    }

    public void validateDuplication(Ball ball) throws IllegalArgumentException {
        if (balls.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }
}
