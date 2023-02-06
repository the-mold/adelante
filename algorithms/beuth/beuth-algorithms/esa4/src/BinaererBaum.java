public class BinaererBaum<E> {
    protected static class Knoten<T> {
        protected T key;
        protected Knoten<T> p;
        protected Knoten<T> left;
        protected Knoten<T> right;

        Knoten() {
            this.p = null;
            this.key = null;
            this.left = null;
            this.right = null;
        }

        Knoten(T element) {
            this.p = null;
            this.key = element;
            this.left = null;
            this.right = null;
        }
    }

    protected Knoten<E> root;

    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Knoten <E> k) {
        if (k == null) {
            return;
        }
        this.inorder(k.left);
        System.out.println(k.key);
        this.inorder(k.right);
    }

    protected int height() {
        int absoluteHeight = this.getAbsoluteHeight(this.root);

        if (absoluteHeight == 0) {
            return 0;
        }

        // height as defined in script: root is not counted.
        return absoluteHeight - 1;
    }

    private int getAbsoluteHeight(Knoten<E> kn) {
        if (kn == null) {
            return 0;
        }
        int leftHeight = this.getAbsoluteHeight(kn.left);
        int rightHeight = this.getAbsoluteHeight(kn.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }
}
