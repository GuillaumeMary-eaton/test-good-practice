package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import java.util.Objects;
import java.util.Random;

public class DummyClass {

    public String myMethodToBeTested(String whoToHello) {
        return "Hello " + whoToHello;
    }

    public int methodWhichInvokesSomeBadCode() {
        return 10 * extractedBadCode();
    }

    protected int extractedBadCode() {
        return difficultMethodToTest();
    }

    private static int difficultMethodToTest() {
        return new Random().nextInt();
    }

    public LocalResult computeSomeResult(String value1, String value2, long value3) {
        LocalResult result = new LocalResult();
        result.setProp1(value1);
        result.setProp2(value2);
        result.setProp3(value3);
        return result;
    }

    public ComparableLocalResult computeSomeComparableResult(String value1, String value2, long value3) {
        ComparableLocalResult result = new ComparableLocalResult();
        result.setProp1(value1);
        result.setProp2(value2);
        result.setProp3(value3);
        return result;
    }

    /**
     * This class doesn't implement equals(..) so is hardly comparable.
     * It doesn't have a suitable toString() method either, or may have one but is usually not made for tests
     */
    public static class LocalResult {

        private String prop1;
        private String prop2;
        private long prop3;

        public String getProp1() {
            return prop1;
        }

        public void setProp1(String prop1) {
            this.prop1 = prop1;
        }

        public String getProp2() {
            return prop2;
        }

        public void setProp2(String prop2) {
            this.prop2 = prop2;
        }

        public long getProp3() {
            return prop3;
        }

        public void setProp3(long prop3) {
            this.prop3 = prop3;
        }
    }

    /**
     * This class do implement equals(..) so is comparable.
     * It does have a toString() method either but it is not suitable for tests
     */
    public static class ComparableLocalResult {

        private String prop1;
        private String prop2;
        private long prop3;

        public String getProp1() {
            return prop1;
        }

        public void setProp1(String prop1) {
            this.prop1 = prop1;
        }

        public String getProp2() {
            return prop2;
        }

        public void setProp2(String prop2) {
            this.prop2 = prop2;
        }

        public long getProp3() {
            return prop3;
        }

        public void setProp3(long prop3) {
            this.prop3 = prop3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ComparableLocalResult that = (ComparableLocalResult) o;
            return prop3 == that.prop3 && Objects.equals(prop1, that.prop1) && Objects.equals(prop2, that.prop2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(prop1, prop2, prop3);
        }

        @Override
        public String toString() {
            return "ComparableLocalResult{" +
                    "prop1='" + prop1 + '\'' +
                    ", prop2='" + prop2 + '\'' +
                    ", prop3=" + prop3 +
                    '}';
        }
    }
}
