package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.ZeckendorfConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertArrayEquals;

public class ZeckendorfConverterTest {
    private ZeckendorfConverter converter;
    
    @Before
    public void before() {
        converter = new ZeckendorfConverter();
    }
    
    @Test
    public void getZeckendorfRepresentationOf50() {
        var num = new BigInteger("50");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("34"),
                new BigInteger("13"),
                new BigInteger("3")
        };
        
        var components = converter.getZeckendorfRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getZeckendorfRepresentationOf100() {
        var num = new BigInteger("100");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("89"),
                new BigInteger("8"),
                new BigInteger("3")
        };
        
        var components = converter.getZeckendorfRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getZeckendorfRepresentationOf0() {
        var num = BigInteger.ZERO;
        
        var expectedComponents = new BigInteger[0];
        
        var components = converter.getZeckendorfRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOfNegative43() {
        var num = new BigInteger("-43");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("-55"),
                new BigInteger("13"),
                BigInteger.ONE.negate()
        };

        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);

        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getNegativelyIndexFibonacciRepresentationOfNegative11() {
        var num = new BigInteger("-11");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("-8"),
                new BigInteger("-3")
        };
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf12() {
        var num = new BigInteger("12");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("13"),
                BigInteger.ONE.negate()
        };
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf24() {
        var num = new BigInteger("24");
        
        var expectedComponents = new BigInteger[] {
                new BigInteger("34"),
                new BigInteger("-8"),
                new BigInteger("-3"),
                BigInteger.ONE
        };
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertArrayEquals("Representation differs from expected", expectedComponents, components);
    }
}
