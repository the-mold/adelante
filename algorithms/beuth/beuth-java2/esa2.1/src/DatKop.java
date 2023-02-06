import java.io.*;

/**
 * Class to copy a file.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class DatKop {
    /**
     * Kopiert eine Datei von quelle nach ziel und gibt eine
     * Statusmeldung auf der Standardausgabe über den Erfolg aus.
     *
     * @param quelle Pfad zur Quelldatei
     * @param ziel Pfad zur Zieldatei
     */
    public static void kopieren(String quelle, String ziel) throws IOException {
        FileInputStream in = new FileInputStream(quelle);
        FileOutputStream out = new FileOutputStream(ziel);

        long fSize = (new File(quelle)).length();
        byte[] b = new byte[(int) fSize];

        // read data from src and write it to dest
        int len;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }

        // close streams
        out.close();
        in.close();

        // Success message
        System.out.println("Datei '" + quelle + "' wurde in die Datei '" + ziel + "' kopiert.");
    }

    /**
     * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen.
     *
     * @param args String args[0]: Quelle; String args[1]: Ziel
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("io Fehler: zwei Parameters sind nich optional");
            System.exit(1);
        }
        // Datei kopieren
        kopieren(args[0], args[1]);
    }
}
