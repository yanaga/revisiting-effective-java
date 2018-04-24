package com.redhat.developers;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class StrategyBusinessLogic {

    private final IntUnaryOperator operator;

    private StrategyBusinessLogic(IntUnaryOperator operator) {
        this.operator = operator;
    }

    public static StrategyBusinessLogic of(IntUnaryOperator operator) {
        Objects.requireNonNull(operator);
        return new StrategyBusinessLogic(operator);
    }

    public void compute() {
        System.out.println("x");
        System.out.println("y");
        System.out.println("z");
        operator.applyAsInt(5);
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
    }

    public static void main(String[] args) {
        StrategyBusinessLogic.of(i -> i / 2);
        StrategyBusinessLogic.of(i -> i * 4);
        StrategyBusinessLogic.of(i -> i * 2);
        StrategyBusinessLogic.of(StrategyBusinessLogic::test);

        new TemplateBusinessLogic() {
            @Override
            protected void doSomething() {
                System.out.println("a");
            }
        }.doSomething();
    }

    public static int test(int i) {
        try {
            return i / 0;
        } catch (Exception ex) {
            return 0;
        }
    }
}
