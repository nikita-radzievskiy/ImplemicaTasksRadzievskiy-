package com.implemica.radzievskiy.task3;

import java.math.BigInteger;

public class Task3 {


    public static void main(String[] args) {
        System.out.println(getSum(100));
    }

    public static long getSum(int n) { // n is the number of digits in the number
        BigInteger factorial = getFactorial(n); // get factorial of n
        int sum = 0;                        // sum of digits of factorial
        while (factorial.compareTo(BigInteger.ZERO) > 0) {  // while factorial is greater than 0
            sum += factorial.mod(BigInteger.TEN).intValue();    // add the last digit of factorial to sum
            factorial = factorial.divide(BigInteger.TEN);   // remove the last digit of factorial
        }
        return sum;                                          // return sum
    }

    public static BigInteger getFactorial(int factorial) {  // factorial is the number of digits in the number
        BigInteger result = BigInteger.ONE; // result is 1
        for (int i = 1; i <= factorial; i++)    // for each number from 1 to factorial
            result = result.multiply(BigInteger.valueOf(i));    // multiply result by i
        return result;                                        // return result
    }
}
