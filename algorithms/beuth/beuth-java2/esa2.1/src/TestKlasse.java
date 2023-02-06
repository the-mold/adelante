import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to test DatInfo, DatKop, VerzErst.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class TestKlasse {
    private final static String htmlFile = "assets/datei1702_vor.html";
    private final static String javaFile = "assets/MeinAuto.java";
    private final static String graphicFile = "assets/MeinGraphik.jpg";

    /**
     * Read and return string input from the console.
     *
     * @param str string message.
     * @throws IOException
     */
    public static String textInput(String str) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(str + " : ");
        return reader.readLine();
    }

    /**
     * Creates custom folders based on user input.
     *
     * @param str string message.
     * @throws IOException
     */
    public static void createCustomFolders(String str) throws IOException {
        String ans = textInput(str);
        if (!ans.equalsIgnoreCase("j")) {
            return;
        }
        String path = textInput("Bitte Pfad eingeben");
        if (path.isEmpty()) {
            System.out.println("Kein Pfad. Exit");
            return;
        }
        VerzErst.erstellen(path);
        createCustomFolders(str);
    }

    /**
     * User input of file info is needed.
     *
     * @throws IOException
     */
    public static boolean getFileInfoQuestion() throws IOException {
        String ans = textInput("Möchten Sie Fileinfo? (J)a oder (n)ein?");
        if (!ans.equalsIgnoreCase("j")) {
            return false;
        }
        return true;
    }
    public static void fileInfoWrap() throws IOException {
        fileInfo();

        if (getFileInfoQuestion()) {
            fileInfoWrap();
        }
    }

    /**
     * User input about a certain file that user whats to get more info about.
     *
     */
    public static void fileInfo() throws IOException {
        String fileID = textInput("Welchen File? datei1702_vor.html(1), MeinAuto.java(2), MeinGraphik.jpg(3)");
        String filePath;
        if (fileID.equals("1")) {
            filePath = htmlFile;
        } else if (fileID.equals("2")) {
            filePath = javaFile;
        } else if (fileID.equals("3")) {
            filePath = graphicFile;
        } else {
            String ans = textInput("Ich habe es nicht verstanden. Noch mal Probieren? (J)a oder (n)ein?");
            if (ans.equalsIgnoreCase("j")) {
                fileInfoWrap();
                return;
            }
            return;
        }

        if (filePath.equals("")) {
            System.out.println("Ich habe keinen File gefunden.");
            return;
        }

        fileDetails(filePath);
    }

    /**
     * File details for a certain file.
     *
     * @param path Path to a file
     * @throws IOException
     */
    public static void fileDetails(String path) throws IOException {
        System.out.println("File ist " + path);
        File f = new File(path);
        String ans = textInput("Wählen Sie:\nDateigröße 1;\nVerzeichnis oder Datei 2;\nLetzter Tag der Änderung 3;\nSchreib- und Lesezugriff erlaubt ja/nein 4");
        switch (ans) {
            case "1":
                DatInfo.groesseAusgeben(f);
                break;
            case "2":
                DatInfo.dateiOderVerzeichnis(f);
                break;
            case "3":
                DatInfo.aenderungAusgeben(f);
                break;
            case "4":
                DatInfo.lesenSchreiben(f);
                break;
            default:
                System.out.println("Befehl " + ans + " ist nicht bekannt");
        }

        ans = textInput("Wollen Sie noch etwas zum File wissen? (J)a oder (n)ein?");
        if (ans.equalsIgnoreCase("j")) {
            fileDetails(path);
        }
    }

    /**
     * Test-Mainfunktion, um alle Klassen zu testen.
     *
     * @param args Pfad
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 1. folder structure
        VerzErst.erstellen("Dateimanagement/Dokumente/HTML");
        VerzErst.erstellen("Dateimanagement/Dokumente/Graphik");
        VerzErst.erstellen("Dateimanagement/Dokumente/Java");

        // 2. create other folders
        createCustomFolders("Wollen Sie eine weitere Verzeichnisstruktur auf Ihrem Rechner anlegen? (J)a oder (n)ein?");

        // 3. copy data
        DatKop.kopieren(htmlFile, "Dateimanagement/Dokumente/HTML/datei1702_vor.html");
        DatKop.kopieren(javaFile, "Dateimanagement/Dokumente/Java/MeinAuto.java");
        DatKop.kopieren(graphicFile, "Dateimanagement/Dokumente/Graphik/MeinGraphik.jpg");

        // 4. Print file info
        if (getFileInfoQuestion()) {
            fileInfoWrap();
        }

        System.out.println("Bye");
    }
}
