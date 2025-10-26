package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Car.CarStatus;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARKER = "-";

    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundStatus(List<CarStatus> statuses) {
        for (Car.CarStatus status : statuses) {
            String bars = POSITION_MARKER.repeat(status.position());
            System.out.println(status.name() + NAME_POSITION_SEPARATOR + bars);
        }
        System.out.println();
    }

    public void printWinners(List<String> winnersNames) {
        String result = String.join(WINNER_DELIMITER, winnersNames);
        System.out.println(WINNER_PREFIX + result);
    }
}