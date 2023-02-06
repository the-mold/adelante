import java.util.Calendar;

/**
 * Klasse zum Erzeugen von ErgaenztesAuto Objekten.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 11/2018
 */

public class ErgaenztesAuto extends EinfachesAuto {
    // Instanzvariablen
    private String standort;
    private String fahrgestellnummer;

    /**
     * Konstruktor fuer die Klasse ErgaenztesAuto
     *
     */
    public ErgaenztesAuto() {
        super(DEFAULT_OWNER, DEFAULT_TYPE, DEFAULT_COLOR, DEFAULT_REGISTRATION, DEFAULT_POWER, DEFAULT_KM);

        this.standort = DEFAULT_CITY;
        this.fahrgestellnummer = DEFAULT_ID;
    }

    /**
     * Konstruktor fuer die Klasse ErgaenztesAuto
     *
     * @param standort
     *            Standort des Autos
     * @param fahrgestellnummer
     *            Fahrgestellnummer des Autos
     */
    public ErgaenztesAuto(String standort, String fahrgestellnummer) {
        super(DEFAULT_OWNER, DEFAULT_TYPE, DEFAULT_COLOR, DEFAULT_REGISTRATION, DEFAULT_POWER, DEFAULT_KM);
        this.standort = standort;
        this.fahrgestellnummer = fahrgestellnummer;
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
