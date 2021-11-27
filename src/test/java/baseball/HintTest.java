package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HintTest {

    private static Hint hint;

    @BeforeEach
    void setUp() {
        List<Ball> computer = new ArrayList<>();
        computer.add(new Ball(1));
        computer.add(new Ball(2));
        computer.add(new Ball(3));
        hint = new Hint(computer);
    }

    @DisplayName("볼의 타입 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:0:STRIKE", "1:1:BALL", "4:1:NOTHING"}, delimiter = ':')
    void getType(int number, int position, String status) {
        Ball ball = new Ball(number);
        assertThat(hint.getType(ball, position).toString()).isEqualTo(status);
    }

    @DisplayName("3스트라이크")
    @Test
    void threeStrike() {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(1));
        user.add(new Ball(2));
        user.add(new Ball(3));
        hint.setHint(user);
        assertThat(hint.strike()).isEqualTo(3);
    }

    @DisplayName("3볼")
    @Test
    void threeBall() {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(3));
        user.add(new Ball(1));
        user.add(new Ball(2));
        hint.setHint(user);
        assertThat(hint.ball()).isEqualTo(3);
    }

    @DisplayName("3낫싱")
    @Test
    void threeNothing() {
        List<Ball> user = new ArrayList<>();
        user.add(new Ball(4));
        user.add(new Ball(5));
        user.add(new Ball(6));
        hint.setHint(user);
        assertThat(hint.nothing()).isEqualTo(3);
    }

}
