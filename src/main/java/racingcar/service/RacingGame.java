package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.IntSupplier;
import racingcar.domain.Car.CarStatus;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputService inputService;
    private final IntSupplier numberProvider;
    private Cars cars;
    private TryCount tryCount;

    public RacingGame(InputService inputService) {
        this.inputService = inputService;

        this.numberProvider = () -> Randoms.pickNumberInRange(0, 9);
    }

    public void setupGame(String rawNames, String rawCount) {
        this.cars = inputService.createCarsFromInput(rawNames);
        this.tryCount = inputService.createTryCountFromInput(rawCount);
    }

    public void playRace(OutputView outputView) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.playRound(numberProvider);
            List<CarStatus> statuses = cars.getStatuses();
            outputView.printRoundStatus(statuses);
        }
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }
}