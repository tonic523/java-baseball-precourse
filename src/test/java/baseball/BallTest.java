package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    @DisplayName("유효성 검사")
    @Nested
    class validate {
        @DisplayName("숫자 검사")
        @ParameterizedTest
        @ValueSource(ints = {0, 10})
        void number_1_to_9 (int number) {
            assertThatThrownBy(() -> new Ball(number))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("문자 검사")
        @ParameterizedTest
        @ValueSource(chars = {'0', 'a', 'z'})
        void number_1_to_9 (char c) {
            assertThatThrownBy(() -> new Ball(c))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }


}
