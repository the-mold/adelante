public class counter {
    private static void startCount(int targetValue, int count) {
        if (count == targetValue) {
            return;
        }

        startCount(targetValue, count + 1);
    }

    public static void main(String []args) {
        int targetValue = 5;
        int count = 0;

        startCount(5, 0);
    }
}
