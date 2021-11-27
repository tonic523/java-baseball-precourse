package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {

    @DisplayName("길이 검사")
    @Nested
    class ValidateSize {
        @DisplayName("성공")
        @Test
        void success() {
            Game.validateSize("123");
        }

        @DisplayName("실패")
        @ParameterizedTest
        @ValueSource(strings = {"1", "12", "1234"})
        void fail() {
            assertThatThrownBy(() -> Game.validateSize("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
