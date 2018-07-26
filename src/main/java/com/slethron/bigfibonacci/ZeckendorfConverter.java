package com.slethron.bigfibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

public class ZeckendorfConverter {
    private static FibonacciSeries series;
    
    public ZeckendorfConverter() {
        series = FibonacciSeries.current();
    }
    
    /**
     * Zeckendorf's theroem states that every positive integer can be represented uniquely as the sum of one or more
     * distinct Fibonacci numbers in such a way that the sum does not include any two consecutive Fibonacci numbers.
     *
     * @param num Number to be converted to Zeckendorf representation
     * @return an array containing the Zeckendorf summation
     */
    public BigInteger[] getZeckendorfRepresentation(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Zeckendorf representation can only be obtained for positive integers");
        }
        
        var fibs = new ArrayList<BigInteger>();
        while (num.compareTo(BigInteger.ZERO) > 0) {
            var index = 0;
            var fib = BigInteger.ZERO;
            while (series.get(index + 1).compareTo(num) <= 0) {
                fib = series.get(++index);
            }
            
            fibs.add(fib);
            num = num.add(fib.negate());
        }
        
        return fibs.toArray(new BigInteger[0]);
    }
    
    /**
     * Zeckendor's theorem can be further expanded to include negatively indexed Fibonacci numbers. More precisely,
     * every integer, positive or negative, can be uniquely represented as the sum of one or more distinct
     * nega-Fibonacci numbers in such a way that the sum does not include any two consecutive nega-Fibonacci numbers.
     *
     * @param num
     * @return
     */
    public BigInteger[] getNegativelyIndexedFibonacciRepresentation(BigInteger num) {
        var fibs = new ArrayList<BigInteger>();
        while (num.compareTo(BigInteger.ZERO) != 0) {
            var index = 0;
            var fib = BigInteger.ZERO;
            if (num.equals(BigInteger.ONE)) {
                fib = BigInteger.ONE;
            } else if (num.compareTo(BigInteger.ZERO) < 0) {
                while (series.get(index - 1).abs().negate().compareTo(num) >= 0) {
                    fib = series.get(--index);
                }
                
                if (fib.signum() >= 0) {
                    fib = series.get(--index);
                }
            } else {
                while (series.get(index - 1).abs().compareTo(num) <= 0) {
                    fib = series.get(--index);
                }
                
                if (fib.compareTo(BigInteger.ONE.negate()) < 0) {
                    fib = series.get(--index);
                }
            }
            
            fibs.add(fib);
            num = num.add(fib.negate());
        }
        
        return fibs.toArray(new BigInteger[0]);
    }
    
    public static void main(String[] args) {
        var zeckendorfConverter = new ZeckendorfConverter();
        
        var num = new BigInteger("24");
        
        System.out.print("Zeckendorf representation of " + num + ":\n[");
        var components = zeckendorfConverter.getZeckendorfRepresentation(num);
        for (var i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i != components.length - 1) {
                System.out.print(",");
            }
            System.out.println("]");
        }
        
        System.out.print("\nNegatively Indexed Fibonacci representation of " + num + ":\n[");
        components = zeckendorfConverter.getNegativelyIndexedFibonacciRepresentation(num);
        for (var i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i != components.length - 1) {
                System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
