package com.oacc.maths;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sarcoma on 27/12/16.
 */
public class GCD {
    /**
     * Find greatest common denominator of two ints
     * @param p int
     * @param q int
     * @return int Greatest Common Denominator
     */
    public static long gcd(long p, long q) {
        if(q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        long x = Integer.parseInt(args[0]);
        long y = Integer.parseInt(args[1]);
        StdOut.println(gcd(x, y));
    }
}
