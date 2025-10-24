package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public String getNameValue() {
        return name.getValue();
    }
}