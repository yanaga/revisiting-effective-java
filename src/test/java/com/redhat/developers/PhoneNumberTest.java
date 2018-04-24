package com.redhat.developers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void testReflexive() {
        PhoneNumber p1 = PhoneNumber.of(123, 1234);
        assertTrue(p1.equals(p1));
    }

    @Test
    public void testSymmetrical() {
        PhoneNumber x = PhoneNumber.of(123, 1234);
        PhoneNumber y = PhoneNumber.of(123, 1234);
        assertTrue(x.equals(y));
        assertTrue(y.equals(x));
    }

    @Test
    public void testTransitive() {
        PhoneNumber x = PhoneNumber.of(123, 1234);
        PhoneNumber y = PhoneNumber.of(123, 1234);
        PhoneNumber z = PhoneNumber.of(123, 1234);
        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertTrue(x.equals(z));
    }

    @Test
    public void testConsistent() {
        PhoneNumber x = PhoneNumber.of(123, 1234);
        PhoneNumber y = PhoneNumber.of(123, 1234);
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
    }

    @Test
    public void testNonNullity() {
        PhoneNumber x = PhoneNumber.of(123, 1234);
        assertFalse(x.equals(null));
    }

}