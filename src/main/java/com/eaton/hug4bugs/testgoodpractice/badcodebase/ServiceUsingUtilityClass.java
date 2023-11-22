package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import com.eaton.hug4bugs.testgoodpractice.badcodebase.utils.DummyStringUtils;

import java.util.List;

public class ServiceUsingUtilityClass {
    public List<String> doSomething(List<String> strings) {
        return strings.stream().map(DummyStringUtils::convertToUpperCase).toList();
    }
}
