package racingcar.domain;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;
    private static final String ERROR_INVALID_RANGE_MESSAGE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    private final int value;

    public TryCount(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int number) {
        if (number < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}