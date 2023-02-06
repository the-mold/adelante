/**
 * Testprogramm fuer die Klasse ErgaenztesAuto.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class ErgaenztesAutoTest {
    public static void main(String[] args) {
        // EXCEPTIONS
        try {
            ErgaenztesAuto auto1 = new ErgaenztesAuto("sam", "sedan", "blue", 2000, 1500, -100000, "Berlin", "HH9887EE");
        } catch (IllegalArgumentException e) {
            System.out.println("Ausnahme aufgefangen: " + e.getMessage());
        }

        ErgaenztesAuto auto2 = new ErgaenztesAuto("sam", "sedan", "blue", 2100, 1500, 100000, "Berlin", "HH9887EE");
        try {
            auto2.getAlter();
        } catch (ErgaenztesAuto.FalscheErstzulassungAusnahme e) {
            System.out.println("Ausnahme aufgefangen: " + e.getMessage());
        } finally {
            System.out.println("done");
        }
    }
}
