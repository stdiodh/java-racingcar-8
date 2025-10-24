package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryCount;

public class InputService {
    private static final String DELIMITER = ",";
    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public Cars createCarsFromInput(String rawNames) {
        List<Name> names = Arrays.stream(rawNames.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .toList();

        List<Car> carList = names.stream().map(Car::new).toList();

        return new Cars(carList);
    }

    public TryCount createTryCountFromInput(String rawCount) {
        int number = parseNumber(rawCount);

        return new TryCount(number);
    }

    private int parseNumber(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }
}
