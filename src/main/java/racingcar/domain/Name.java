package racingcar.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_NULL_VALUE_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    private static final String ERROR_OVER_LENGTH_MESSAGE = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.";

    private final String value;

    public Name(String value) {
        validateNullValue(value);
        validateOverLength(value);
        this.value = value;
    }

    private void validateNullValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL_VALUE_MESSAGE);
        }
    }

    private void validateOverLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_LENGTH_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}