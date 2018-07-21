package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciUtil {
    private FibonacciSeries series;
    
    public FibonacciUtil() {
        series = new FibonacciSeries();
    }
    
    public BigInteger[] getPrimesInRange(int lowerBound, int upperBound) {
        var primes = new ArrayList<BigInteger>();
        for (var fib : series.get(lowerBound, upperBound)) {
            if (fib.isProbablePrime(1)) {
                primes.add(fib);
            }
        }

        return primes.toArray(new BigInteger[0]);
    }
}
