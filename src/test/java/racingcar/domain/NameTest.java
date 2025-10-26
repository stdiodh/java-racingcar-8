package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "12345"})
    void 이름_생성_테스트(String validName) {
        assertThatCode(() -> new Name(validName))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름이_5자를_초과하는_예외_테스트() {
        String invalidName = "pobiwoni";

        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   "})
    void 이름이_공백일_때_예외_테스트(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백일 수 없습니다.");
    }
}