package problems;

import problems.best_time_to_buy_and_sell_stock.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {

    private void runTests(ISolution solution) {
        assertEquals(5, solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        assertEquals(0, solution.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
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