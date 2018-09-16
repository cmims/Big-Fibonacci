package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.ZeckendorfConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static com.google.common.truth.Truth.assertWithMessage;

public class ZeckendorfConverterTest {
    private ZeckendorfConverter converter;
    
    @Before
    public void before() {
        converter = new ZeckendorfConverter();
    }
    
    @Test
    public void findZeckendorfRepresentationOf50() {
        var num = BigInteger.valueOf(50);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(34),
                BigInteger.valueOf(13),
                BigInteger.valueOf(3)
        };
        var components = converter.findZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void findZeckendorfRepresentationOf100() {
        var num = BigInteger.valueOf(100);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(89),
                BigInteger.valueOf(8),
                BigInteger.valueOf(3)
        };
        var components = converter.findZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void findZeckendorfRepresentationOf0() {
        var num = BigInteger.ZERO;
        var components = converter.findZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEmpty();
    }
    
    @Test
    public void findNegativelyIndexedFibonacciRepresentationOfNegative43() {
        var num = BigInteger.valueOf(-43);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(-55),
                BigInteger.valueOf(13),
                BigInteger.ONE.negate()
        };
        var components = converter.findNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void getNegativelyIndexFibonacciRepresentationOfNegative11() {
        var num = BigInteger.valueOf(-11);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(-8),
                BigInteger.valueOf(-3)
        };
        var components = converter.findNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void findNegativelyIndexedFibonacciRepresentationOf12() {
        var num = BigInteger.valueOf(12);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(13),
                BigInteger.ONE.negate()
        };
        var components = converter.findNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void findNegativelyIndexedFibonacciRepresentationOf24() {
        var num = BigInteger.valueOf(24);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(34),
                BigInteger.valueOf(-8),
                BigInteger.valueOf(-3),
                BigInteger.ONE
        };
        var components = converter.findNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
}
