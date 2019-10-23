package problems;

import problems.reverseinteger.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {

    private void runTests(ISolution solution){
        assertEquals(0, solution.reverse(0));
        assertEquals(1, solution.reverse(1));
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(0, solution.reverse(1534236469));
    }

    @Test
    public void testSolution1() {
        runTests(new Solution1());
    }
}