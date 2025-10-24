package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public GameController(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void run() {
        setupGame();
    }

    private void setupGame() {
        outputView.printCarNamePrompt();
        String rawName = inputView.readInput();
        outputView.printTryCountPrompt();
        String rawCount = inputView.readInput();

        racingGame.setupGame(rawName, rawCount);
    }
}
