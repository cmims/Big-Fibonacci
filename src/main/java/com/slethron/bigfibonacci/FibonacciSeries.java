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
    
    public static FibonacciSeries current() {
        if (instance == null) {
            instance = new FibonacciSeries();
        }
        
        return instance;
    }
    
    public BigInteger find(int index) {
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
                return find(-index);
            } else {
                return find(-index).negate();
            }
        }
    }
    
    public BigInteger[] find(int lowerBound, int upperBound) {
        var fibs = new BigInteger[upperBound - lowerBound];
        for (int i = 0; i < fibs.length; i++) {
            fibs[i] = find(lowerBound++);
        }
        
        return fibs;
    }
    
    public static BigInteger findRecursively(int index) {
        if (index == 0) {
            return BigInteger.ZERO;
        } else if (index == 1) {
            return BigInteger.ONE;
        } else if (index >= 0) {
            return findRecursively(index - 1).add(findRecursively(index - 2));
        } else {
            if (Math.pow(-1, index + 1) == 1.0) {
                return findRecursively(-index);
            } else {
                return findRecursively(-index).negate();
            }
        }
    }
    
    public int findIndexOfFib(BigInteger fib) {
        var negate = false;
        if (fib.signum() < 0) {
            negate = true;
        }
        
        var index = 0;
        while (find(index).compareTo(fib) < 0) {
            index++;
        }
        
        if (!find(index).equals(fib)) {
            throw new IllegalArgumentException("Number is not a Fibonacci number");
        }
        
        if (negate) {
            return -index;
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        var series = FibonacciSeries.current();
        for (var i = -8; i <= 8; i++) {
            System.out.print("| f(" + i + ") ");
            if (i == 8) {
                System.out.println("|");
            }
        }

        for (var i = -8; i <= 8; i++) {
            System.out.print("   " + series.find(i) + "   ");
        }
    }
}
