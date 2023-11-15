package com.eaton.hug4bugs.testgoodpractice.badcodebase.model;

import java.util.function.Supplier;

public class CarBuilder implements Supplier<Car> {

    private final String description;

    public CarBuilder(String description) {
        this.description = description;
    }

    @Override
    public Car get() {
        Car result = new Car();
        result.setDescription(description);
        return result;
    }
}
