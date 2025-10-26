package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 1000})
    void 시도_횟수_생성_테스트(int validValue) {
        assertThatCode(() -> new TryCount(validValue))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void 시도_횟수가_음수일_때_예외_테스트(int invalidValue) {
        assertThatThrownBy(() -> new TryCount(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }
}