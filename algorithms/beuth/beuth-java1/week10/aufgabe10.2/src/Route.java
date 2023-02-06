import java.util.Random;

/**
 * Class used to get Route.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class Route {

    static private int[][] matrix;
    private static int anzZeilen = 8;
    private static int anzSpalten = 8;
    public static String CITY_AACHEN = "Aachen";
    public static String CITY_BERLIN = "Berlin";
    public static String CITY_CHEMNITZ = "Chemnitz";
    public static String CITY_ERFUHR = "Erfurt";
    public static String CITY_DRESDEN = "Dresden";
    public static String CITY_FRANKFURT = "Frankfurt";
    public static String CITY_HAMBURG = "Hamburg";
    public static String CITY_ESSEN = "Essen";
    private static String[] cityArray = {CITY_AACHEN, CITY_BERLIN, CITY_CHEMNITZ, CITY_ERFUHR, CITY_DRESDEN, CITY_FRANKFURT, CITY_HAMBURG, CITY_ESSEN};

    public Route() {
        init();
    }

    private void init() {
        int distance = 0;
        matrix = new int[anzZeilen][anzSpalten];

        // fill values
        Random generator = new Random();
        for (int i = 0; i < anzZeilen; i++) {
            for (int j = 0; j < anzSpalten; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                    continue;
                }

                distance = generator.nextInt(100);
                matrix[i][j] = distance;
                matrix[j][i] = distance;
            }
        }
    }

    public String routeDerRundReiseBerechnen(String[] reise) throws IllegalArgumentException {
        String res = "";
        Boolean ok;
        int dest1IDX = 0;
        int dest2IDX = 0;
        int totalKM = 0;

        // Validate
        for (int i = 0; i < reise.length; i++) {
            ok = false;
            for (int j = 0; j < cityArray.length; j++) {
                if (reise[i].equals(cityArray[j])) {
                    ok = true;
                }
            }
            if (!ok) {
                throw new IllegalArgumentException("information for the city: " + reise[i] + " is not in db");
            }
        }
        
        // Process
        for (int i = 0; i < reise.length - 1; i++) {
            // situation for the same cities
            if (reise[i] == reise[i + 1]) {
                res = res + String.valueOf(i + 1) + ". You are traveling to the same city where you are. 0 km \n";
                continue;
            }
            
            // find destination 1 and 2 index
            for (int j = 0; j < cityArray.length; j++) {
                if (reise[i] == cityArray[j]) {
                    dest1IDX = j;
                }
                if (reise[i + 1] == cityArray[j]) {
                    dest2IDX = j;
                }
            }
            
            res = res + String.valueOf(i + 1) + ". From " + reise[i] + " to " + reise[i + 1] + " " + matrix[dest1IDX][dest2IDX] + " km\n";
            totalKM = totalKM + matrix[dest1IDX][dest2IDX];
        }

        res = res + "Total distance of the tour: " + totalKM + "km";
        
        return res;
    }
}
