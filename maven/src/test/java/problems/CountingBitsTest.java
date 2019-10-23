package problems;

import problems.counting_bits.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingBitsTest {

    private void runTests(ISolution solution) {
        assertArrayEquals(new int[] { 0, 1, 1 }, solution.countBits(2));
        assertArrayEquals(new int[] { 0, 1, 1, 2, 1, 2 }, solution.countBits(5));
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