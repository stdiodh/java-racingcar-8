package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;
    private static final int MOVE_THRESHOLD = 4;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public String getNameValue() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position.increase();
        }
    }

    public record CarStatus(String name, int position) {
    }

    public CarStatus getStatus() {
        return new CarStatus(name.getValue(), position.getValue());
    }
}