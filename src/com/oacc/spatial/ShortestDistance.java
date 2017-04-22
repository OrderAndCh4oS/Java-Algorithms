package com.oacc.spatial;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by sarcoma on 14/01/17.
 */
public class ShortestDistance {

    /**
     * Find the shortest distance between array of Point2d
     *
     * @param points Array of Points2D
     * @return double of the shortest distance
     */
    public static double findClosestPointsDistance(Point2D points[]) {
        double shortestDistance = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < shortestDistance || shortestDistance == -1) {
                    shortestDistance = distance;
                }
            }
        }
        return shortestDistance;
    }

    public static void main(String[] args) {
        if (!(args.length > 0)) {
            return;
        }
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.gaussian();
            double y = StdRandom.gaussian();
            Point2D point = new Point2D(x, y);
            points[i] = point;
            // point.draw();
        }
        StdOut.println(findClosestPointsDistance(points));
    }
}
