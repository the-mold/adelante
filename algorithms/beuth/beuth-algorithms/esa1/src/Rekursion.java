public class Rekursion {

    public int iterationCount = 0;

    public int TuermeHanoe(int n, String a, String b, String c) {
        this.iterationCount++;

        if (n == 1) {
            ZieheScheibe(a, c);
        } else {
            TuermeHanoe(n -1, a, c, b);
            ZieheScheibe(a, c);
            TuermeHanoe(n -1, b, a, c);
        }

        return this.iterationCount;
    }
    static void ZieheScheibe(String x, String z) {
        System.out.println("moved from " + x + " to " + z);
    }
}
