package divisor_game;

public class Solution1 implements ISolution {
    public boolean divisorGame(int N) {
        if (N == 1){
             return false;
         }
         
         boolean[] dp = new boolean[N + 1];
         dp[2] = true;
 
         for (int i = 3; i < N + 1; ++i){
             for (int j = 0; j < i; ++j){
                 int candidate = i - j;
                 if (dp[candidate] && N % candidate == 0){
                     dp[i] = true;
                     break;
                 }
             }
         }
 
         return dp[N];
     }   
}