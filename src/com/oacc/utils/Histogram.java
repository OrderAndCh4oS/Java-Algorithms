
package com.oacc.utils;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by sarcoma on 27/12/16.
 */
public class Histogram {
    /**
     * Generates a histogram of occurrences of ints in array 'a' up to maximum 'M'
     * @param a An array of ints to generate the histogram from
     * @param M Max figure to look for in 'a' array
     * @return An array of occurences of ints in 'a'
     */
    public static int[] histogram(int[] a, int M) {
        int[] histogram = new int[M];
        Arrays.sort(a);
        int i = 0;
        int j = 0;
        while(i < M) {
            if(j != a.length && a[j] == i) {
                histogram[i]++;
                j++;
            } else {
                i++;
            }
        }
        return histogram;
    }

    public static void main(String[] args)
    {
        int[] a = { 0, 0, 0, 1, 1, 2, 3, 4, 4};
        int[] h = histogram(a, 5);
        StdOut.println(Arrays.toString(h));
    }
}
