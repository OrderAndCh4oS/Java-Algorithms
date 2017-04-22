package com.oacc.maths;

public class SolveCubic {

    public static double[] solveCubic(double d, double a, double b, double c) {
        double[] result;
        a = a / d;
        b = b / d;
        c = c / d;

        double p = b / 3 - a * a / 9;
        double q = a * a * a / 27 - a * b / 6 + c / 2;
        double D = p * p * p + q * q;

        System.out.println(D);

        if (Double.compare(D, 0) >= 0) {
            if (Double.compare(D, 0) == 0) {
                System.out.println("XXXXXX");
                double r = Math.cbrt(-q);
                result = new double[2];
                result[0] = 2 * r;
                result[1] = -r;
            } else {
                double r = Math.cbrt(-q + Math.sqrt(D));
                double s = Math.cbrt(-q - Math.sqrt(D));
                result = new double[1];
                result[0] = r + s;
            }
        } else {
            double ang = Math.acos(-q / Math.sqrt(-p * p * p));
            double r = 2 * Math.sqrt(-p);
            result = new double[3];
            for (int k = -1; k <= 1; k++) {
                double theta = (ang - 2 * Math.PI * k) / 3;
                result[k + 1] = r * Math.cos(theta);
            }

        }
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - a / 3;
        }
        return result;
    }

    public static double[] solveCubic(double a, double b, double c) {
        double d = 1;
        return solveCubic(d, a, b, c);
    }

    public static void main(String args[]) {
        double[] threeRoots = solveCubic(1, -6, 11, -6);
        System.out.println("Three Roots: x^3 − 6x^2 + 11x − 6 = 0");
        System.out.println("x = 1, x = 2 and x = 3");
        for (double aResult : threeRoots) {
            System.out.println("x ≈ " + aResult);
        }
        double[] singleRoot = solveCubic(5, 4, 3, 2);
        System.out.println("Single Root: 5x^3 + 4x^2 + 3x + 2 = 0");
        System.out.println("x ≈ -0.7293231430114580884686909");
        for (double aResult : singleRoot) {
            System.out.println("x ≈ " + aResult);
        }
        double[] zeroD = solveCubic(1, -3, -24, 80);
        System.out.println("Zero D: x^3 - 3 x^2 - 24 x + 80");
        System.out.println("x = -5, x = 4");
        for (double aResult : zeroD) {
            System.out.println("x ≈ " + aResult);
        }
    }
}
