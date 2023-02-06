/**
 * Class used to test Geschenkpapier.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 *
 */

public class GeschenkpapierTest {
    public static void main(String[] args) {
       Geschenkpapier.simpleWrap("", 2, 3);
       Geschenkpapier.simpleWrap(Geschenkpapier.DECORATION_STARS, 12, 10);

       System.out.println();

       Geschenkpapier.complexWrap(Geschenkpapier.DECORATION_HAPPY, Geschenkpapier.DECORATION_SAD, 12, 10);
    }
}
