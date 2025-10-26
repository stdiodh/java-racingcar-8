package racingcar.domain;

public record TryCount(int value) {
    private static final int MIN_TRY_COUNT = 1;
    private static final String ERROR_INVALID_RANGE_MESSAGE = "[ERROR] 시도 횟수는 1 이상이어야 합니다.";

    public TryCount {
        validateRange(value);
    }

    private void validateRange(int number) {
        if (number < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE_MESSAGE);
        }
    }
}