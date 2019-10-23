package problems;

import problems.palindromenumber.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromeNumberTest {

    private void runTests(ISolution solution){
        assertTrue(solution.isPalindrome(0));
        assertFalse(solution.isPalindrome(-1));

        assertTrue(solution.isPalindrome(1));
        assertTrue(solution.isPalindrome(121));
        assertTrue(solution.isPalindrome(12321));

        assertFalse(solution.isPalindrome(12));
        assertFalse(solution.isPalindrome(123));
        assertFalse(solution.isPalindrome(1234));
        assertFalse(solution.isPalindrome(4321));
        assertFalse(solution.isPalindrome(321));
        assertFalse(solution.isPalindrome(21));
    }

    @Test
    public void testSolution1() {
        runTests(new Solution1());
    }

    public void testSolution2() {
        runTests(new Solution2());
    }
}