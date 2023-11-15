package com.eaton.hug4bugs.testgoodpractice.badcodebase.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class implements a sort of Builder pattern to ease the creation of {@link Person} bean :
 * - it creates a fluent API to let one chains setters (called "withers" here)
 * - it opens the {@link Person} API by letting you pass some for useful method argument when initial API is not well
 * designed, see {@link #withBirthDay(LocalDate)}
 */
public class PersonBuilder implements Supplier<Person> {

    private String firstname;

    private String lastname;

    private Date birthDay;

    private Supplier<Set<Vehicle>> vehicles;

    PersonBuilder(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    PersonBuilder withBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    /**
     * Same as {@link #withBirthDay(Date)} with a better-typed argument that suits better expected feature (birthday rarely
     * need time) and let one use {@link LocalDate#of(int, Month, int)} which is more readable
     * @param birthDay
     * @return
     */
    PersonBuilder withBirthDay(LocalDate birthDay) {
        this.birthDay = Date.from(birthDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return this;
    }

    /**
     * Don't hesitate to create a fluent method to set related beans, also made with a Builder pattern.
     * @param vehicles
     * @return
     */
    PersonBuilder withVehicles(Supplier<? extends Vehicle>... vehicles) {
        this.vehicles = () -> Stream.of(vehicles).map(Supplier::get).collect(Collectors.toSet());
        return this;
    }

    /**
     * Don't hesitate to create a fluent method to set related beans, also made with a Builder pattern.
     * @param vehicles
     * @return
     */
    PersonBuilder withVehicles(Supplier<? extends Set<Vehicle>> vehicles) {
        this.vehicles = (Supplier<Set<Vehicle>>) vehicles;
        return this;
    }

    @Override
    public Person get() {
        Person result = new Person(firstname, lastname);
        result.setBirthDay(birthDay);
        if (this.vehicles != null) {
            result.setVehicles(this.vehicles.get());
        }
        return result;
    }
}
