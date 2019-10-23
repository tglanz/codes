package problems;

import problems.divisor_game.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisorGameTest {

    private void runTests(ISolution solution){
        assertEquals(true, solution.divisorGame(2));
        assertEquals(false, solution.divisorGame(3));
        assertEquals(true, solution.divisorGame(4));
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