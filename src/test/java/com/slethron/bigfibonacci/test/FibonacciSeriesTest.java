package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.FibonacciSeries;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciSeriesTest {
    private FibonacciSeries fibonacciSeries;
    
    @Before
    public void before() {
        fibonacciSeries = new FibonacciSeries();
    }

    @Test
    public void getNthFibReturnsFofN() {
        assertEquals(BigInteger.ZERO, fibonacciSeries.get(0));
        assertEquals(BigInteger.ONE, fibonacciSeries.get(1));
        assertEquals(BigInteger.ONE, fibonacciSeries.get(2));
        assertEquals(BigInteger.TWO, fibonacciSeries.get(3));
        assertEquals(new BigInteger("3"), fibonacciSeries.get(4));
        assertEquals(new BigInteger("5"), fibonacciSeries.get(5));
        assertEquals(new BigInteger("8"), fibonacciSeries.get(6));
        assertEquals(new BigInteger("13"), fibonacciSeries.get(7));
        assertEquals(new BigInteger("21"), fibonacciSeries.get(8));
        assertEquals(new BigInteger("34"), fibonacciSeries.get(9));
        assertEquals(new BigInteger("55"), fibonacciSeries.get(10));
        //...
        assertEquals(new BigInteger("6765"), fibonacciSeries.get(20));
    }
    
    @Test
    public void getNthFibRecursivelyReturnsFofN() {
        assertEquals(BigInteger.ZERO, FibonacciSeries.getRecursively(0));
        assertEquals(BigInteger.ONE, FibonacciSeries.getRecursively(1));
        assertEquals(BigInteger.ONE, FibonacciSeries.getRecursively(2));
        assertEquals(BigInteger.TWO, FibonacciSeries.getRecursively(3));
        assertEquals(new BigInteger("3"), FibonacciSeries.getRecursively(4));
        assertEquals(new BigInteger("5"), FibonacciSeries.getRecursively(5));
        assertEquals(new BigInteger("8"), FibonacciSeries.getRecursively(6));
        assertEquals(new BigInteger("13"), FibonacciSeries.getRecursively(7));
        assertEquals(new BigInteger("21"), FibonacciSeries.getRecursively(8));
        assertEquals(new BigInteger("34"), FibonacciSeries.getRecursively(9));
        assertEquals(new BigInteger("55"), FibonacciSeries.getRecursively(10));
        //...
        assertEquals(new BigInteger("6765"), FibonacciSeries.getRecursively(20));
    }
    
    @Test
    public void getZerothTenFibonacciNumbers() {
        int lowerBound = 0;
        int upperBound = 10;
        var fibs = fibonacciSeries.get(lowerBound, upperBound);
        
        assertEquals(BigInteger.ZERO, fibs[0]);
        assertEquals(BigInteger.ONE, fibs[1]);
        assertEquals(BigInteger.ONE, fibs[2]);
        assertEquals(BigInteger.TWO, fibs[3]);
        assertEquals(new BigInteger("3"), fibs[4]);
        assertEquals(new BigInteger("5"), fibs[5]);
        assertEquals(new BigInteger("8"), fibs[6]);
        assertEquals(new BigInteger("13"), fibs[7]);
        assertEquals(new BigInteger("21"), fibs[8]);
        assertEquals(new BigInteger("34"), fibs[9]);
    }
}
