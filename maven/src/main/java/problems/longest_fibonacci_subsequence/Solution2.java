package problems.longest_fibonacci_subsequence;

import java.util.*;

// dp
public class Solution2 implements ISolution {
    public int lenLongestFibSubseq(int[] A) {
        int ans = 1;

        // Just reverse the indices for quick access
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>(A.length);
        for (int idx = 0; idx < A.length; ++idx){
            indices.put(A[idx], idx);
        }

        // Build a dp array
        // The value at (i, j) indicates the longest fib subseq, up to consequtive pair (A[i], A[j])
        // The final answer is the max value of these
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; ++i){
            for (int j = 0; j < A.length; ++j){
                dp[i][j] = 2;
            }
        }

        // Fill the dp
        for (int j = 1; j < A.length - 1; ++j){
            for (int k = j + 1; k < A.length; ++k){
                int xi = A[k] - A[j];
                int i = indices.getOrDefault(xi, -1);
                if (i >= 0){
                    int length = dp[i][j] + 1;
                    dp[j][k] = length;
                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }
}