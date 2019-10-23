package problems.counting_bits;

// naive aproach, O(n*8)
public class Solution1 implements ISolution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        for (int idx = 0; idx <= num; idx++){
            ans[idx] = setBits(idx);
        }

        return ans;
    }

    private int setBits(int num){
        int count = 0;
        for (int idx = 0; idx < 8; ++idx){
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}