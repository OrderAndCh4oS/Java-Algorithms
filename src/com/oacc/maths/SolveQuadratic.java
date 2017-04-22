package com.oacc.maths;

/**
 * Created by sarcoma on 22/04/17.
 */
public class SolveQuadratic {

    public static double[] solveQuadratic(double a, double b, double c) {
        double[] result;
        double discriminant = b * b - 4 * a * c;
        if (Double.compare(discriminant, 0) > 0) {
            result = new double[2];
            result[0] = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            result[1] = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        } else if(Double.compare(discriminant, 0) == 0) {
            result = new double[1];
            result[0] = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        } else {
            result = new double[1];
            result[0] = -1;
        }
        return result;
    }

    public static void main(String args[]) {
        double[] result = solveQuadratic(1, 6,9);
        for (double aResult: result) {
            System.out.println(aResult);
        }
    }
}
