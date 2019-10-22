import longest_fibonacci_subsequence.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestFibonacciSubsequenceTest {

    private void runTests(ISolution solution){
        assertEquals(5, solution.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
        assertEquals(3, solution.lenLongestFibSubseq(new int[] {1,3,7,11,12,14,18}));
    }

    @Test
    public void testSolution1() {
        runTests(new Solution1());
    }

    @Test
    public void testSolution2() {
        runTests(new Solution2());
    }
}