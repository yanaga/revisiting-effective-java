package com.redhat.developers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static final String[] strings =
            { "a", "7", "4", "z", "T", "c", "10", "h", "2" };

    public static String createSomething() {
        return "abc";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Stream.iterate(0, i -> i + 2);
        Optional<Integer> reduce = Stream.of(1, 2, 3, 4)
                .reduce((x, y) -> x + y);
        reduce.orElseGet(() -> 5 * 5);
        reduce.orElseThrow(() -> new IllegalStateException("blabla"));

        Stream.of(strings)
                .map(s -> s)
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .forEach(System.out::println);

        var a = new VeryLongBusinessClassNameWithLotsOfOperations();
        Stream.iterate(0, i -> i + 1)
                .forEach(a::veryLongMethodThatCreatesAFactoryBasedOnInteger);
    }

}
