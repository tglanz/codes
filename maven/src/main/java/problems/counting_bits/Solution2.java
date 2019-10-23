package problems.counting_bits;

// better aproach, O(n)
public class Solution2 implements ISolution {
    public int[] countBits(int num) {
        /*
            0    00000000
            1  0 00000001
            2  1 00000010
            3    00000011
            4  2 00000100
            5    00000101
            6    00000110
            7    00000111
            8  3 00001000
            9    00001001
            10   00001010
            11   00001011
            12   00001100
            13   00001101
            14   00001110
            15   00001111
            16 4 00010000
        */

        int[] ans = new int[num + 1];
        
        int power2 = 1;
        int nextPower2 = 2;

        for (int idx = 1; idx <= num; ++idx){
            if (idx == nextPower2){
                power2 = nextPower2;
                nextPower2 *= 2;
            }

            ans[idx] = 1 + ans[idx - power2];
        }

        return ans;
    }
}