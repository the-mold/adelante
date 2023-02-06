/** Rechenwerk.java
 *  Klasse zur Ausfuehrung der vier Grundrechenarten
 *  fuer ganze Zahlen
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class Rechenwerk {
    private Gui rechner;
    private final static char ADDITION = '+';
    private final static char DIVISION = '/';
    private final static char SUBSTRACTION = '-';
    private final static char MULTIPLICATION = '*';
    
    public Rechenwerk() {
        rechner = new Gui();
    }

    /**
     * rechnen Methode fuert alle Berechnungen fuer Klasse Gui.
     * @param zahl1 int
     * @param zahl2 int
     * @param op char
     * @return int
     */
    public int rechnen (int zahl1, int zahl2, char op) {
        switch(op) {
            case ADDITION:
                return zahl1 + zahl2;
            case DIVISION:
                return zahl1 / zahl2;
            case SUBSTRACTION:
                return zahl1 - zahl2;
            case MULTIPLICATION:
                return zahl1 * zahl2;
        }

        System.out.println("unrecognized operation type. Returning 0");
        return 0;
    }
    
    public static void main (String[] args) {
        new Rechenwerk();
    }
}
