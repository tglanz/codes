package problems;

import problems.longest_increasing_subsequence.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {

    private void runTests(ISolution solution){
        assertEquals(4, solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
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