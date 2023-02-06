/**
 * Testprogramm fuer die Klasse ErgaenztesAuto.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class ErgaenztesAutoTest {
    public static void main(String[] args) {
        ErgaenztesAuto auto1 = new ErgaenztesAuto("sam", "sedan", "blue", 2013, 1500, 100000, "Berlin", "HH9887EE");
        System.out.println(auto1.toString());
        auto1.setzeNeuesZiel("Las Vegas", 2000);
        auto1.setzeNeuesZiel("Atlanta", 1000);

        System.out.println("===================================");
        ErgaenztesAuto auto2 = new ErgaenztesAuto();
        System.out.println(auto2.toString());
        auto2.setzeNeuesZiel("San Diego", 500);
        auto2.setzeNeuesZiel("San Hose", 1500);
    }
}
