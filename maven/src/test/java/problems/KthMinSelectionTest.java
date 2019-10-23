package problems;

import problems.kth_min_selection.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthMinSelectionTest {

    private void runTests(ISolution solution) {
        assertEquals(4, solution.kthMin(new int[] { 4, 7, 2, 3, 1, 10 }, 3));
        assertEquals(-5, solution.kthMin(new int[] { -5, 100, 10, 300, 1024 }, 0));
    }

    @Test
    public void testSolution1() {
        runTests(new Solution1());
    }
}