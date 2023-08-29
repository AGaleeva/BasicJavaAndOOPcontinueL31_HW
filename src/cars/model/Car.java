package cars.model;

import java.util.Objects;

public class Car {
    private String regNumber;
    private String brand;
    private String model;
    private String color;
    private double engine;

    public Car(String regNumber, String brand, String model, String color, double engine) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getEngine() {
        return engine;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car: ");
        sb.append("the registration number is ").append(regNumber).append('\'');
        sb.append(", brand: ").append(brand).append('\'');
        sb.append(", model: ").append(model).append('\'');
        sb.append(", the color is '").append(color).append('\'');
        sb.append(", the motor is ").append(engine);
        sb.append(" l.");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, brand, model, color);
    }
}
