package cars.dao;

import cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

   public GarageImpl(int capacity) {
       cars = new Car[capacity];
   }

    @Override
    public boolean addCar(Car car) {
        if (car == null || cars.length == size || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) { // regNumber.equals(cars[i].getRegNumber())
                Car removed = cars[i];
                cars[i] = cars[size - 1];
                cars[size - 1] = null;
                size--;
                return removed;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        Predicate<Car> predicate = c -> model.equals(c.getModel());
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByBrand(String brand) {
        Predicate<Car> predicate = c -> brand.equals(c.getBrand());
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByEngine(double minEngine, double maxEngine) {
        Predicate<Car> predicate = c -> c.getEngine() >= minEngine && c.getEngine() < maxEngine;
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        Predicate<Car> predicate = c -> color.equals(c.getColor());
        return findCarsByPredicate(predicate);
    }

    public Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(cars[i])) {
                res[j] = cars[i];
                j++;
            }
        }
        return res;
    }
}


