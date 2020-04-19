package by.ignot.checker.triangle;

import by.ignot.checker.exception.TriangleException;

public class TriangleChecker {
    public static boolean check(int a, int b, int c) throws TriangleException {
        if ((a > 0) && (b > 0) && (c > 0)){
            return ((a + b > c) && (a + c > b) && (b + c > a));
        }
        else{
            throw new TriangleException("<= 0 values not allowed here");
        }
    }
}
