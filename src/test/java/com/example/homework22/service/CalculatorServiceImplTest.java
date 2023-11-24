package com.example.homework22.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class CalculatorServiceImplTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    static Stream<Arguments> provideParamsForPlusTests() {
        return Stream.of(
                Arguments.of(5, 5, "5 + 5 = 10"),
                Arguments.of(10, 5, "10 + 5 = 15"),
                Arguments.of(10, 10, "10 + 10 = 20")
        );
    }

    static Stream<Arguments> provideParamsForMinusTests() {
        return Stream.of(
                Arguments.of(5, 5, "5 - 5 = 0"),
                Arguments.of(10, 5, "10 - 5 = 5"),
                Arguments.of(10, 10, "10 - 10 = 0")
        );
    }

    static Stream<Arguments> provideParamsForMultiplyTests() {
        return Stream.of(
                Arguments.of(5, 5, "5 * 5 = 25"),
                Arguments.of(10, 5, "10 * 5 = 50"),
                Arguments.of(10, 10, "10 * 10 = 100")
        );
    }

    static Stream<Arguments> provideParamsForDivideTests() {
        return Stream.of(
                Arguments.of(5, 5, "5 / 5 = 1"),
                Arguments.of(10, 5, "10 / 5 = 2"),
                Arguments.of(10, 10, "10 / 10 = 1")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTests")
    public void shouldPlusCorrectly(int num1, int num2, String expected) {
        String result = out.plus(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTests")
    public void shouldMinusCorrectly(int num1, int num2, String expected) {
        String result = out.minus(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTests")
    public void shouldMultiplyCorrectly(int num1, int num2, String expected) {
        String result = out.multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTests")
    public void shouldDivideCorrectly(int num1, int num2, String expected) {
        String result = out.divide(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(10, 0));
    }
}