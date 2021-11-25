package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void addBall() {
        Balls balls = new Balls(3);
        balls.add(new Ball(1, 0));
        balls.add(new Ball(2, 1));
        balls.add(new Ball(3, 2));
        assertThat(balls.getBalls().size()).isEqualTo(3);
    }

    @Test
    void validateDuplication() {
        Balls balls = new Balls(3);
        balls.add(new Ball(1, 0));
        assertThatThrownBy(() -> balls.validateDuplication(new Ball(1, 1)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
