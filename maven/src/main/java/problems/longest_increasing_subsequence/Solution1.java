package problems.longest_increasing_subsequence;

// brute force
public class Solution1 implements ISolution {
    public int lengthOfLIS(int[] nums) {
        int retVal = 1;

        for (int idx = 0; idx < nums.length; ++idx){
            int length = lengthOfLIS(nums, idx);
            retVal = Math.max(retVal, length);
        }

        return retVal;
    }

    public int lengthOfLIS(int[] nums, int offset){
        int length = 1;
        int last = nums[offset];
        while (++offset < nums.length){
            int curr = nums[offset];
            if (curr > last){
                ++length;
            }

            last = curr;
        }

        return length;
    }
}