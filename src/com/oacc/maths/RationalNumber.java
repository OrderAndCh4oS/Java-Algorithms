package com.oacc.maths;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sarcoma on 22/01/17.
 */
public class RationalNumber {
    private final long numerator;
    private final long denominator;

    public RationalNumber(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public RationalNumber plus(RationalNumber b) {
        long x = numerator * b.denominator + denominator * b.numerator;
        long y = denominator * b.denominator;
        return simplify(x, y);
    }

    public RationalNumber minus(RationalNumber b) {
        long x = numerator * b.denominator - denominator * b.numerator;
        long y = denominator * b.denominator;
        return simplify(x, y);
    }

    public RationalNumber divide(RationalNumber b) {
        RationalNumber x = new RationalNumber(b.denominator, b.numerator);
        return multiply(x);
    }

    public RationalNumber multiply(RationalNumber b) {
        long x = numerator * b.numerator;
        long y = denominator * b.denominator;
        return simplify(x, y);
    }

    public boolean equal(RationalNumber b) {
        b = simplify(b.numerator, b.denominator);
        return numerator == b.numerator && denominator == b.denominator;
    }

    private RationalNumber simplify(long x, long y) {
        long gcd = gcd(x, y);
        return new RationalNumber(x / gcd, y / gcd);
    }

    private long gcd(long x, long y) {
        return GCD.gcd(x, y);
    }

    public static void main(String args[]) {
        RationalNumber a = new RationalNumber(1, 4);
        RationalNumber b = new RationalNumber(2, 4);
        RationalNumber c = new RationalNumber(4, 8);

        RationalNumber x = a.plus(b);
        RationalNumber y = b.minus(a);
        RationalNumber z = a.multiply(b);
        RationalNumber w = a.divide(b);

        boolean equal = b.equal(c);
        StdOut.println("x: " + x);
        StdOut.println("y: " + y);
        StdOut.println("z: " + z);
        StdOut.println("w: " + w);
        StdOut.println("equal: " + equal);
    }
}

