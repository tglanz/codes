package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

/**
 */
public class BottomUpMergeSorter implements Sorter {
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) return;

        Comparable[] aux = new Comparable[arr.length];
        
        for (int chunk = 1; chunk < arr.length; chunk *= 2) {
            for (int lo = 0; lo < arr.length - chunk; lo += chunk + chunk){
                int mid = lo + chunk - 1;
                int hi = Math.min(mid + chunk, arr.length - 1);
                merge(arr, aux, lo, mid, hi);
            }
        }
    }

    private void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
        for (int i = lo; i <= hi; ++i){
            aux[i] = arr[i];
        }

        int lcur = lo;
        int rcur = mid + 1;

        for (int i = lo; i <= hi; ++i){
            if (lcur > mid) {
                arr[i] = aux[rcur++];
            } else if (rcur > hi) {
                arr[i] = aux[lcur++];
            } else if (lessThan(aux[lcur], aux[rcur])) {
                arr[i] = aux[lcur++];
            } else {
                arr[i] = aux[rcur++];
            }
        } 
    }
}