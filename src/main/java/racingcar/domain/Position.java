package racingcar.domain;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private int value;

    public Position() {
        this.value = INITIAL_POSITION;
    }

    public void increase() {
        this.value++;
    }

    public int getValue() {
        return value;
    }

    public boolean isGreaterThan(Position other) {
        return this.value > other.value;
    }

    public boolean isSameAs(Position other) {
        return this.value == other.value;
    }
}