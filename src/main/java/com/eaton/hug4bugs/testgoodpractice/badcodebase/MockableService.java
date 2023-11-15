package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import java.util.List;
import java.util.stream.Collectors;

public class MockableService {

    private final ExternalService externalService;

    public MockableService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public List<String> doSomething(long arg) {
        List<String> strings = externalService.giveSomeValues(arg);
        return strings.stream().map(s -> "Hello " + s).collect(Collectors.toList());
    }

    /* This interface should be outside this class, they are here only to avoid exposing it in package which may
     * confuse people while they first arrive in this repo.
     */
    public interface ExternalService {

        List<String> giveSomeValues(long arg);
    }
}
