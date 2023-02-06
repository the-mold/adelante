/**
 * Class used to test Zeichenkettenanalyse.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class ZeichenkettenanalyseTest {
    public static void main(String[] args) {
        Zeichenkettenanalyse za = new Zeichenkettenanalyse();

        // vokaleZaehlen
        System.out.println("vokaleZaehlen=============");
        int[] vocals = za.vokaleZaehlen("awesome string all");
        System.out.println(za.arrToString(vocals));

        // zeichenZaehlen
        System.out.println("zeichenZaehlen=============");
        System.out.println(za.zeichenZaehlen("abracadabra",'a'));
        System.out.println(za.zeichenZaehlen("abracadabra",'d'));

        // zeichenZaehlenArr
        System.out.println("zeichenZaehlenArr=============");
        String inputString = "awesome string all";
        char[] inputChars = new char[]{'a', 's', 'l', 'k'};
        int[] charsNumber = za.zeichenZaehlenArr(inputString, inputChars);
        System.out.println("Zu analysierende Zeichenkette: Wieviele Vokale stehen in diesem Satz?");
        System.out.println("Satz: " + inputString);
        System.out.println("Die Zeichenkette enthaelt:");
        for (int i = 0; i < inputChars.length; i++) {
            System.out.println("Anzahl des Zeichens " + inputChars[i] + ": " + charsNumber[i]);
        }
    }
}
