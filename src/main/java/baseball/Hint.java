package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;

import java.util.List;

public class Hint {

    private List<Ball> computer;

    public Hint(List<Ball> computer) {
        this.computer = computer;
    }

    public BallType getType(Ball ball, int position) {
        if (computer.get(position).equals(ball)) {
            return STRIKE;
        }
        if (computer.contains(ball)) {
            return BALL;
        }
        return NOTHING;
    }
}
