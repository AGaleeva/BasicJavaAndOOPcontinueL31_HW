package cars.test;

import cars.dao.Garage;
import cars.dao.GarageImpl;
import cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(7);
        cars = new Car[6];
        cars[0] = new Car("631-XXA", "Lexus", "LC cabrio", "augbergine", 5.0);
        cars[1] = new Car("632-XXB", "Lexus", "LS", "augbergine", 4.6);
        cars[2] = new Car("633-XXC", "Mercedes-Maybach", "GLS", "black", 3.98);
        cars[3] = new Car("634-XXD", "Mercedes-Maybach", "S-Class", "white", 3.98);
        cars[4] = new Car("635-XXE", "Porsche", "Panamera 4S", "cooper rubin metallic", 2.9);
        cars[5] = new Car("636-XXF", "Porsche", "Cayenne S Coupé", "white", 3.996);
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[0]));
        Car car = new Car("640-XXG", "BMW", "X5", "white", 5.4);
        assertTrue(garage.addCar(car));
        car = new Car("645-XXG", "BMW", "X5", "white", 5.4);
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        Car car = garage.removeCar("636-XXF");
        assertEquals(cars[5], car);
        assertNull(garage.removeCar("636-XXF"));
    }

    @Test
    void findCarByRegNumber() {
        assertNotNull(garage.findCarByRegNumber("632-XXB"));
        Car car = garage.findCarByRegNumber("632-XXB");
        assertEquals(cars[1], car);
        assertNull(garage.findCarByRegNumber("690-XXB"));
    }

    @Test
    void findCarsByModel() {
        Car[] actual = garage.findCarsByModel("LC cabrio");
        Car[] expected = {cars[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByBrand() {
        Car[] actual = garage.findCarsByBrand("Mercedes-Maybach");
        Car[] expected = {cars[2], cars[3]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] actual = garage.findCarsByEngine(2.9, 3.99);
        Car[] expected = {cars[2], cars[3], cars[4]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findCarsByColor() {
        Car[] actual = garage.findCarsByColor("white");
        Car[] expected = {cars[3], cars[5]};
        assertArrayEquals(expected, actual);
    }
}