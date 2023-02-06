import java.util.Calendar;

/**
 * Klasse zum Erzeugen von ErgaenztesAuto Objekten.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */

public class ErgaenztesAuto {
    // Klassenvariablen
    private static int DEFAULT_REGISTRATION = 2010;
    private static int DEFAULT_POWER = 1500;
    private static int DEFAULT_KM = 100000;
    private static String DEFAULT_OWNER = "Max";
    private static String DEFAULT_TYPE = "sedan";
    private static String DEFAULT_COLOR = "grey";
    private static String DEFAULT_CITY = "Los Angeles";
    private static String DEFAULT_ID = "DD1234XX";

    // Instanzvariablen
    private int erstzulassung;
    private int leistung;
    private int kmStand;
    private String besitzer;
    private String autotyp;
    private String farbe;
    private String standort;
    private String fahrgestellnummer;


    /**
     * Konstruktor fuer die Klasse ErgaenztesAuto
     *
     */
    public ErgaenztesAuto() {
        this(DEFAULT_OWNER, DEFAULT_TYPE, DEFAULT_COLOR, DEFAULT_REGISTRATION, DEFAULT_POWER, DEFAULT_KM, DEFAULT_CITY, DEFAULT_ID);
    }

    /**
     * Konstruktor fuer die Klasse ErgaenztesAuto
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
     * @param standort
     *            Standort des Autos
     * @param fahrgestellnummer
     *            Fahrgestellnummer des Autos
     */
    public ErgaenztesAuto(String besitzer, String autotyp, String farbe, int erstzulassung, int leistung, int kmStand, String standort, String fahrgestellnummer) throws IllegalArgumentException {
        if (kmStand < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }

        this.besitzer = besitzer;
        this.autotyp = autotyp;
        this.farbe = farbe;
        this.erstzulassung = erstzulassung;
        this.leistung = leistung;
        this.kmStand = kmStand;
        this.standort = standort;
        this.fahrgestellnummer = fahrgestellnummer;
    }

    /**
     * Die Methode getAlter() dient zur Errechnung des Autoalters ueber die
     * Erstzulassung.
     * 
     * @return int: Alter des Autos
     */
    public int getAlter() throws FalscheErstzulassungAusnahme {
        // Ermittlung des aktuellen Jahres
        Calendar aktuellerKalender = Calendar.getInstance();
        int aktuellesJahr = aktuellerKalender.get(Calendar.YEAR);

        if (aktuellesJahr < this.erstzulassung) {
            throw new FalscheErstzulassungAusnahme("invalid year");
        }

        return aktuellesJahr - this.erstzulassung;
    }

    static class FalscheErstzulassungAusnahme extends Exception {
        public FalscheErstzulassungAusnahme(String s) {
            super(s);
        }
    }

    /**
     * Die Methode meldung() gibt die Attribute "farbe" und "besitzer" auf der
     * Standardausgabe aus.
     */
    public void meldung() {
        System.out.print("Hier gruesst das " + this.farbe + "e ");
        System.out.print("Auto von " + this.besitzer);
    }

    /**
     * Die Methode toString() gibt einString von allen Attributen
     * Standardausgabe aus.
     */
    public String toString() {
        return "Owner: " + this.besitzer +
                "\nType: " + this.autotyp +
                "\nColor: " + this.farbe +
                "\nFirst Registration: " + this.erstzulassung +
                "\nPower: " + this.leistung +
                "\nkm: " + this.kmStand +
                "\ncity: " + this.standort +
                "\nid: " + this.fahrgestellnummer;
    }

    /**
     * setzeNeuesZiel Methode meldet die Entfernung und speichert den neuen Standort.
     *
     * @param ziel als Reiseziel
     * @param entfernung als Entfernung zum Ziel
     */
    public void setzeNeuesZiel(String ziel, int entfernung) {
        String str = "Auto fährt von " + this.standort + " nach " + ziel + ".\nDie Entfernung beträgt " + entfernung + " km.";
        this.standort = ziel;
        System.out.println(str);
    }
}
