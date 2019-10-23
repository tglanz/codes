package shuffling;

import java.util.Random;

import static sorting.Sorter.swap;

public class KnuthShuffler implements Shuffler {
    public void shuffle(Comparable[] arr) {
        Random random = new Random();
        for (int i = 1; i < arr.length; ++i){
            int j = random.nextInt(i + 1);
            swap(arr, i, j);
        }
    }
}