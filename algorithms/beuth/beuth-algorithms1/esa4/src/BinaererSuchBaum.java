public class BinaererSuchBaum <E extends Comparable<? super E>> extends BinaererBaum<E>{
    public void insert (E e) {
        insertInner(e);
    }

    public boolean search(E e) {
        return searchInner(e);
    }

    private boolean searchInner(E e) {
        Knoten<E> pointerX = this.root;

        while (pointerX != null) {
            if (pointerX.key == e) {
                return true;
            }

            if (e.compareTo(pointerX.key) < 0) {
                pointerX = pointerX.left;
            } else {
                pointerX = pointerX.right;
            }
        }

        return false;
    }

    private void insertInner(E e) {
        Knoten<E> pointerParent = new Knoten<>();
        Knoten<E> pointerX = this.root;

        while (pointerX != null) {
            pointerParent = pointerX;
            if (e.compareTo(pointerParent.key) < 0) {
                pointerX = pointerX.left;
            } else {
                pointerX = pointerX.right;
            }
        }

        Knoten<E> newLeaf = new Knoten<>(e);

        if (pointerParent.key == null) {
            this.root = newLeaf;
            return;
        }

        if (e.compareTo(pointerParent.key) < 0) {
            pointerParent.left = newLeaf;
        } else {
            pointerParent.right = newLeaf;
        }
    }

    public Knoten maxElement() {
        return this.maxElementInner(this.root);
    }

    private Knoten<E> maxElementInner(Knoten<E> node) {
        if (node.right != null) {
            return maxElementInner(node.right);
        }

        return node;
    }

    public Knoten minElement() {
        return this.minElementInner(this.root);
    }

    private Knoten<E> minElementInner(Knoten<E> node) {
        if (node.left != null) {
            return minElementInner(node.left);
        }

        return node;
    }

    /*
     * minElement with recursion implementation.
     */
    private Knoten<E> minElementRecursion(Knoten<E> node) {
        Knoten<E> res = node;
        if (node.left != null) {
            Knoten<E> left = this.minElementRecursion(node.left);
            if (res.key.compareTo(left.key) > -1) {
                res = left;
            }
        }

        if (node.right != null) {
            Knoten<E> right = this.minElementRecursion(node.right);
            if (res.key.compareTo(right.key) > -1) {
                res = right;
            }
        }

        return res;
    }

    /*
     * maxElement with recursion implementation.
     */
    private Knoten<E> maxElementRecursion(Knoten<E> node) {
        Knoten<E> res = node;
        if (node.left != null) {
            Knoten<E> maxLeft = this.maxElementRecursion(node.left);
            if (res.key.compareTo(maxLeft.key) < 0) {
                res = maxLeft;
            }
        }

        if (node.right != null) {
            Knoten<E> maxRight = this.maxElementRecursion(node.right);
            if (res.key.compareTo(maxRight.key) < 0) {
                res = maxRight;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Frage 4.1=====================");
        BinaererSuchBaum<Integer> tree41 = new BinaererSuchBaum<>();
        tree41.insert(10);
        tree41.insert(9);
        tree41.insert(8);
        tree41.insert(7);
        tree41.insert(6);
        tree41.insert(5);
        tree41.insert(4);
        tree41.insert(3);
        tree41.insert(2);
        tree41.insert(1);
        System.out.println("tree41.search: " + tree41.search(10));
        System.out.println("tree41.search: " + tree41.search(123));
        System.out.println("tree41.height: " + tree41.height());
        System.out.println("tree41.maxElement " + tree41.maxElement().key);
        System.out.println("tree41.minElement " + tree41.minElement().key);

        System.out.println("Frage 4.2=====================");
        BinaererSuchBaum<Integer> tree42 = new BinaererSuchBaum<>();
        tree42.insert(10);
        tree42.insert(8);
        tree42.insert(20);
        tree42.insert(5);
        tree42.insert(9);
        tree42.insert(1);
        tree42.insert(15);
        tree42.insert(25);
        tree42.insert(22);
        tree42.insert(30);
        System.out.println("tree42.search: " + tree42.search(25));
        System.out.println("tree42 height: " + tree42.height());
        System.out.println("tree42.maxElement " + tree42.maxElement().key);
        System.out.println("tree42.minElement " + tree42.minElement().key);
    }
}
