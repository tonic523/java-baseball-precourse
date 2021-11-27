package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void validateDupication() {
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(1);
        Balls balls = new Balls();
        balls.add(ball1);
        assertThatThrownBy(() -> balls.add(ball2))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
