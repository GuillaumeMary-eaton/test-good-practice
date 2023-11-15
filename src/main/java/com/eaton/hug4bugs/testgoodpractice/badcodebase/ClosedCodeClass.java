package com.eaton.hug4bugs.testgoodpractice.badcodebase;

/**
 * Here is a dummy class that doesn't want to share a lot with external component.
 * Testing such a class can be tricky in that current state. You'll have to make it more open to add some tests,
 * obviously your code will be less protected from outside usage, no choice here.
 * @see ClosedCodeClassEnhanced
 */
public class ClosedCodeClass {

    private final AClassThatDoesSomething aClassThatDoesSomething;

    public ClosedCodeClass(int value) {
        this.aClassThatDoesSomething = new AClassThatDoesSomething(value);
        this.aClassThatDoesSomething.transformValueOrCallExternalService();
    }

    private void doSomething() {
        System.out.println(this.aClassThatDoesSomething.getProp1() + returnSomething().toLowerCase());
    }

    private String returnSomething() {
        return "dummy string";
    }

    private class AClassThatDoesSomething {

        private int prop1;

        private AClassThatDoesSomething(int prop1) {
            this.prop1 = prop1;
        }

        public int getProp1() {
            return prop1;
        }

        private void transformValueOrCallExternalService() {
            this.prop1 = this.prop1 * 42;
        }
    }
}
