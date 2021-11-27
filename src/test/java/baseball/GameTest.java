package baseball;

import static org.assertj.core.api.Assertions.as;
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

    @DisplayName("숫자인지 검사")
    @Nested
    class ValidateisNumber {
        @DisplayName("성공")
        @Test
        void success() {
            Game.validateIsNumber("123");
        }

        @DisplayName("실패")
        @Test
        void fail() {
            assertThatThrownBy(() -> Game.validateIsNumber("a23"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("게임 진행")
    @Nested
    class Play {
        @DisplayName("게임 종료")
        @Test
        void end() {
            Game game = new Game();
            game.setPlay(2);
            assertThat(game.isPlay()).isFalse();
        }

        @DisplayName("게임 진행")
        @Test
        void isPlay() {
            Game game = new Game();
            game.setPlay(1);
            assertThat(game.isPlay()).isTrue();
        }
    }
}
