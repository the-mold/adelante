/**
 * Test program for the MyMath class test.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class MyMathTest {

    /**
     * main method to start and test the MyMath class. This is the starting point in the program.
     * 
     * @param args for the main method.
     *
     */
    public static void main(String[] args) {
        // print static methods of the math class

        // 1. sum
        System.out.println("Sum of 1,2,3: " + MyMath.sum(1, 2, 3));
        System.out.println("Sum of -1,-2,3: " + MyMath.sum(-1, -2, 3));

        // 2. mean
        System.out.println("Test empty returns 0: " + MyMath.mean());
        System.out.println("Mean of 1,2,3: " + MyMath.mean(1, 2, 3));
        System.out.println("Mean of 10,20,30: " + MyMath.mean(10, 20, 30));

        // 3. power
        System.out.println("2 to the power of 0: " + MyMath.power(2, 0));
        System.out.println("2 to the power of 2: " + MyMath.power(2, 2));
        System.out.println("2 to the power of 4: " + MyMath.power(2, 4));

        // 4. isPrime
        System.out.println("13 is prime: " + MyMath.isPrime(13));
        System.out.println("14 is prime: " + MyMath.isPrime(14));
        System.out.println("7 is prime: " + MyMath.isPrime(7));
    }
}
