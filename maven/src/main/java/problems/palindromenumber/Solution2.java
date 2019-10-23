package problems.palindromenumber;

public class Solution2 implements ISolution {
    public boolean isPalindrome(int x) {

        // - sign cannot be on the low side
        if (x < 0){
            return false;
        }

        // lowest digit is 0, only 0 is palindrome in that case
        if (x % 10 == 0 && x != 0){
            return false;
        }

        // revert half of the number.
        // if the number of digits is odd, revert middle as well.
        // we will reduce x to the high half, so we know we completed at least
        // a half when x < y
        int y = 0;
        while (x > y){
            y = (y * 10) + (x % 10);
            x /= 10;
        }

        // if x == y, its a palindrome.
        // in case x had odd number of digits, we can remove the middle
        // which is actually the lowest in y; note that its ok to do so always
        // because it won't cause a false positive in cases where x had even number
        // of digits, because now y will have one less digit so it sure is not equal to x.
        return x == y || x == (y / 10);
    }
}