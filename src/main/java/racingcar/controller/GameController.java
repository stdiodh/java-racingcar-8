package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        setupGame();
    }

    private void setupGame() {
        outputView.printCarNamePrompt();
        String rawName = inputView.readInput();
        outputView.printTryCountPrompt();
        String rawCount = inputView.readInput();
    }
}
