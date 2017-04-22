package com.oacc.maths;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sarcoma on 27/12/16.
 */
public class Factorial {
    /**
     * Factorial of N
     *
     * @param N int
     * @return int that is factorial of N
     */
    public static int factorial(int N) {
        if (N == 1) return 1;
        return N * factorial(N - 1);
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        StdOut.println(factorial(x));
    }
}
