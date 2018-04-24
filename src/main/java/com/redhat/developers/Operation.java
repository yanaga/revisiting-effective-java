package com.redhat.developers;

import me.yanaga.guava.stream.MoreCollectors;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    ADD(Addition::add, "A"),
    SUBTRACT((x, y) -> x - y, "S"),
    MULTIPLY ((x, y) -> x * y, "M"),
    DIVIDE((x, y) -> x /y, "D");

    private static final Map<String, Operation> VALUE_MAP = Stream.of(values())
            .collect(MoreCollectors.toImmutableMap(o -> o.databaseValue, o -> o));

    private final IntBinaryOperator operator;

    private final String databaseValue;

    Operation(IntBinaryOperator operator, String databaseValue) {
        this.operator = operator;
        this.databaseValue = databaseValue;
    }

    public static Optional<Operation> fromString(String databaseValue) {
        return Optional.ofNullable(VALUE_MAP.get(databaseValue));
    }

    public String toDatabaseValue() {
        return databaseValue;
    }

}
