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
        assertThat(series.find(0)).isEquivalentAccordingToCompareTo(BigInteger.ZERO);
        assertThat(series.find(1)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(series.find(2)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(series.find(3)).isEquivalentAccordingToCompareTo(BigInteger.TWO);
        assertThat(series.find(4)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(3));
        assertThat(series.find(5)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(5));
        assertThat(series.find(6)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(8));
        assertThat(series.find(7)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(13));
        assertThat(series.find(8)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(21));
        assertThat(series.find(9)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(34));
        assertThat(series.find(10)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(55));
        //...
        assertThat(series.find(20)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(6765));
    }
    
    @Test
    public void getNthFibRecursivelyReturnsFofN() {
        assertThat(FibonacciSeries.findRecursively(0)).isEquivalentAccordingToCompareTo(BigInteger.ZERO);
        assertThat(FibonacciSeries.findRecursively(1)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(FibonacciSeries.findRecursively(2)).isEquivalentAccordingToCompareTo(BigInteger.ONE);
        assertThat(FibonacciSeries.findRecursively(3)).isEquivalentAccordingToCompareTo(BigInteger.TWO);
        assertThat(FibonacciSeries.findRecursively(4)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(3));
        assertThat(FibonacciSeries.findRecursively(5)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(5));
        assertThat(FibonacciSeries.findRecursively(6)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(8));
        assertThat(FibonacciSeries.findRecursively(7)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(13));
        assertThat(FibonacciSeries.findRecursively(8)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(21));
        assertThat(FibonacciSeries.findRecursively(9)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(34));
        assertThat(FibonacciSeries.findRecursively(10)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(55));
        //...
        assertThat(FibonacciSeries.findRecursively(20)).isEquivalentAccordingToCompareTo(BigInteger.valueOf(6765));
    }
    
    @Test
    public void getZerothTenFibonacciNumbers() {
        int lowerBound = 0;
        int upperBound = 10;
        var fibs = series.find(lowerBound, upperBound);
        
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
        var fib = series.find(expectedIndex);
        assertWithMessage("Index returned differs from expected index %s", expectedIndex)
                .that(series.findIndexOfFib(fib))
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
