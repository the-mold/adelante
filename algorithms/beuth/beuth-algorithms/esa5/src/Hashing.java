public class Hashing {
    private int constantMultiplier = 31;
    private int hashSymbolCount;
    private int size;

    public Hashing(int hashSymbolCount, int size) {
        this.hashSymbolCount = hashSymbolCount;
        this.size = size;
    }

    public int getHash(String name) {
        int res = 0;

        for (int i = 0; i < hashSymbolCount; i++) {
            char c;
            try {
                c = name.toLowerCase().charAt(i);
            } catch(Exception e) {
                c = ' ';
            }
            res = res + (i != 0 ? constantMultiplier^i : constantMultiplier) * c;
        }

        // find the mod
        return res % size;
    }

    public static void main(String[] args) {
        Hashing h = new Hashing(5, 2000);
        int mikeHash = h.getHash("mike");
        System.out.println("mikeHash " + mikeHash);

        int swansonHash = h.getHash("swanson");
        System.out.println("swansonHash " + swansonHash);
    }
}
