package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(3);
        balls.add(new Ball(1));
        balls.add(new Ball(2));
        balls.add(new Ball(3));
    }

    @Test
    void addBall() {
        assertThat(balls.getBalls().size()).isEqualTo(3);
    }

    @Test
    void validateDuplication() {
        assertThatThrownBy(() -> balls.validateDuplication(new Ball(1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getBallStatus() {
        assertThat(balls.getBallStatus(new Ball(1), 0)).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.getBallStatus(new Ball(1), 1)).isEqualTo(BallStatus.BALL);
        assertThat(balls.getBallStatus(new Ball(4), 0)).isEqualTo(BallStatus.NOTHING);
    }
}
