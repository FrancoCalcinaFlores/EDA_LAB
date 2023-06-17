package Prob03;
import java.util.ArrayList;

public class Cola<E> {
    private ArrayList<E> elementos;

    public Cola() {
        this.elementos = new ArrayList<>();
    }

    public boolean add(E e) {
        return elementos.add(e);
    }

    public boolean offer(E e) {
        return elementos.add(e);
    }

    public E remove() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        } else {
            return elementos.remove(0);
        }
    }

    public E poll() {
        if (elementos.isEmpty()) {
            return null;
        } else {
            return elementos.remove(0);
        }
    }

    public E element() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        } else {
            return elementos.get(0);
        }
    }

    public E peek() {
        if (elementos.isEmpty()) {
            return null;
        } else {
            return elementos.get(0);
        }
    }

    public int size() {
        return elementos.size();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}