package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void validateNumber() {
        assertThatThrownBy(() -> new Ball(0, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballGetter() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.getNumber()).isEqualTo(1);
        assertThat(ball.getPosition()).isEqualTo(1);
    }

}
