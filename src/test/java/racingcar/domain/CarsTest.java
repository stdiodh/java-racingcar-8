package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차_컬렉션_생성_성공_테스트() {
        List<Car> carList = List.of(
                new Car(new Name("pobi")),
                new Car(new Name("woni"))
        );

        assertThatCode(() -> new Cars(carList))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_컬렉션_2대_미만_예외_테스트() {
        List<Car> carList = List.of(
                new Car(new Name("pobi"))
        );

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차는 2대 이상 참여해야 합니다.");
    }

    @Test
    void 자동차_컬렉션_이름_중복_예외_테스트() {
        List<Car> carList = List.of(
                new Car(new Name("pobi")),
                new Car(new Name("pobi"))
        );

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
