package racingcar;

import racingcar.controller.GameController;
import racingcar.service.InputService;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputService inputService = new InputService();
        RacingGame racingGame = new RacingGame(inputService);

        GameController gameController = new GameController(inputView, outputView, racingGame);
        gameController.run();
    }
}
