package longest_fibonacci_subsequence;

import java.util.*;

// brute
public class Solution1 implements ISolution {
    public int lenLongestFibSubseq(int[] A) {
        
        int retVal = 0;

        Set<Integer> set = new HashSet<Integer>(A.length);
        for (int a: A){
            set.add(a);
        }

        for (int i = 0; i < A.length - 1; ++i){
            for (int j = i + 1; j < A.length; ++j){
                int a = A[i];
                int b = A[j];
                int c = a + b;

                int fibLen = 2;
                while (set.contains(c)){
                    a = b;
                    b = c;
                    c = a + b;

                    fibLen++;
                    retVal = Math.max(retVal, fibLen);
                }
            }
        }

        return retVal > 2 ? retVal : 0;
    }
}