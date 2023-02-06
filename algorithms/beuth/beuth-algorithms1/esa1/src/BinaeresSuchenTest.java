public class BinaeresSuchenTest {
    public static void main(String[] args) {

        // get test array
        int[] arr1 = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr1[i - 1] = i;
        }
        BinaeresSuchen b1 = new BinaeresSuchen();
        System.out.println("res n=100: " + b1.BinaeresSuchen(arr1, 99, 1, 101));

        // get test array
        int[] arr2 = new int[1000];
        for (int i = 1; i <= 1000; i++) {
            arr2[i - 1] = i;
        }
        BinaeresSuchen b2 = new BinaeresSuchen();
        System.out.println("res n=1000: " + b2.BinaeresSuchen(arr2, 999, 1, 1001));


        // get test array
        int[] arr3 = new int[10000];
        for (int i = 1; i <= 10000; i++) {
            arr3[i - 1] = i;
        }
        BinaeresSuchen b3 = new BinaeresSuchen();
        System.out.println("res n=10000: " + b3.BinaeresSuchen(arr3, 9999, 1, 10001));
    }
}
