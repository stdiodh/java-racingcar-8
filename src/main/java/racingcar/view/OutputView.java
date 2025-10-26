package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Car.CarStatus;

public class OutputView {
    private static final String SEPARATOR = " : ";
    private static final String POSITION_BAR = "-";
    private static final String RESULT_MESSAGE = "\n실행 결과";

    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundStatus(List<CarStatus> statuses) {
        for (Car.CarStatus status : statuses) {
            String bars = POSITION_BAR.repeat(status.position());
            System.out.println(status.name() + SEPARATOR + bars);
        }
        System.out.println();
    }

    public void printWinners(List<String> winnersNames) {
        String result = String.join(WINNER_DELIMITER, winnersNames);
        System.out.println(WINNER_PREFIX + result);
    }
}