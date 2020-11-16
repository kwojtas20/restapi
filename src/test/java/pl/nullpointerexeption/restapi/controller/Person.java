package pl.nullpointerexeption.restapi.controller;

import pl.nullpointerexeption.restapi.Car;

import java.util.List;

public class Person {
    private String name;
    private List<Car> cars;

    public Person(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }
}
