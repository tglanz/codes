package palindromenumber;

import java.util.Stack;

public class Solution1 implements ISolution {
    public boolean isPalindrome(int x) {

        if (x < 0){
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int digits = (int)Math.log10(x) + 1;

        for (int idx = 0; idx < digits / 2; ++idx){
            stack.push(x % 10);
            x /= 10;
        }

        if (digits % 2 != 0){
            x /= 10;
        }

        while (x > 0){
            if (x % 10 != stack.pop()){
                return false;
            }

            x /= 10;
        }

        return true;
    }
}