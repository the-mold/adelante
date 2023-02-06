import java.util.*;

public class VerketteterStapel<E> implements IStapel<E> {
    private static class Element<T> {
        private T key;
        Element<T> next;

        Element(T e) {
            key = e;
            this.next = null;
        }
        Element(T e, Element<T> next) {
            key = e;
            this.next = next;
        }
    }

    private Element<E> head;

    public VerketteterStapel() {
        head = null;
    }

    public E top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return head.key;
    }

    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        Element<E> temp = this.head;
        this.head = this.head.next;

        return temp.key;
    }

    public void push(E el) {
        this.head = new Element<>(el, this.head);
    }

    private boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    private int length() {
        if (this.isEmpty()) {
            return 0;
        }

        Element<E> item = this.head;
        int res = 1;
        while (item.next != null) {
            item = item.next;
            res++;
        }

        return res;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        StringBuilder res = new StringBuilder();
        Element<E> item = this.head;
        res.append("[" + item.key);

        while (item.next != null) {
            item = item.next;
            res.append(", " + item.key);
        }

        return res.append("]").toString();
    }

    /**
     * equals Methode prüft ob 2 VerketteterStapel Objekte sind gleich.
     * Erstmal wird geprüft, ob es nicht das gleiche Objekt verglichen wird.
     * Zweitens wird getestet, ob Objekt Instanz der Klasse VerketteterStapel ist.
     * Danach werden Längen von den Stapeln verglichen.
     * Endlich wird jeden key in beiden Stapeln verglichen.
     *
     */
    @Override
    public boolean equals(Object o) {
        // 1. the same object is compared
        if (this == o) {
            return true;
        }

        // 2. early exit for compared object has a different type
        if (!(o instanceof VerketteterStapel)) {
            return false;
        }

        // cast type
        VerketteterStapel stack = (VerketteterStapel) o;

        // 3. lists have the same length
        if (this.length() != stack.length()) {
            return false;
        }

        // 4. compare each element
        Element item1 = this.head;
        Element item2 = stack.head;
        if (item1.key != item2.key) {
            return false;
        }
        while (item1.next != null) {
            if (item1.key != item2.key) {
                return false;
            }
            item1 = item1.next;
            item2 = item2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // init stack1
        VerketteterStapel<String> stack1 = new VerketteterStapel<>();
        stack1.push("a");
        stack1.push("b");
        stack1.push("c");
        System.out.println(stack1.toString()); // [c,b,a]
        System.out.println(stack1.top()); // c
        stack1.pop();
        System.out.println(stack1.top()); // b

        // init stack2
        VerketteterStapel<String> stack2 = new VerketteterStapel<>();
        stack2.push("a");
        System.out.println(stack2.equals(stack1)); // false
        stack2.push("b");
        System.out.println(stack2.equals(stack1)); // true
    }
}
