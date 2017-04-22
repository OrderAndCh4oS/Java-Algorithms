

package com.oacc.maths;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sarcoma on 27/12/16.
 */
public class Log {
    /**
     * log returns greatest log N of given base
     * @param N the integer you want the greatest log of
     * @param base The logarithmic base
     * @return greatest log N of given base
     */
    public static int log(int N, int base) {
        int result = N;
        for(int i = 0; i < base; i++) {
            result *= N;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]);
        StdOut.printf("%d", log(N, base));
    }
}
