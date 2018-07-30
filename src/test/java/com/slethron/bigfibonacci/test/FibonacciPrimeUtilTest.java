package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.FibonacciPrimeUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static com.google.common.truth.Truth.assertWithMessage;

public class FibonacciPrimeUtilTest {
    private FibonacciPrimeUtil fibonacciPrimeUtil;
    
    @Before
    public void before() {
        fibonacciPrimeUtil = new FibonacciPrimeUtil();
    }
    
    @Test
    public void getFibonacciEntryPointForPrimeNumber17() {
        var prime = BigInteger.valueOf(17);
        var index = 9;
        
        var fep = fibonacciPrimeUtil.getFibonacciEntryPoint(prime);
        assertWithMessage("Returned Fibonacci Entry Point index differs from the expected index %s", index)
                .that(fep)
                .isEqualTo(index);
    }
    
    @Test
    public void getFibonacciEntryPointForPrimeNumber71() {
        var prime = BigInteger.valueOf(71);
        var index = 70;
        
        var fep = fibonacciPrimeUtil.getFibonacciEntryPoint(prime);
        assertWithMessage("Returned Fibonacci Entry Point index differs from the expected index %s", index)
                .that(fep)
                .isEqualTo(index);
    }
    
    @Test
    public void getFibonacciPrimesInRange0to100() {
        var lowerBound = 1;
        var upperBound = 100;
        
        var expectedPrimes = new BigInteger[] {
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(13),
                BigInteger.valueOf(89),
                BigInteger.valueOf(233),
                BigInteger.valueOf(1597),
                BigInteger.valueOf(28657),
                BigInteger.valueOf(514229),
                BigInteger.valueOf(433494437),
                new BigInteger("2971215073"),
                new BigInteger("99194853094755497")
        };
        
        var primes = fibonacciPrimeUtil.getFibonnaciPrimesInRange(lowerBound, upperBound);
        assertWithMessage("Primes returned differ from expected")
                .that(primes)
                .isEqualTo(expectedPrimes);
    }
    
    @Test(timeout = 5000)
    public void getPrimeFactorsOfVariousFibonacciNumbersUpToIndex100() {
        var index = 1;
        var factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEmpty();
        
        index = 10;
        var expectedFactors = new BigInteger[] {
                BigInteger.valueOf(5),
                BigInteger.valueOf(11)
        };
        factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEqualTo(expectedFactors);
        
        index = 23;
        expectedFactors = new BigInteger[] { BigInteger.valueOf(28657) };
        factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEqualTo(expectedFactors);
        
        index = 30;
        expectedFactors = new BigInteger[] {
                BigInteger.valueOf(2),
                BigInteger.valueOf(5),
                BigInteger.valueOf(11),
                BigInteger.valueOf(31),
                BigInteger.valueOf(61)
        };
        factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEqualTo(expectedFactors);
        
        index = 73;
        expectedFactors = new BigInteger[] {
                BigInteger.valueOf(9375829),
                BigInteger.valueOf(86020717)
        };
        factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEqualTo(expectedFactors);
        
        index = 100;
        expectedFactors = new BigInteger[] {
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(11),
                BigInteger.valueOf(41),
                BigInteger.valueOf(101),
                BigInteger.valueOf(151),
                BigInteger.valueOf(401),
                BigInteger.valueOf(3001),
                BigInteger.valueOf(570601)
        };
        factors = fibonacciPrimeUtil.getPrimeFactors(index);
        assertWithMessage("Factors returned for index %s differ from expected", index)
                .that(factors)
                .isEqualTo(expectedFactors);
    }
}
