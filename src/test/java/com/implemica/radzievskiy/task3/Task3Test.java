package com.implemica.radzievskiy.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task3Test {

    @Test
    void shouldFindFactorialOfThe4NumWhenCallsMethodGetFactorial() {
        //given
        int factorial = 4;
        //when
        BigInteger result = Task3.getFactorial(factorial);
        //then
        Assertions.assertEquals(new BigInteger("24"), result);
    }

    @Test
    void shouldFindFactorialOfThe100NumWhenCallsMethodGetFactorial() {
        //given
        int factorial = 100;
        BigInteger expected = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
        //when
        BigInteger result = Task3.getFactorial(factorial);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldFindSumOfFactorialsOfThe4NumWhenCallsMethodGetSum() {
        //given
        int n = 4;
        //when
        long result = Task3.getSum(n);
        //then
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldFindSumOfFactorialsOfThe100NumWhenCallsMethodGetSum() {
        //given
        int n = 100;
        //when
        long result = Task3.getSum(n);
        //then
        Assertions.assertEquals(648, result);
    }

}
