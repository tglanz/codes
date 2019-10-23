package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

/**
 * invariance - items to the left of the cursor are sorted
 * move cursor left to right
 * keep invariance by swapping current element with the minimum ahead
 */
public class SelectionSorter implements Sorter {
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) return;

        for (int i = 0; i < arr.length; ++i){
            int mindex = i;
            for (int j = i + 1; j < arr.length; ++j){
                if (lessThan(arr[j], arr[mindex])){
                    mindex = j;
                }
            }

            swap(arr, i, mindex);
        }
    }
    
}