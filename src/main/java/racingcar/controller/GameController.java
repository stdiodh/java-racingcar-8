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
        playGame();
    }

    private void setupGame() {
        String rawName = inputView.readCarNames();
        String rawCount = inputView.readTryCount();

        racingGame.setupGame(rawName, rawCount);
    }

    private void playGame() {
        racingGame.playRace(outputView);
    }
}
