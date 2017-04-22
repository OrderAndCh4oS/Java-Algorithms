package com.oacc.maths;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sarcoma on 27/12/16.
 */
public class Sqrt {
    /**
     * Find the square root of x
     * @param x double
     * @return double
     */
    public static double sqrt(double x) {
        double e = 0.00000000000001;
        double y = x/2;
        while(y*y - x > e) {
            y = y - ((y*y - x)/(y*2));
        }
        return y;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        StdOut.println(sqrt(x));
    }
}

