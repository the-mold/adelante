public class Spieler {
    public String name;
    public Integer points;

    public Spieler(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.points.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }

        Spieler s = (Spieler) obj;

        return (s.name.equals(this.name) && s.points.equals(this.points));
    }

    public static void main(String[] args) {
        Spieler s1 = new Spieler("a", 1);
        Spieler s2 = new Spieler("a", 1);
        Spieler s3 = new Spieler("sam", 20);

        System.out.println("equals " + s1.equals(s2)); // true
        System.out.println("hashCode s1: " + s1.hashCode());
        System.out.println("hashCode s2: " + s2.hashCode());

        System.out.println("equals " + s1.equals(s3)); // false
        System.out.println("hashCode s1: " + s1.hashCode());
        System.out.println("hashCode s3: " + s3.hashCode());
    }
}
