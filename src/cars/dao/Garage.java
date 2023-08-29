package cars.dao;

import cars.model.Car;

public interface Garage {
    boolean addCar(Car car);
    Car removeCar(String regNumber);
    Car findCarByRegNumber(String regNumber);
    Car[] findCarsByModel(String model);
    Car[] findCarsByBrand(String brand);
    Car[] findCarsByEngine(double minEngine, double maxEngine);
    Car[] findCarsByColor(String color);
}
