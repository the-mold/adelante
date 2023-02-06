import java.util.*;

public interface IStapel<E> {
    E top() throws EmptyStackException;
    E pop() throws EmptyStackException;
    void push(E el);
}
