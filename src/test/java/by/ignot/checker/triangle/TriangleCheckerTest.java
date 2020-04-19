package by.ignot.checker.triangle;

import by.ignot.checker.exception.TriangleException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.stream.Stream;

public class TriangleCheckerTest {

    @Parameters
    public static Stream<Arguments> PositiveCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{2, 3, 2}),
                Arguments.of((Object) new int[]{7, 8, 10}),
                Arguments.of((Object) new int[]{123, 32, 100})
        );
    }

    @ParameterizedTest
    @MethodSource("PositiveCaseData")
    public void CheckerPositiveTest(int[] sides) {
        try{
            Assert.assertTrue(TriangleChecker.check(sides[0],sides[1],sides[2]));
        }
        catch (TriangleException e){
            Assertions.fail(e.getMessage());
        }
    }

    @Parameters
    public static Stream<Arguments> NegativeCaseData(){
        return Stream.of(
                Arguments.of((Object) new int[]{1, 3, 2}),
                Arguments.of((Object) new int[]{7, 8, 20}),
                Arguments.of((Object) new int[]{130, 29, 100})
        );
    }

    @ParameterizedTest
    @MethodSource("NegativeCaseData")
    public void CheckerNegativeTest(int[] sides) {
        try{
            Assert.assertTrue(TriangleChecker.check(sides[0],sides[1],sides[2]));
        }
        catch (TriangleException e){
            Assertions.fail(e.getMessage());
        }
    }

}
