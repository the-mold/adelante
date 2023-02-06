import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {

        //Test 1: N = 6
        Sort s1 = new Sort();
        int[] arr = new int[]{5, 3, 2, 7, 3, 4};
        int[] res = s1.QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(res));
        System.out.println("Comparison count: " + s1.comparisonCount);

        System.out.println("==================");

        //Test 2: N = 8
        Sort s2 = new Sort();
        int[] arr2 = new int[]{11, 15, 13, 8, 1, 10, 16, 12};
        int[] res2 = s2.QuickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(res2));
        System.out.println("Comparison count: " + s2.comparisonCount);

        System.out.println("==================");

        //Test 3: N = 12
        Sort s3 = new Sort();
        int[] arr3 = new int[]{0, 22, 1, 9, 0, 88, 102, 80, 15, 2, 66, 200};
        int[] res3 = s3.QuickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(res3));
        System.out.println("Comparison count: " + s3.comparisonCount);

        System.out.println("==================");

        //Test 3: N = 10000
        Sort s4 = new Sort();
        UtilitiesArraysFiles u = new UtilitiesArraysFiles();
        int[] arr4 = u.readInArray("QuickSort.txt");
        int[] res4 = s4.QuickSort(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(res4));
        System.out.println("Comparison count: " + s4.comparisonCount);
        u.writeArrayToFile(arr4, "sorted.txt");
    }
}
