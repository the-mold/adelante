public class BinaeresSuchen {
    public int callCount = 0;

    public int BinaeresSuchen(int[] arr, int x, int l, int r) {
        callCount++;

        if (l < r) {
            int i = (int) Math.floor((l+r) / 2);

            if (i > arr.length) {
                return 0;
            }

            if (arr[i] == x) {
                System.out.println("callCount is: " + callCount);
                return arr[i];
            }

            if (arr[i] < x) {
                return BinaeresSuchen(arr, x, i+1, r);
            } else {
                return BinaeresSuchen(arr, x, l, i);
            }
        }

        return 0;
    }
}
