package com.eaton.hug4bugs.testgoodpractice.badcodebase;

public class ClosedCodeClassEnhanced {

    private final AClassThatDoesSomething aClassThatDoesSomething;

    public ClosedCodeClassEnhanced(int value) {
        this.aClassThatDoesSomething = init(value);
    }

    /**
     * By extracting initializing method, but letting it as package-protected you'll be able to override the class in test
     * and provide some stubbing code.
     * Moreover, the <code>@VisibleForTesting</code> annotation is an indicator to other developers that this method is
     * exposed only for testing purpose.
     */
    @VisibleForTesting
    AClassThatDoesSomething init(int value) {
        AClassThatDoesSomething aClassThatDoesSomething = new AClassThatDoesSomething(value);
        aClassThatDoesSomething.transformValueOrCallExternalService();
        return aClassThatDoesSomething;
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
