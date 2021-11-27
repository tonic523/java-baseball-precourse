package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class HintTest {

    private Hint hint;

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

}
