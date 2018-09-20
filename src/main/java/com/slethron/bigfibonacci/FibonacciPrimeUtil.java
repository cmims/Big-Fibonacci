package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.*;

/**
 * Methods pertaining to calculations about Fibonacci numbers and prime numbers
 */
public class FibonacciPrimeUtil {
    private static FibonacciSeries series;
    
    public FibonacciPrimeUtil() {
        series = FibonacciSeries.current();
    }
    
    /**
     * Get all Fibonacci numbers that are also prime in a given range of indices
     * @param lowerBound Lower bound index (inclusive)
     * @param upperBound Upper bound index (exclusive)
     * @return HashMap with key-value pairs representing an index (key) and its corresponding Fibonacci number
     */
    public HashMap<Integer, BigInteger> findFibonacciPrimesInRange(int lowerBound, int upperBound) {
        if (lowerBound <= 0 || upperBound <= 0) {
            throw new IllegalArgumentException("Lower bound and upper bound must be positive");
        } else if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound");
        }
        
        var primes = new HashMap<Integer, BigInteger>();
        for (var i = lowerBound; i <= upperBound; i++) {
            var fib = series.find(i);
            if (fib.isProbablePrime(1)) {
                primes.put(i, fib);
            }
        }
        
        return primes;
    }
    
    /**
     * Find the smallest Fibonacci number divisible by a given prime
     * @param prime Prime number by which the Fibonacci number is divided
     * @return Index of the Fibonacci number in the sequence
     */
    public int findFibonacciEntryPoint(BigInteger prime) {
        if (prime.signum() <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        } else if (!prime.isProbablePrime(1)) {
            throw new IllegalArgumentException("Number must be prime");
        }
        
        var index = 1;
        while (!series.find(index).mod(prime).equals(BigInteger.ZERO)) {
            index++;
        }
        
        return index;
    }
    
    /**
     * Find all the prime factors of the Fibonacci number at the given index
     * @param index Index of the Fibonacci number being factorized
     * @return Array of prime factors in ascending order
     */
    public BigInteger[] findPrimeFactors(int index) {
        var primeFactors = new HashSet<BigInteger>();
        var fib = series.find(index);
        
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
        
        var primes = fibonacciPrimeUtil.findFibonacciPrimesInRange(1, 100);
        
        System.out.print("[");
        var count = 0;
        for (var i : primes.keySet()) {
            System.out.print(i);
            System.out.print(", ");
            System.out.print(primes.get(i));
            if (count != primes.size() - 1) {
                System.out.println(", ");
            }
            count++;
        }
        System.out.println("]");
        
        var index = 1000;
        
        var factors = fibonacciPrimeUtil.findPrimeFactors(index);
        
        System.out.println("\nPrime factors of fib(" + index + "): " + series.find(index));
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
