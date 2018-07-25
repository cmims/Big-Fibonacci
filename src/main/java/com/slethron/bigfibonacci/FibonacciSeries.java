package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.HashMap;

public class FibonacciSeries {
    private static FibonacciSeries instance = null;
    
    private BigInteger fib;
    private BigInteger prev;
    private int index;
    
    private HashMap<Integer, BigInteger> series;
    
    public FibonacciSeries() {
        fib = BigInteger.ZERO;
        prev = BigInteger.ONE;
        index = 0;
        
        series = new HashMap<>();
        series.put(index, fib);
    }
    
    static FibonacciSeries getCurrent() {
        if (instance == null) {
            instance = new FibonacciSeries();
        }
        
        return instance;
    }
    
    public BigInteger get(int index) {
        if (series.containsKey(index)) {
            return series.get(index);
        } else if (index >= 0) {
            while (this.index < index) {
                var temp = new BigInteger(fib.toString());
                fib = fib.add(prev);
                prev = temp;
                
                series.put(++this.index, fib);
            }
            return fib;
        } else {
            if (Math.pow(-1, index + 1) == 1.0) {
                return get(-index);
            } else {
                return get(-index).negate();
            }
        }
    }
    
    public BigInteger[] get(int lowerBound, int upperBound) {
        var fibs = new BigInteger[upperBound - lowerBound];
        for (int i = 0; i < fibs.length; i++) {
            fibs[i] = get(lowerBound++);
        }
        
        return fibs;
    }
    
    public static BigInteger getRecursively(int index) {
        if (index == 0) {
            return BigInteger.ZERO;
        } else if (index == 1) {
            return BigInteger.ONE;
        } else if (index >= 0) {
            return getRecursively(index - 1).add(getRecursively(index - 2));
        } else {
            if (Math.pow(-1, index + 1) == 1.0) {
                return getRecursively(-index);
            } else {
                return getRecursively(-index).negate();
            }
        }
    }
    
    public static void main(String[] args) {
        var series = FibonacciSeries.getCurrent();
        for (var i = -8; i <= 8; i++) {
            System.out.print("| f(" + i + ") ");
            if (i == 8) {
                System.out.println("|");
            }
        }
        
        for (var i = -8; i <= 8; i++) {
            System.out.print("   " + series.get(i) + "   ");
        }
    }
}
