package baseball;

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hint {

    private List<Ball> computer;
    private Map<BallType, Integer> hint = new HashMap<>();

    {
        hint.put(STRIKE, 0);
        hint.put(BALL, 0);
        hint.put(NOTHING, 0);
    }

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

    public void setHint(List<Ball> user) {
        for (int i = 0; i < computer.size(); i++) {
            BallType type = getType(user.get(i), i);
            hint.replace(type, hint.get(type) + 1);
        }
    }

    public int strike() {
        return hint.get(STRIKE);
    }

    public int ball() {
        return hint.get(BALL);
    }

    public int nothing() {
        return hint.get(NOTHING);
    }

}
