package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.assertj.core.presentation.StandardRepresentation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DummyClassTest {

    /**
     * - use test method naming convention to quickly understand what's tested by the method (avoid "ok", "good", "alright")
     * - use "testInstance" keyword to name you tested instance, so you don't have to remember what's the name of your class.
     * In this example it has not so much interest, but when dealing with a test that has many services instances to build
     * your test data, it can be helpful.
     * - help yourself with given / when / then is your test method as too much code
     */
    @Test
    void myMethodToBeTested_worldAsArgument_saysHelloWorld() {
        // Given
        DummyClass testInstance = new DummyClass();
        // When
        assertThat(testInstance.myMethodToBeTested("world"))
                // Then
                .isEqualTo("Hello world");
    }


    /**
     * Use parameterized tests to test your method with many input data. Then you won't have the need to create a method
     * per test case.
     * You may be interested in @{@link org.junit.jupiter.params.provider.CsvFileSource}, {@link org.junit.jupiter.params.provider.CsvFileSource}
     */
    static Object[][] myMethodToBeTested() {
        return new Object[][]{
                { "world", "Hello world" },
                { "Montbonnot", "Hello Montbonnot" },
                { "everyone", "Hello everyone" }
        };
    }

    @ParameterizedTest
    @MethodSource
    void myMethodToBeTested(String input, String expectation) {
        DummyClass testInstance = new DummyClass();
        assertThat(testInstance.myMethodToBeTested(input)).isEqualTo(expectation);
    }

    /**
     * Organize your test by using nested test cases.
     * It let you isolate some context, and let you focus on some part of your method. You may prefer to export this
     * as un external class too ;)
     */
    @Nested
    class MyUseCase {

        /**
         * You might share instance if your test cases are homogenous. Else don't do it: here 4 is hardcoded for your
         * test case.
         */
        private final DummyClass testInstance = new DummyClass() {

            @Override
            protected int extractedBadCode() {
                return 4;
            }
        };

        @Test
        void methodWhichInvokesSomeBadCode_useCase4_returns40() {
            assertThat(testInstance.methodWhichInvokesSomeBadCode()).isEqualTo(40);
        }
    }

    /**
     * Comparing Objects with AssertJ
     */
    @Test
    void computeSomeResult() {
        DummyClass testInstance = new DummyClass();
        DummyClass.LocalResult result = testInstance.computeSomeResult("x", "y", 42);
        DummyClass.LocalResult expected = new DummyClass.LocalResult();
        expected.setProp1("a");
        expected.setProp2("b");
        expected.setProp3(42);
        // By default (no Representation given), since LocalResult doesn't override toString() you'll end up with some
        // useless message such as
        //        Expecting actual:
        //        com.eaton.hug4bugs.testgoodpractice.badcodebase.DummyClass$LocalResult@6fe7aac8
        //        to be equal to:
        //        com.eaton.hug4bugs.testgoodpractice.badcodebase.DummyClass$LocalResult@1d119efb
        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    /**
     * Comparing Objects with AssertJ
     */
    @Test
    void computeSomeComparableResult() {
        DummyClass testInstance = new DummyClass();
        DummyClass.LocalResult result = testInstance.computeSomeResult("x", "y", 42);
        DummyClass.LocalResult expected = new DummyClass.LocalResult();
        expected.setProp1("a");
        expected.setProp2("b");
        expected.setProp3(42);
        assertThat(result)
                // Without setting a Representation, AssertJ will use toString() which is not so easy to read
                // By using a "JSON-like" representation it's easier to understand what's wrong with Intellij "click to see difference" feature
                .withRepresentation(new StandardRepresentation() {
                    @Override
                    public String fallbackToStringOf(Object object) {
                        RecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
                        return new ReflectionToStringBuilder(object, style).toString();
                    }
                }).isEqualTo(expected);
    }
}