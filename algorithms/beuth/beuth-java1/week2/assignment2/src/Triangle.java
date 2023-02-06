/**
 * Eine Klasse zum Erzeugen von Dreieck-Objekten. Ein Dreieck hat 3 Seiten a, b
 * und c die den folgenden Eigenschaften entsprechen muessen: Erstens, alle drei
 * Seiten muessen einen positiven Wert haben. Zweitens, jede Seite muss kurzer sein
 * als die Summe von die anderen.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class Triangle {
    private static final int DEFAULT_A = 3;
    private static final int DEFAULT_B = 4;
    private static final int DEFAULT_C = 5;

    // Drei Attribute fuer die drei Seiten des Dreiecks
    private float a;
    private float b;
    private float c;

    /**
     * Der Konstruktor erzeugte Objekte vom Typ Triangle mit den Standardwerten
     * 3, 4 and 5.
     */
    public Triangle() {
        // So wird ein anderer Konstruktor in der Klasse aufgerufen
        this(DEFAULT_A, DEFAULT_B, DEFAULT_C);
    }

    /**
     * Der Konstruktor erzeugte Objekte vom Typ Triangle. Wenn die uebergebenen
     * Werte fuer die drei Seiten nicht den, Vorschriften fuer ein Dreieck
     * entsprechen, wird ein Dreieck mit den Standardwerten 3, 4 und 5 erzeugt.
     * 
     * @param a
     *            erste Seite
     * @param b
     *            zweite Seite
     * @param c
     *            dritte Seite
     */

    public Triangle(float a, float b, float c) {
        if (a <= 0 || b <= 0 || c <= 0 || a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Fehler in den Uebergabeparametern. Ein Dreieck mit Standardwerten wird erzeugt.");
            // In den folgenden Zuweisungen wird ein int Wert in einen float
            // Wert umgewandelt.
            // Das Schluesselwort this wird benutzt um das Attribut a (this.a)
            // vom Parameter a zu unterscheiden und aehnlich fuer b und c
            this.a = DEFAULT_A;
            this.b = DEFAULT_B;
            this.c = DEFAULT_C;
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    /**
     * Diese Methode ueberprueft ob das Dreieck gleichseitig ist.
     * 
     * @return true wenn das Dreieck gleichseitig ist, sonst false.
     */
    public boolean isEquilateral() {
        return (a == b && b == c);
    }

    /**
     * Diese Methode liefert den Umfang des Dreiecks.
     *
     * @return float Umfang des Dreiecks.
     */
    public float circumference() {
        return this.a + this.b + this.c;
    }

    /**
     * Diese Methode prueft, ob das Dreieck rechtwinklig ist.
     *
     * @return boolean ist Dreieck rechtwinklig.
     */
    public boolean isRightAngled() {
        return ((this.a * this.a + this.b * this.b) == this.c * this.c)
                || ((this.c * this.c + this.b * this.b) == this.a * this.a)
                || ((this.a * this.a + this.c * this.c) == this.b * this.b);
    }
}
