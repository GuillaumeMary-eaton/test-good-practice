package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import com.eaton.hug4bugs.testgoodpractice.badcodebase.utils.DummyStringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class ServiceUsingUtilityClassTest {

    @Test
    void doSomething_demoStaticMock() {
        // Given
        ServiceUsingUtilityClass serviceUsingUtilityClass = new ServiceUsingUtilityClass();
        try (MockedStatic<DummyStringUtils> dummyStringUtilsMock = mockStatic(DummyStringUtils.class)) {
            dummyStringUtilsMock.when(() -> DummyStringUtils.convertToUpperCase(anyString())).thenReturn("TOTO");
            // When
            List<String> result = serviceUsingUtilityClass.doSomething(List.of("Hello", "world", "!"));
            // Then
            result.forEach(r -> assertEquals("TOTO", r));
            dummyStringUtilsMock.verify(() -> DummyStringUtils.convertToUpperCase(anyString()), times(3));
        }
    }
}