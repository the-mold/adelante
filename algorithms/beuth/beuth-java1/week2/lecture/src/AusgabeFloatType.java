/**
 * Darstellung und Ausgabe von Fliesskommazahlen
 * 
 * @author Katrin Kraft
 * @version 1.01, 08/2001
 */

public class AusgabeFloatType {

    public static void main(String[] args) {

        float fa = 1.1f;
        double da = 22.0;
        double db = 1.02 * 3.3e27;
        float fb = 0f;
        float fc = 1.567f;
        double dc = 0.11E-04;
        float fd = .56f;

        System.out.println(" ");

        System.out.println("float fa = 1.1f;                  " + fa);
        System.out.println("double da = 22.0;                 " + da);
        System.out.println("double db = 1.02 * 3.3e27;        " + db);
        System.out.println("float fb = 0f;                    " + fb);
        System.out.println("float fc = 1.567f;                " + fc);
        System.out.println("double dc = 0.11E-04;             " + dc);
        System.out.println("float fd = .56f;                  " + fd);
    }
}