package reverseinteger;

public class Solution1 implements ISolution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x *= sign;
        
        int y = 0;
        
        while (x > 0){
            if (y > Integer.MAX_VALUE / 10){
                return 0;
            }
            
            y = (y * 10) + (x % 10);
            x /= 10;
        }
        
        return y * sign;
    }
}