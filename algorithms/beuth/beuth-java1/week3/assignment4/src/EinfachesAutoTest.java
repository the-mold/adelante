/**
 * Testprogramm fuer die Klasse EinfachesAuto.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class EinfachesAutoTest {
    public static void main(String[] args) {
        EinfachesAuto auto1 = new EinfachesAuto("sam", "sedan", "blue", 2013, 1500, 100000);
        EinfachesAuto auto2 = new EinfachesAuto("sam", "hatchback", "yellow", 2018, 2000, 20000);
        EinfachesAuto auto3 = new EinfachesAuto("sam", "crossover", "black", 2016, 2000, 150000);

        auto1.meldung();
        System.out.println("auto1 age: " + auto1.getAlter());
        auto2.meldung();
        System.out.println("auto2 age: " + auto2.getAlter());
        auto3.meldung();
        System.out.println("auto3 age: " + auto3.getAlter());
    }
}
