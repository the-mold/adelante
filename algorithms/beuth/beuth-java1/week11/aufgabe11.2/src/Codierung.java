import java.util.Random;

/**
 * Class used to get Codierung.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class Codierung {
    private int rows;
    private int columns;
    private char[][] matrix;

    public Codierung(int zeilen, int spalten) {
        this.rows = zeilen;
        this.columns = spalten;
        matrix = new char[zeilen][spalten];
    }

    public String verschluessleText(String klarText) throws IllegalArgumentException {
        klarText = klarText.replaceAll("\\s+","");
        if (klarText.length() > this.rows * this.columns) {
            throw new IllegalArgumentException("string is bigger than array capacity");
        }

        String res = "";
        Random r = new Random();
        int idx = 0;
        char newChar;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (klarText.length() > idx) {
                    newChar = klarText.charAt(idx);
                } else {
                    newChar = (char)(r.nextInt(26) + 'a');
                }

                this.matrix[i][j] = newChar;
                res = res.concat(String.valueOf(newChar));
                idx++;
            }
            res = res.concat("\n");
        }

        System.out.println("\nMatrix:\n" + res);

        String encodedStr = "";
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                encodedStr = encodedStr.concat(String.valueOf(matrix[j][i]));
            }
        }

        return encodedStr;
    }
}
