package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.ZeckendorfConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZeckendorfConverterTest {
    private ZeckendorfConverter converter;
    
    @Before
    public void before() {
        converter = new ZeckendorfConverter();
    }
    
    @Test
    public void getZeckendorfRepresentationOf50() {
        var num = new BigInteger("50");
        var component0 = new BigInteger("34");
        var component1 = new BigInteger("13");
        var component2 = new BigInteger("3");
        
        var components = converter.getZeckendorfRepresentation(num);
        
        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
        assertEquals(component2, components[2]);
    }
    
    @Test
    public void getZeckendorfRepresentationOf100() {
        var num = new BigInteger("100");
        var component0 = new BigInteger("89");
        var component1 = new BigInteger("8");
        var component2 = new BigInteger("3");
        
        var components = converter.getZeckendorfRepresentation(num);
        
        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
        assertEquals(component2, components[2]);
    }
    
    @Test
    public void getZeckendorfRepresentationOf0() {
        var num = BigInteger.ZERO;
        var components = converter.getZeckendorfRepresentation(num);
        assertNotNull(components);
        assertEquals(0, components.length);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOfNegative43() {
        var num = new BigInteger("-43");
        var component0 = new BigInteger("-55");
        var component1 = new BigInteger("13");
        var component2 = BigInteger.ONE.negate();

        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);

        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
        assertEquals(component2, components[2]);
    }
    
    @Test
    public void getNegativelyIndexFibonacciRepresentationOfNegative11() {
        var num = new BigInteger("-11");
        var component0 = new BigInteger("-8");
        var component1 = new BigInteger("-3");
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf12() {
        var num = new BigInteger("12");
        var component0 = new BigInteger("13");
        var component1 = BigInteger.ONE.negate();
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
    }
    
    @Test
    public void getNegativelyIndexedFibonacciRepresentationOf24() {
        var num = new BigInteger("24");
        var component0 = new BigInteger("34");
        var component1 = new BigInteger("-8");
        var component2 = new BigInteger("-3");
        var component3 = BigInteger.ONE;
        
        var components = converter.getNegativelyIndexedFibonacciRepresentation(num);
        
        assertEquals(component0, components[0]);
        assertEquals(component1, components[1]);
        assertEquals(component2, components[2]);
        assertEquals(component3, components[3]);
    }
}
