package com.eaton.hug4bugs.testgoodpractice.badcodebase.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    /**
     * Here is a demo of our builder usage : it's a fluent API that helps you to create your test input data
     */
    @Test
    void builderDemo() {
        // Given
        Person person = new PersonBuilder("John", "Do")
                .withBirthDay(LocalDate.of(2020, Month.APRIL, 3))
                .withVehicles(new CarBuilder("my car"), new BicycleBuilder("my bicycle"))
                .get();

        // When
        // No example here, but you can imagine that Person is an input for the service method to be tested

        // Then
        // here are some fake assertions just for another example of AssertJ assertions ;)
        assertThat(person.getFirstname()).isEqualTo("John");
        assertThat(person.getLastname()).isEqualTo("Do");
        assertThat(person.getVehicles()).extracting(Vehicle::getDescription).containsExactlyInAnyOrder("my car", "my bicycle");
    }

}