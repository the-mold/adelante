public class RekursionTest {
    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("Case n = 1");
        Rekursion r1 = new Rekursion();
        System.out.println("Needed iterations: " + r1.TuermeHanoe(1, "A", "B", "C"));

        System.out.println("=====================");
        System.out.println("Case n = 2");
        Rekursion r2 = new Rekursion();
        System.out.println("Needed iterations: " + r2.TuermeHanoe(2, "A", "B", "C"));

        System.out.println("=====================");
        System.out.println("Case n = 3");
        Rekursion r3 = new Rekursion();
        System.out.println("Needed iterations: " + r3.TuermeHanoe(3, "A", "B", "C"));

        System.out.println("=====================");
        System.out.println("Case n = 4");
        Rekursion r4 = new Rekursion();
        System.out.println("Needed iterations: " + r4.TuermeHanoe(4, "A", "B", "C"));

        System.out.println("=====================");
        System.out.println("Case n = 5");
        Rekursion r5 = new Rekursion();
        System.out.println("Needed iterations: " + r5.TuermeHanoe(5, "A", "B", "C"));
    }
}
