/**
 * Class used to practice loops.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 *
 */

public class Geschenkpapier {
    static final String DECORATION_STARS = "**";
    static final String DECORATION_HAPPY = ":-)";
    static final String DECORATION_SAD = ")-:";

    /**
     * simpleWrap prints the same string for certain number of rows and columns.
     *
     * @param decoration
     * @param columns
     * @param rows
     */
    static void simpleWrap(String decoration, int columns, int rows) {
        if (decoration.equals("") || columns == 0 || rows == 0) {
            System.out.println("Please provide valid parameters");
            return;
        }

        int i = 0;
        do {
            for (int j = 0; j < columns; j++) {
                System.out.print(decoration + " ");
            }
            System.out.println();
            i++;
        } while(i < rows);
    }

    /**
     * complexWrap prints two strings interchangeably for certain number of rows and columns.
     *
     * @param decoration1
     * @param decoration2
     * @param columns
     * @param rows
     */
    static void complexWrap(String decoration1, String decoration2, int columns, int rows) {
        if (decoration1.equals("") || decoration2.equals("") || columns == 0 || rows == 0) {
            System.out.println("Please provide valid parameters");
            return;
        }

        int currentRow = 0;
        while (currentRow < rows) {
            String usedDecoration = decoration2;
            if (currentRow % 2 == 0) {
                usedDecoration = decoration1;
            }

            int currentColumn = 0;
            while (currentColumn < columns) {
                System.out.print(usedDecoration + " ");
                currentColumn++;
            }
            System.out.println();

            currentRow++;
        }
    }
}
