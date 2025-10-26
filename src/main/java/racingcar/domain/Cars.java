package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntSupplier;

public class Cars {
    private static final int MIN_CARS_COUNT = 2;
    private static final String ERROR_MIN_CARS = "[ERROR] 자동차는 2대 이상 참여해야 합니다.";
    private static final String ERROR_DUPLICATE_NAMES = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateSize(cars);
        validateUniqueness(cars);
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_CARS);
        }
    }

    private void validateUniqueness(List<Car> cars) {
        Set<String> names = new HashSet<>();
        for (Car car : cars) {
            if (!names.add(car.getNameValue())) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
            }
        }
    }

    public void playRound(IntSupplier numberProvider) {
        for (Car car : cars) {
            int randomNumber = numberProvider.getAsInt();
            car.move(randomNumber);
        }
    }

    public List<Car.CarStatus> getStatuses() {
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<String> findWinners() {
        Position maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.hasSamePositionAs(maxPosition))
                .map(Car::getNameValue)
                .toList();
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();

        for (Car car : cars) {
            if (car.isAheadOf(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}