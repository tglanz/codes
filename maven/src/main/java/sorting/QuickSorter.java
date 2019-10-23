package sorting;

import sorting.Sorter;
import static sorting.Sorter.*;

import java.util.Random;

import shuffling.KnuthShuffler;
import shuffling.Shuffler;;

public class QuickSorter implements Sorter {

    private final static Shuffler shuffler = new KnuthShuffler();

    public void sort(Comparable[] arr) {
        if (arr.length <= 1) return;
        shuffler.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi){
        if (hi <= lo) return;
        int pivot = partition(arr, lo, hi);
        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    public int partition(Comparable[] arr, int lo, int hi){
        int i = lo + 1;
        int j = hi;
        while (true){
            while (lessThan(arr[i], arr[lo]) && i < hi){
                i++;
            }

            while (lessThan(arr[lo], arr[j]) && j > lo){
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, lo, j);
        return j;
    }
}