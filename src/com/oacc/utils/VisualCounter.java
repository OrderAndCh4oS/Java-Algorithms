package com.oacc.utils;

import com.oacc.errors.OutOfRangeException;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by sarcoma on 21/01/17.
 */
public class VisualCounter {

    private final String name;
    private final int n;
    private final int max;
    private int scale = 5;
    private int counter = 0;
    private int plotX = 0;

    public VisualCounter(String name, int n, int max) {
        this.name = name;
        this.n = n;
        this.max = max;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, max * scale);
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.RED);
    }

    public void setScale(int scale) {
        this.scale = scale;
        StdDraw.setYscale(0, max * scale);
    }

    public void increment() throws OutOfRangeException {
        if (counter > max) {
            throw new OutOfRangeException("Counter greater than max");
        } else {
            counter++;
            plot();
        }
    }

    public void decrement() throws OutOfRangeException {
        if (counter <= -max) {
            throw new OutOfRangeException("Counter lower than 0");
        } else {
            counter--;
            plot();
        }
    }

    public int tally() {
        return counter;
    }

    private void plot() {
        if(plotX <= n) {
            StdDraw.point(plotX, counter + ((max * scale) / 2));
            plotX++;
        }
    }

    @Override
    public String toString() {
        return name + ": " + counter;
    }

    public static void main(String[] args) {
        int max = 100;
        int n = 100;
        VisualCounter visualCounter = new VisualCounter("High", n, max);
        visualCounter.setScale(10);
        for (int i = 0; i < n; i++) {
            int number = StdRandom.uniform(0, max);
            if (number >= (max / 2)) {
                try {
                    visualCounter.increment();
                } catch (OutOfRangeException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    visualCounter.decrement();
                } catch (OutOfRangeException e) {
                    e.printStackTrace();
                }
            }
        }
        StdOut.print(visualCounter);
    }
}
