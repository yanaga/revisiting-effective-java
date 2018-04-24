package com.redhat.developers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MethodReferences {

    static Function<Integer, Integer> f1 = MethodReferences::addOne;
    static Function<Integer, Integer> f2 = f -> f + 2;

    public static void main(String[] args) {
        System.out.println(f1.andThen(f2).apply(5));
        st(Integer::parseInt);
        bound(instant -> getNOW().isAfter(instant));
        bound(getNOW()::isAfter);
        bound(instant -> Instant.now().isAfter(instant));
        bound(Instant.now()::isAfter);
        unbound(String::toLowerCase);
        constructor(TreeMap::new);
        array(int[]::new);
    }

    public static Integer addOne(Integer integer) {
        return integer + 1;
    }

    private static final Instant NOW = Instant.now();

    public static Instant getNOW() {
        return NOW;
    }

    public static void st(Function<String, Integer> function) {
    }

    public static void bound(Predicate<Instant> predicate) {
    }

    public static void unbound(UnaryOperator<String> operator) {
    }

    public static void constructor(Supplier<TreeMap<String, String>> supplier) {
    }

    public static void array(Function<Integer, int[]> function) {
    }

}
