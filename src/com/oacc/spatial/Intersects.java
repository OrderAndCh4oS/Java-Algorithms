package com.oacc.spatial;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

/**
 * Created by sarcoma on 21/01/17.
 */
public class Intersects {

    public static ArrayList<Interval1D[]> findIntersects(Interval1D lines[]) {
        ArrayList<Interval1D[]> intersectPairs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                boolean isIntersect = lines[i].intersects(lines[j]);
                if (isIntersect) {
                    Interval1D[] intersect = new Interval1D[2];
                    intersect[0] = lines[i];
                    intersect[1] = lines[j];
                    intersectPairs.add(intersect);
                }
            }
        }
        return intersectPairs;
    }

    public static void main(String[] args) {
        if (!(args.length > 0)) {
            return;
        }
        int n = Integer.parseInt(args[0]);
        Interval1D[] lines = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Interval1D line;
            if(x < y) {
                line = new Interval1D(x, y);
            } else {
                line = new Interval1D(y, x);
            }
            lines[i] = line;
        }
        ArrayList<Interval1D[]> intersectPairs;
        intersectPairs = findIntersects(lines);
        for (Interval1D[] intersect:intersectPairs) {
            StdOut.printf("1: %s,  2: %s\n", intersect[0], intersect[1]);
        }
    }
}
