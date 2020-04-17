package by.ignot.checker.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleCheckerTest {
    @Test
    public void CheckerTest(){
        Assert.assertTrue(TriangleChecker.check(1,2,2));
    }
}
