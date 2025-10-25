package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Car.CarStatus;

public class OutputView {
    private static final String SEPARATOR = " : ";
    private static final String POSITION_BAR = "-";
    private static final String RESULT_MESSAGE = "\n실행 결과";

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
}
