/**
 * Class used to get Zeichenkettenanalyse.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class Zeichenkettenanalyse {
    public String arrToString(int[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res.concat("[" + arr[i] + "]");
        }

        return res;
    }

    public int[] vokaleZaehlen (String zeichenkette) {
        String[] vocals = {"a", "e", "i", "o", "u"};
        char letter;
        int count;
        int[] res = new int[vocals.length];

        for (int i = 0; i < vocals.length; i++) {
            count = 0;
            for (int j = 0; j < zeichenkette.length(); j++) {
                letter = zeichenkette.charAt(j);
                if (String.valueOf(letter).equalsIgnoreCase(vocals[i])) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }

    public int zeichenZaehlen(String zeichenkette, char zeichen) {
        int res = 0;
        char letter;

        for (int j = 0; j < zeichenkette.length(); j++) {
            letter = zeichenkette.charAt(j);
            if (letter == zeichen) {
                res++;
            }
        }

        return res;
    }

    public int[] zeichenZaehlenArr(String zeichenkette, char[] zeichenArray) {
        int[] res = new int[zeichenArray.length];
        int count;
        char letter;

        for (int i = 0; i < zeichenArray.length; i++) {
            count = 0;
            for (int j = 0; j < zeichenkette.length(); j++) {
                letter = zeichenkette.charAt(j);
                if (zeichenArray[i] == letter) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }
}
