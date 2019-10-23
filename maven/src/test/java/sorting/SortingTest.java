package sorting;

import sorting.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.*;

public class SortingTest {

    private void sortAndAssert(Sorter sorter, Comparable[] arr) {
        
        String unsortedString = Arrays
            .stream(arr)
            .map(item -> item.toString())
            .collect(Collectors.joining(","));

        sorter.sort(arr);

        String sortedString = Arrays
            .stream(arr)
            .map(item -> item.toString())
            .collect(Collectors.joining(","));

        assertTrue(
            Sorter.sorted(arr),
            unsortedString + " <> " + sortedString);
    }

    private void runTests(Sorter sorter) {
        sortAndAssert(sorter, new Integer[] { });
        sortAndAssert(sorter, new Integer[] { 0, 1, 2, 3 });
        sortAndAssert(sorter, new Integer[] { 3, 2, 1, 0 });
        sortAndAssert(sorter, new Integer[] { 4, 7, 2, 1 });
        sortAndAssert(sorter, new Integer[] { 4, 7, 2, 3, 5, 1, 2, 6, 20, 1 });
        sortAndAssert(sorter, new String[] { "x", "a", "b" });
    }

    @Test
    public void testSelectionSorter() {
        runTests(new SelectionSorter());
    }

    @Test
    public void testInsertionSorter() {
        runTests(new InsertionSorter());
    }

    @Test
    public void testShellSorter() {
        runTests(new ShellSorter());
    }

    @Test
    public void testRecursiveMergeSorter() {
        runTests(new RecursiveMergeSorter());
    }

    @Test
    public void testBottomUpMergeSorter() {
        runTests(new BottomUpMergeSorter());
    }

    @Test
    public void testQuickSorter() {
        runTests(new QuickSorter());
    }
}