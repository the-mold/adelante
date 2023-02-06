import de.vfh.gp1.bib.clockman.*;
import java.awt.Color;

/**
 * Ein erstes Programm zum Kennenlernen von Java.
 * 
 * @author Lena P.
 * @version 1.01, 09/2011
 **/

public class UebClockman1a {

    /**
     * Soll die Klasse von der Eingabekonsole aus aufgerufen werden koennen,
     * dann muss die hier aufgefuehrte main-Methode enthalten sein. Diese Methode
     * ist der definierte Einstiegspunkt fur die Ausfuehrung.
     */
    public static void main(String[] args) {

        // Reserviere for die Klasse "Clockman" eine Variable
        // mit dem Namen "meinClockman".
        Clockman_Frame meinClockman;

        // Reserviere for die Klasse Color (Farbe) eine Variable
        // mit dem Namen colMeineFarbe.
        Color colMeineFarbe = new Color(238, 0, 95);

        // Fuelle die Variable "meinClockman" mit einer neuen Instanz
        // der Klasse "Clockman".
        meinClockman = new Clockman_Frame(400, 400);

        // Setze die Gesichtsfarbe des Clockman auf den Wert, der in
        // der Variable colMeineFarbe gespeichert ist.
        meinClockman.setzeGesichtsfarbe(colMeineFarbe);
        System.out.println("works");
    }

}