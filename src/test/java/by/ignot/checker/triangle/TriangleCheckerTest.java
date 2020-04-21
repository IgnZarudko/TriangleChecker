package by.ignot.checker.triangle;

import by.ignot.checker.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;


public class TriangleCheckerTest {

    public static Stream<Arguments> positiveCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{2, 3, 2}),
                Arguments.of((Object) new int[]{7, 8, 10}),
                Arguments.of((Object) new int[]{123, 32, 100})
        );
    }

    @ParameterizedTest
    @MethodSource("positiveCaseData")
    public void checkerPositiveTest(int[] sides) {
        try{
            Assertions.assertTrue(TriangleChecker.check(sides[0],sides[1],sides[2]));
        }
        catch (TriangleException e){
            Assertions.fail(e.getMessage());
        }
    }

    public static Stream<Arguments> negativeCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{1, 3, 2}),
                Arguments.of((Object) new int[]{7, 8, 20}),
                Arguments.of((Object) new int[]{130, 29, 100})
        );
    }

    @ParameterizedTest
    @MethodSource("negativeCaseData")
    public void checkerNegativeTest(int[] sides) {
        try{
            Assertions.assertFalse(TriangleChecker.check(sides[0],sides[1],sides[2]));
        }
        catch (TriangleException e){
            Assertions.fail(e.getMessage());
        }
    }

    public static Stream<Arguments> exceptionCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{-1, 3, 2}),
                Arguments.of((Object) new int[]{7, 8, -20}),
                Arguments.of((Object) new int[]{130, 0, 100})
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionCaseData")
    public void exceptionNegativeTest(int[] sides) {
        try{
            TriangleChecker.check(sides[0],sides[1],sides[2]);
        }
        catch (TriangleException e){
            String expected = "<= 0 values not allowed here";
            Assertions.assertEquals(expected, e.getMessage());
        }
    }

    public static Stream<Arguments> transpositionCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{3, 2, 2}),
                Arguments.of((Object) new int[]{10, 7, 8}),
                Arguments.of((Object) new int[]{32, 100, 123})
        );
    }

    @ParameterizedTest
    @MethodSource("transpositionCaseData")
    public void transpositionCaseTest(int[] sides) {
        try{
            Assertions.assertTrue(TriangleChecker.check(sides[0],sides[1],sides[2]));
        }
        catch (TriangleException e){
            Assertions.fail(e.getMessage());
        }
    }

    static Stream<Arguments> isoscelesCaseData() {
        return Stream.of(
                Arguments.of((Object) new int[]{5, 4, 4}),
                Arguments.of((Object) new int[]{9, 9, 7}),
                Arguments.of((Object) new int[]{20, 20, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("isoscelesCaseData")
    public void triangleCheckTestIsosceles(int[] sides) {
        try {
            Assertions.assertTrue(TriangleChecker.check(sides[0], sides[1], sides[2]));
        } catch (TriangleException e) {
            Assertions.fail(e.getMessage());
        }
    }

    static Stream<Arguments> equilateralCaseData() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 3, 3}),
                Arguments.of((Object) new int[]{11, 11, 11}),
                Arguments.of((Object) new int[]{1101, 1101, 1101})
        );
    }

    @ParameterizedTest
    @MethodSource("equilateralCaseData")
    public void triangleCheckTestEquilateral(int[] sides) {
        try {
            Assertions.assertTrue(TriangleChecker.check(sides[0], sides[1], sides[2]));
        } catch (TriangleException e) {
            Assertions.fail(e.getMessage());
        }
    }

    static Stream<Arguments> rightCaseData() {
        return Stream.of(
                Arguments.of((Object) new int[]{5, 3, 4}),
                Arguments.of((Object) new int[]{13, 5, 12}),
                Arguments.of((Object) new int[]{65, 33, 56})
        );
    }

    @ParameterizedTest
    @MethodSource("rightCaseData")
    public void triangleCheckTestRight(int[] sides) {
        try {
            Assertions.assertTrue(TriangleChecker.check(sides[0], sides[1], sides[2]));
        } catch (TriangleException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
