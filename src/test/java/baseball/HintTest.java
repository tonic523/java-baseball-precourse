package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HintTest {
    @Test
    void saveHint() {
        Balls ball1 = new Balls(3);
        Balls ball2 = new Balls(3);
        ball1.add(new Ball(1));
        ball1.add(new Ball(2));
        ball1.add(new Ball(3));
        ball2.add(new Ball(1));
        ball2.add(new Ball(2));
        ball2.add(new Ball(3));

        Hint hint = new Hint(ball1, ball2);

        assertThat(hint.strike()).isEqualTo(3);
        assertThat(hint.ball()).isEqualTo(0);
        assertThat(hint.nothing()).isEqualTo(0);
    }
}
