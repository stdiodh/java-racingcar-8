package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class RacingGame {
    private final InputService inputService;
    private Cars cars;
    private TryCount tryCount;

    public RacingGame(InputService inputService) {
        this.inputService = inputService;
    }

    public void setupGame(String rawNames, String rawCount) {
        this.cars = inputService.createCarsFromInput(rawNames);
        this.tryCount = inputService.createTryCountFromInput(rawCount);
    }
}
