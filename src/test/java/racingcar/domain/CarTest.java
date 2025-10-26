package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("pobi"));
    }

    @Test
    void 자동차는_4_이상일_때_전진한다() {
        int forwardNumber = 4;

        car.move(forwardNumber);

        assertThat(car.getStatus().position()).isEqualTo(1);
    }

    @Test
    void 자동차는_3_이하일_때_정지한다() {
        int stopNumber = 3;

        car.move(stopNumber);

        assertThat(car.getStatus().position()).isEqualTo(0);
    }
}