package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

/**
 */
public class ShellSorter implements Sorter {

    public void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int h = 1;
        while (h < (arr.length / 3)) {
            h = h * 3 + 1;
        }


        while (h > 0){
            for (int i = h;  i < arr.length; i++){
                int j = i;
                while (j >= h && lessThan(arr[j], arr[j - h])){
                    swap(arr, j, j - h);
                    j -= h;
                }
            }

            h = (h - 1) / 3;
        }
    }

}