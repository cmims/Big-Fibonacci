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
    public void getZeckendorfRepresentationOf50() {
        var num = BigInteger.valueOf(50);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(34),
                BigInteger.valueOf(13),
                BigInteger.valueOf(3)
        };
        var components = converter.getZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void getZeckendorfRepresentationOf100() {
        var num = BigInteger.valueOf(100);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(89),
                BigInteger.valueOf(8),
                BigInteger.valueOf(3)
        };
        var components = converter.getZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void getZeckendorfRepresentationOf0() {
        var num = BigInteger.ZERO;
        var components = converter.getZeckendorfRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEmpty();
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOfNegative43() {
        var num = BigInteger.valueOf(-43);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(-55),
                BigInteger.valueOf(13),
                BigInteger.ONE.negate()
        };
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
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
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf12() {
        var num = BigInteger.valueOf(12);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(13),
                BigInteger.ONE.negate()
        };
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf24() {
        var num = BigInteger.valueOf(24);
        var expectedComponents = new BigInteger[] {
                BigInteger.valueOf(34),
                BigInteger.valueOf(-8),
                BigInteger.valueOf(-3),
                BigInteger.ONE
        };
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        assertWithMessage("Representation differs from expected")
                .that(components)
                .isEqualTo(expectedComponents);
    }
}
