package com.bkravets.utlities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.*;

public interface FunctionalUtilities {

    Predicate<Integer> isPrime = integer -> {
        if(integer <= 1) return false;

        for (int i = 2; i <= Math.sqrt(integer); i++) {
            if(integer % 2 == 0) {
                return false;
            }
        }

        return true;
    };

    Consumer<Integer> randomPrinter = bound -> System.out.println(new Random().nextInt(bound));

    Supplier<DayOfWeek> daySupplier = () -> LocalDate.now().getDayOfWeek();

    Function<Double, Long> roundDouble = Math::round;

    UnaryOperator<Integer> fibonacci = integer -> {
        if(integer <= 0) throw new IllegalArgumentException("Number cannot be less then one");

        int previous = 0;
        int current = 1;

        if(integer == 1) {
            return previous;
        }

        for (int i = 2; i < integer; i++) {
            int sum = previous + current;
            previous = current;
            current = sum;
        }
        return current;
    };
}
