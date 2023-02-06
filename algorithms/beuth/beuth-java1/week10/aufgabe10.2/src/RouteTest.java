/**
 * Class used to test Route.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class RouteTest {
    public static void main(String[] args) {
       // Case 1
       System.out.println("Case 1: valid entry");
       Route r = new Route();
       String[] input = {r.CITY_AACHEN, r.CITY_BERLIN, r.CITY_ESSEN, r.CITY_HAMBURG, r.CITY_DRESDEN};
       System.out.println(r.routeDerRundReiseBerechnen(input));

       System.out.println("===================================");

       // Case 2
       System.out.println("Case 2: exception");
       Route rInvalid = new Route();
       String[] inputInvalid = {r.CITY_AACHEN, r.CITY_BERLIN, "awesome city"};
       try {
         String res = rInvalid.routeDerRundReiseBerechnen(inputInvalid);
       } catch (IllegalArgumentException e) {
          System.out.println("Ausnahme aufgefangen: " + e.getMessage());
       } finally {
          System.out.println("done");
       }
    }
}
