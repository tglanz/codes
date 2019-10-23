package sorting;

public interface Sorter {

    void sort(Comparable[] arr);

    public static boolean lessThan(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable arr[], int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean sorted(Comparable arr[]){
        if (arr.length <= 1){
            return true;
        }

        for (int i = 1; i < arr.length; ++i){
            if (lessThan(arr[i], arr[i - 1])){
                return false;
            }
        }

        return true;
    }
}