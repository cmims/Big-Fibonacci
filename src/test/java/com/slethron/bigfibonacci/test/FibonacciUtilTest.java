package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.FibonacciUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciUtilTest {
    private FibonacciUtil fibUtil;
    
    @Before
    public void before() {
        fibUtil = new FibonacciUtil();
    }
    
    @Test
    public void getPrimesInRangeIsAccurate() {
        var lowerBound = 0;
        var upperBound = 10;
        
        new BigInteger("3");
        new BigInteger("5");
        new BigInteger("13");
        
        var primes = fibUtil.getPrimesInRange(lowerBound, upperBound);
        
        assertEquals(new BigInteger("2"), primes[0]);
        assertEquals(new BigInteger("3"), primes[1]);
        assertEquals(new BigInteger("5"), primes[2]);
        assertEquals(new BigInteger("13"), primes[3]);
    }
}
