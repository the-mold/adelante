/**
 * Class of different math functions.
 * 
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class MyMath {
    /**
     * sum method returns the sum of the set of numbers.
     *
     * @param intArr input int arguments.
     *
     * @return the sum.
     */
    public static int sum(int ...intArr) {
        int length = intArr.length;
        // handle no input case
        if (length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < length; i++){
            sum = sum + intArr[i];
        }

        return sum;
    }

    /**
     * mean method returns the of the set of numbers.
     * 
     * @param intArr input int arguments.
     *
     * @return the mean average.
     */
    public static int mean(int ...intArr) {
        int length = intArr.length;
        // handle no input case
        if (length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < length; i++){
            sum = sum + intArr[i];
        }

        return sum / length;
    }

    /**
     * power method returns power of a certain integer.
     *
     * @param n integer to be raised to power.
     *
     * @param power to which integer is raised.
     *
     * @return power of an integer.
     */
    public static double power(int n, int power) {
        return Math.pow(n, power);
    }

    /**
     * isPrime method checks if an integer is a prime number.
     *
     * @param n integer to be checked.
     *
     * @return bool of weather integer is prime.
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }

        return true;
    }
}
