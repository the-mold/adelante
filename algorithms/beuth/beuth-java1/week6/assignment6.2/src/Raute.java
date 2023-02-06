/**
 * Raute class used to practice loops.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 *
 */

public class Raute {
    static void print(int size) {

        for (int i = 1; i < size; i += 2) {
            for (int j = 0; j < (size -1) - i / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }

        for (int i = (size -3); i > 0; i -= 2) {
            for (int j = 0; j < (size -1) - i / 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
