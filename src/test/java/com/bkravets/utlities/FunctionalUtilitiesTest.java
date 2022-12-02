package com.bkravets.utlities;


import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.bkravets.utlities.FunctionalUtilities.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FunctionalUtilitiesTest {

    @Test
    void isPrime_shouldReturnTrueWhenPrime() {
        boolean isPrimeNumber = isPrime.test(5);

        assertThat(isPrimeNumber)
                .isTrue();
    }

    @Test
    void isPrime_shouldReturnFalseWhenNotPrime() {
        boolean isPrimeNumber = isPrime.test(1);

        assertThat(isPrimeNumber)
                .isFalse();
    }

    @Test
    void daySupplier_ShouldSupplyCurrentDay() {
        DayOfWeek dayOfWeek = daySupplier.get();

        DayOfWeek expected = LocalDate.now().getDayOfWeek();

        assertThat(dayOfWeek)
                .isEqualTo(expected);
    }

    @Test
    void roundDouble_shouldRoundDown() {
        Long roundNumber = roundDouble.apply(5.4);

        assertThat(roundNumber)
                .isEqualTo(5);
    }

    @Test
    void roundDouble_shouldRoundUp() {
        Long apply = roundDouble.apply(5.5);

        assertThat(apply)
                .isEqualTo(6);
    }

    @Test
    void fibonacci_shouldGetFibonacciNumber() {
        Integer number = fibonacci.apply(5);

        assertThat(number)
                .isEqualTo(3);
    }

    @Test
    void fibonacci_shouldThrowExceptionWhenLessThenOne() {
        assertThatThrownBy(() -> fibonacci.apply(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number cannot be less then one");
    }
}