package com.redhat.developers;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public class PhoneNumber implements Formattable, Comparable<PhoneNumber> {

    private static final PhoneNumber COMMON = new PhoneNumber(123, 1234);

    private final int areaCode;

    private final int number;

    private int hashCode;

    private PhoneNumber(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public static PhoneNumber of(int areaCode, int number) {
        checkArgument(areaCode > 100);
        checkArgument(number > 1000);
        if (areaCode == 123 && number == 1234) {
            return COMMON;
        }
        return new PhoneNumber(areaCode, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof PhoneNumber) {
            PhoneNumber other = (PhoneNumber) obj;
            return Objects.equals(this.areaCode, other.areaCode) && this.number == other.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(this.areaCode, this.number);
        }
        this.hashCode = result;
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("areaCode", areaCode)
                .add("number", number)
                .toString();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d-%d", areaCode, number);
    }

    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber p) -> p.areaCode)
            .thenComparingInt(p -> p.number);

    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
    }

}
