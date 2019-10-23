package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

/**
 * invariance - items to the left of the cursor are sorted
 * 
 * move cursor left to right
 * 
 * keep invariance by swapping current element with bigger
 * elements to the left until there is no bigger element
 */
public class InsertionSorter implements Sorter {
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) return;

        for (int i = 1; i < arr.length; ++i){
            int j = i;
            while (j > 0 && lessThan(arr[j], arr[j - 1])){
                swap(arr, j, j - 1);
                --j;
            }
        }
    }
    
}