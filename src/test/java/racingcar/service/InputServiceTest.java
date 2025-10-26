package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputServiceTest {
    private InputService inputService;

    @BeforeEach
    void setUp() {
        inputService = new InputService();
    }

    @Test
    void 자동차_이름_파싱_성공_태스트() {
        String rawNames = "pobi,woni,jun";

        assertThat(inputService.createCarsFromInput(rawNames)).isNotNull();
    }

    @Test
    void 자동차_이름이_5자를_초과할_때_예외_테스트() {
        String rawNames = "pobi,woni,junjun";

        assertThatThrownBy(() -> inputService.createCarsFromInput(rawNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_중복될_때_예외_테스트() {
        String rawNames = "pobi,pobi";

        assertThatThrownBy(() -> inputService.createCarsFromInput(rawNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 시도_횟수_파싱_성공_테스트() {
        String rawCount = "5";

        assertThat(inputService.createTryCountFromInput(rawCount).value()).isEqualTo(5);
    }

    @Test
    void 시도_횟수가_숫자가_아닐_때_예외_테스트() {
        String rawCount = "abc";

        assertThatThrownBy(() -> inputService.createTryCountFromInput(rawCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }
}