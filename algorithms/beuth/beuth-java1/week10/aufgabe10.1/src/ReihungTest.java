/**
 * Class used to test Reihung.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class ReihungTest {
    public static void main(String[] args) {
       // CASE 1
       System.out.println("CASE 1");
       Reihung arr1 = new Reihung(-12, 12, 50);
       arr1.einlesen();
       System.out.println(arr1.toString());

       // CASE 2
       System.out.println("CASE 2");
       int[] input = {12, 32, 43, 33, 11, 0};
       Reihung arr2 = new Reihung(input);
       arr2.einlesen();
       System.out.println(arr2.toString());
    }
}
