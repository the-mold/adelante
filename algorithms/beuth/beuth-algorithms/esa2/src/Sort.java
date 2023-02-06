public class Sort {
    public int comparisonCount = 0;

    public int[] QuickSort(int[] arr, int p, int r) {
        if (p < r) {
          int q = Partition(arr, p, r);
          QuickSort(arr, p, q - 1);
          QuickSort(arr, q + 1, r);
        }

        return arr;
    }

    public int Partition(int[] arr, int p, int r) {
        // increase the comparison count
        comparisonCount = comparisonCount + r - p;

        // assign the pivot value. All values are compared against it.
        int x = arr[r];

        // pointer. Moves from left to right in the array to figure out where to place the pivot value in the end of the function.
        int i = p - 1;

        // checks 
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                swapArrayItems(arr, i, j);
            }
        }

        i = i + 1;
        swapArrayItems(arr, i, r);

        return i;
    }

    private int[] swapArrayItems(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
    }
}
