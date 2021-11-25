package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(int size) {
        balls = new ArrayList<Ball>(size);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    public void validateDuplication(Ball ball) throws IllegalArgumentException {
        if (balls.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }

    public BallStatus getBallStatus(Ball ball, int position) {
        if (balls.contains(ball) && balls.get(position).equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (balls.contains(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
