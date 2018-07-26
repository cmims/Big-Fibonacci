package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FibonacciPrimeUtil {
    private static FibonacciSeries series;
    
    public FibonacciPrimeUtil() {
        series = FibonacciSeries.current();
    }
    
    /**
     * Get all Fibonacci numbers that are also prime for a given range of indexes
     * @return
     */
    public BigInteger[] getFibonnaciPrimesInRange(int lowerBound, int upperBound) {
        return IntStream.range(lowerBound, upperBound)
                .mapToObj(index -> series.get(index))
                .filter(fib -> fib.isProbablePrime(1))
                .toArray(BigInteger[]::new);
    }
    
    /**
     * Find the smallest Fibonacci number divisible by a given prime
     * @param prime
     * @return
     */
    public int getFibonacciEntryPoint(BigInteger prime) {
        if (!prime.isProbablePrime(1)) {
            throw new IllegalArgumentException("The number is not prime");
        }
        
        var index = 1;
        while (!series.get(index).mod(prime).equals(BigInteger.ZERO)) {
            index++;
        }
        
        return index;
    }
    
    /**
     * Find all the prime factors of the Fibonacci number at the given index
     * @param index
     * @return
     */
    public BigInteger[] getPrimeFactors(int index) {
        return Arrays.stream(getFactors(index))
                .filter(i -> i.isProbablePrime(1))
                .toArray(BigInteger[]::new);
    }
    
    private BigInteger[] getFactors(int index) {
        var factors = new ArrayList<BigInteger>();
        var fib = series.get(index);
        for (var i = BigInteger.ONE; i.compareTo(fib.sqrt()) <= 0; i = i.add(BigInteger.ONE)) {
            if (fib.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
            }
        }
        
        return factors.toArray(new BigInteger[0]);
    }
    
    public static void main(String[] args) {
        var fibonacciPrimeUtil = new FibonacciPrimeUtil();
        
        var primes = fibonacciPrimeUtil.getFibonnaciPrimesInRange(0, 100);
    
        System.out.print("[");
        for (var i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i != primes.length - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("]");
        
        var index = 7;
        
        var factors = fibonacciPrimeUtil.getPrimeFactors(index);
        
        System.out.println("\nPrime factors of fib(" + index + "): ");
        System.out.print("[");
        for (var i = 0; i < factors.length; i++) {
            System.out.print(factors[i]);
            if (i != factors.length - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("]");
    }
}
