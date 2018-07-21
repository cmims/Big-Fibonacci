package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.HashMap;

public class FibonacciSeries {
    private BigInteger fib;
    private BigInteger prev;
    private int index;
    
    private HashMap<Integer, BigInteger> series;
    
    public FibonacciSeries() {
        fib = BigInteger.ZERO;
        prev = BigInteger.ONE;
        index = 0;
        
        series = new HashMap<>();
    }
    
    public BigInteger get(int index) {
        if (series.containsKey(index)) {
            return series.get(index);
        } else {
            while (this.index < index) {
                var temp = new BigInteger(fib.toString());
                fib = fib.add(prev);
                prev = temp;
                
                series.put(index, fib);
                
                this.index++;
                
            }
            return fib;
        }
    }
    
    public BigInteger[] get(int lowerBound, int upperBound) {
        var range = new BigInteger[upperBound - lowerBound];
        for (int i = 0; i < range.length; i++) {
            range[i] = get(lowerBound++);
        }
        
        return range;
    }
    
    public static BigInteger getRecursively(int index) {
        if (index == 0) {
            return BigInteger.ZERO;
        } else if (index == 1) {
            return BigInteger.ONE;
        } else {
            return getRecursively(index - 1).add(getRecursively(index - 2));
        }
    }
}
