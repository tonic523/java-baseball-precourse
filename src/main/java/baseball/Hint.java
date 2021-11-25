package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hint {

    private Map<BallStatus, Integer> hint = new HashMap<>();

    {
        hint.put(BallStatus.STRIKE, 0);
        hint.put(BallStatus.BALL, 0);
        hint.put(BallStatus.NOTHING, 0);
    }

    public Hint(Balls balls1, Balls balls2) {
        List<Ball> balls = balls2.getBalls();
        for (int i = 0; i < 3; i++) {
            BallStatus ballStatus = balls1.getBallStatus(balls.get(i), i);
            hint.put(ballStatus, hint.get(ballStatus) + 1);
        }
    }

    public int strike() {
        return hint.get(BallStatus.STRIKE);
    }

    public int ball() {
        return hint.get(BallStatus.BALL);
    }

    public int nothing() {
        return hint.get(BallStatus.NOTHING);
    }
}
