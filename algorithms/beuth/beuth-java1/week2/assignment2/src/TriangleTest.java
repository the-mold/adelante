/**
 * Testprogramm fuer die Klasse Triangle.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class TriangleTest {
    /**
     * Main-Methode zum Starten und Testen der Klasse Triangle.
     * 
     * @param args
     *            Uebergabeparameter fuer das Programm
     */
    public static void main(String[] args) {

        // ein Dreieck mit richtigen Werten nicht gleichseitig
        Triangle dreieck1 = new Triangle(1, 2.5f, 3);
        System.out.println(dreieck1.isEquilateral());
        // ein Dreieck mit richtigen Werten ist gleichseitig
        Triangle dreieck2 = new Triangle(3.2f, 3.2f, 3.2f);
        System.out.println(dreieck2.isEquilateral());
        // ein Dreieck mit falschen Werten
        Triangle dreieck3 = new Triangle(-1, 2, 3);
        // ein Dreieck mit falschen Werten
        Triangle dreieck4 = new Triangle(1, 2, 3);
        // ein Dreieck mit default Werten
        Triangle dreieck5 = new Triangle();
        // Gleichseitig pruefen
        System.out.println("Ist gleichseitig: " + dreieck5.isEquilateral());

        // Rechtwinkliges Dreieck
        Triangle dreieck6 = new Triangle(3,5,4);

        // Nicht rechtwinkliges Dreieck
        Triangle dreieck7 = new Triangle(3,5,6);
        System.out.println("Ist dreieck6 rechtwinkliges: " + dreieck6.isRightAngled() + ", erwartet: true");
        System.out.println("Ist dreieck2 rechtwinkliges: " + dreieck2.isRightAngled() + ", erwartet: false");
        System.out.println("Ist dreieck7 rechtwinkliges: " + dreieck7.isRightAngled() + ", erwartet: false");

        // Test Umfang
        System.out.println("Umfang dreieck6: " + dreieck6.circumference() + ", erwartet: 12.0");
        System.out.println("Umfang dreieck7: " + dreieck7.circumference() + ", erwartet: 14.0");
    }
}