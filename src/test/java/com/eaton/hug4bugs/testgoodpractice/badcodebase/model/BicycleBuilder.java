package com.eaton.hug4bugs.testgoodpractice.badcodebase.model;

import java.util.function.Supplier;

public class BicycleBuilder implements Supplier<Bicycle> {

    private final String description;

    public BicycleBuilder(String description) {
        this.description = description;
    }

    @Override
    public Bicycle get() {
        Bicycle result = new Bicycle();
        result.setDescription(description);
        return result;
    }
}
