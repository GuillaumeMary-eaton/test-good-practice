package com.eaton.hug4bugs.testgoodpractice.badcodebase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MockableServiceTest {

    @Test
    void doSomething_demoMockitoVerify() {
        // Given
        MockableService.ExternalService externalServiceMock = mock(MockableService.ExternalService.class);
        when(externalServiceMock.giveSomeValues(anyLong())).thenReturn(List.of("world", "everyone"));
        MockableService testInstance = new MockableService(externalServiceMock);
        // When
        List<String> strings = testInstance.doSomething(42);
        // Then
        assertThat(strings).containsExactly("Hello world", "Hello everyone");
        Mockito.verify(externalServiceMock).giveSomeValues(42);
    }

    @Test
    void doSomething_demoMockitoArgumentCaptor() {
        // Given
        MockableService.ExternalService externalServiceMock = mock(MockableService.ExternalService.class);
        // we create a tool that can pick up values on a given method
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        when(externalServiceMock.giveSomeValues(argumentCaptor.capture())).thenReturn(List.of("world", "everyone"));
        MockableService testInstance = new MockableService(externalServiceMock);
        // When
        List<String> strings = testInstance.doSomething(42);

        // Then
        assertThat(strings).containsExactly("Hello world", "Hello everyone");
        Mockito.verify(externalServiceMock).giveSomeValues(42);
        assertThat(argumentCaptor.getValue()).isEqualTo(42);
    }

}