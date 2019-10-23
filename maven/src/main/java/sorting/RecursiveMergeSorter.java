package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

/**
 */
public class RecursiveMergeSorter implements Sorter {
    public void sort(Comparable[] arr) {
        if (arr.length <= 1) return;

        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
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