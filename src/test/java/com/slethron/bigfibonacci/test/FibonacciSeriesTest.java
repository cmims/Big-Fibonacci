package com.slethron.bigfibonacci.test;

import com.slethron.bigfibonacci.FibonacciSeries;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class FibonacciSeriesTest {
    private FibonacciSeries series;
    
    @Before
    public void before() {
        series = new FibonacciSeries();
    }
    
    @Test
    public void getNthFibReturnsFofN() {
        assertThat(series.get(0)).isEquivalentAccordingToCompareTo(BigInteger.ZERO);
        assertThat(series.get(1)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(series.get(2)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(series.get(3)).isEquivalentAccordingToCompareTo(BigInteger.TWO);
        assertThat(series.get(4)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(3));
        assertThat(series.get(5)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(5));
        assertThat(series.get(6)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(8));
        assertThat(series.get(7)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(13));
        assertThat(series.get(8)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(21));
        assertThat(series.get(9)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(34));
        assertThat(series.get(10)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(55));
        //...
        assertThat(series.get(20)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(6765));
    }
    
    @Test
    public void getNthFibRecursivelyReturnsFofN() {
        assertThat(FibonacciSeries.getRecursively(0)).isEquivalentAccordingToCompareTo(BigInteger.ZERO);
        assertThat(FibonacciSeries.getRecursively(1)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(FibonacciSeries.getRecursively(2)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(FibonacciSeries.getRecursively(3)).isEquivalentAccordingToCompareTo(BigInteger.TWO);
        assertThat(FibonacciSeries.getRecursively(4)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(3));
        assertThat(FibonacciSeries.getRecursively(5)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(5));
        assertThat(FibonacciSeries.getRecursively(6)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(8));
        assertThat(FibonacciSeries.getRecursively(7)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(13));
        assertThat(FibonacciSeries.getRecursively(8)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(21));
        assertThat(FibonacciSeries.getRecursively(9)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(34));
        assertThat(FibonacciSeries.getRecursively(10)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(55));
        //...
        assertThat(FibonacciSeries.getRecursively(20)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(6765));
    }
    
    @Test
    public void getZerothTenFibonacciNumbers() {
        int lowerBound = 0;
        int upperBound = 10;
        var fibs = series.get(lowerBound, upperBound);
        
        assertThat(fibs[0]).isEquivalentAccordingToCompareTo(BigInteger.ZERO);
        assertThat(fibs[1]).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(fibs[2]).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(fibs[3]).isEquivalentAccordingToCompareTo(BigInteger.TWO);
        assertThat(fibs[4]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(3));
        assertThat(fibs[5]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(5));
        assertThat(fibs[6]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(8));
        assertThat(fibs[7]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(13));
        assertThat(fibs[8]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(21));
        assertThat(fibs[9]).isEquivalentAccordingToCompareTo(BigInteger.valueOf(34));
    }
    
    @Test
    public void getIndexOfFibReturnsCorrectIndex() {
        var expectedIndex = 15;
        var fib = series.get(expectedIndex);
        assertWithMessage("Index returned differs from expected index %s", expectedIndex)
                .that(series.getIndexOfFib(fib))
                .isEqualTo(expectedIndex);
    }
    
    @Test
    public void currentInstance() {
        var instance0 = FibonacciSeries.current();
        var instance1 = FibonacciSeries.current();
        assertThat(instance0).isSameAs(instance1);
        assertThat(instance0).isInstanceOf(FibonacciSeries.class);
        assertThat(instance1).isInstanceOf(FibonacciSeries.class);
    }
}
