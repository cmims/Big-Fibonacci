package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Methods pertaining to calculations about Fibonacci numbers and prime numbers
 */
public class FibonacciPrimeUtil {
    private static FibonacciSeries series;
    
    public FibonacciPrimeUtil() {
        series = FibonacciSeries.current();
    }
    
    /**
     * Get all Fibonacci numbers that are also prime for a given range of indices
     * @param lowerBound Lower bound index (inclusive)
     * @param upperBound Upper bound index (exclusive)
     * @return Array of Fibonacci primes numbers in ascending order
     */
    public BigInteger[] getFibonnaciPrimesInRange(int lowerBound, int upperBound) {
        if (lowerBound <= 0 || upperBound <= 0) {
            throw new IllegalArgumentException("Lower bound and upper bound must be positive");
        } else if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound");
        }
        return IntStream.range(lowerBound, upperBound)
                .mapToObj(index -> series.get(index))
                .filter(fib -> fib.isProbablePrime(1))
                .toArray(BigInteger[]::new);
    }
    
    /**
     * Find the smallest Fibonacci number divisible by a given prime
     * @param prime Prime number by which the Fibonacci number is divided
     * @return Index of the Fibonacci number in the sequence
     */
    public int getFibonacciEntryPoint(BigInteger prime) {
        if (prime.signum() <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        } else if (!prime.isProbablePrime(1)) {
            throw new IllegalArgumentException("Number must be prime");
        }
        
        var index = 1;
        while (!series.get(index).mod(prime).equals(BigInteger.ZERO)) {
            index++;
        }
        
        return index;
    }
    
    /**
     * Find all the prime factors of the Fibonacci number at the given index
     * @param index Index of the Fibonacci number being factorized
     * @return Array of prime factors in ascending order
     */
    public BigInteger[] getPrimeFactors(int index) {
        var primeFactors = new HashSet<BigInteger>();
        var fib = series.get(index);
        
        for (var i = BigInteger.TWO; i.compareTo(fib.divide(i)) <= 0; i = i.add(BigInteger.ONE)) {
            while (fib.mod(i).longValue() == 0) {
                primeFactors.add(i);
                fib = fib.divide(i);
            }
        }
        
        if (fib.compareTo(BigInteger.ONE) > 0) {
            primeFactors.add(fib);
        }
        
        return primeFactors.stream().sorted().toArray(BigInteger[]::new);
    }
    
    public static void main(String[] args) {
        var fibonacciPrimeUtil = new FibonacciPrimeUtil();
        
        var primes = fibonacciPrimeUtil.getFibonnaciPrimesInRange(1, 100);
        
        System.out.print("[");
        for (var i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i != primes.length - 1) {
                System.out.println(", ");
            }
        }
        System.out.println("]");
        
        var index = 100;
        
        var factors = fibonacciPrimeUtil.getPrimeFactors(index);
        
        System.out.println("\nPrime factors of fib(" + index + "): " + series.get(index));
        System.out.print("[");
        for (var i = 0; i < factors.length; i++) {
            System.out.print(factors[i]);
            if (i != factors.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
