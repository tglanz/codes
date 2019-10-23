package problems.kth_min_selection;

// QuickSelect
public class Solution1 implements ISolution {
    public int kthMin(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;

        while (hi > lo){
            int j = partition(arr, lo, hi);

            if (k < j) hi = j - 1;
            else if (k > j) lo = j + 1;
            else return arr[k];
        }

        return arr[k];
    }

    private int partition(int[] arr, int lo, int hi){
        int i = lo + 1;
        int j = hi;
        while (true){
            while (arr[i] < arr[lo] && i < hi){
                i++;
            }

            while (arr[lo] < arr[j] && j > lo){
                j--;
            }

            if (i >= j) {
                break;
            }

            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }

        int swap = arr[lo];
        arr[lo] = arr[j];
        arr[j] = swap;
        return j;
    }
}