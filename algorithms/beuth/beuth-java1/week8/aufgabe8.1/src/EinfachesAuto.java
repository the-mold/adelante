import java.util.Calendar;

/**
 * Klasse zum Erzeugen von Auto Objekten.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 11/2018
 */

public class EinfachesAuto {
    public static int DEFAULT_REGISTRATION = 2010;
    public static int DEFAULT_POWER = 1500;
    public static int DEFAULT_KM = 100000;
    public static String DEFAULT_OWNER = "Max";
    public static String DEFAULT_TYPE = "sedan";
    public static String DEFAULT_COLOR = "grey";
    public static String DEFAULT_CITY = "Los Angeles";
    public static String DEFAULT_ID = "DD1234XX";
    
    // Instanzvariablen
    public String besitzer;
    public String autotyp;
    public String farbe;
    public int erstzulassung;
    public int leistung;
    public int kmStand;

    /**
     * Konstruktor fuer die Klasse EinfachesAuto
     * 
     * @param besitzer
     *            Name des Autobesitzers
     * @param autotyp
     *            Typ des Autos
     * @param farbe
     *            Farbe des Autos
     * @param erstzulassung
     *            Jahreszahl der Autozulassung
     * @param leistung
     *            PS-Zahl des Autos
     * @param kmStand
     *            Kilometerstand des Autos
     */

    public EinfachesAuto(String besitzer, String autotyp, String farbe, int erstzulassung, int leistung, int kmStand) {
        this.besitzer = besitzer;
        this.autotyp = autotyp;
        this.farbe = farbe;
        this.erstzulassung = erstzulassung;
        this.leistung = leistung;
        this.kmStand = kmStand;
    }

    /**
     * Die Methode getAlter() dient zur Errechnung des Autoalters ueber die
     * Erstzulassung.
     * 
     * @return int: Alter des Autos
     */
    public int getAlter() {
        // Ermittlung des aktuellen Jahres
        Calendar aktuellerKalender = Calendar.getInstance();
        int aktuellesJahr = aktuellerKalender.get(Calendar.YEAR);
        return aktuellesJahr - this.erstzulassung;
    }

    /**
     * Die Methode meldung() gibt die Attribute "farbe" und "besitzer" auf der
     * Standardausgabe aus.
     */
    public void meldung() {
        System.out.print("Hier gruesst das " + this.farbe + "e ");
        System.out.print("Auto von " + this.besitzer);
    }
}
