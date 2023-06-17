package Prob02;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pila<E> {
    private ArrayList<E> stack;

    public Pila() {
        stack = new ArrayList<>();
    }

    public E push(E item) {
        stack.add(item);
        return item;
    }

    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public int search(Object o) {
        int index = stack.lastIndexOf(o);
        if (index == -1) {
            return -1;
        }
        return stack.size() - index;
    }
}