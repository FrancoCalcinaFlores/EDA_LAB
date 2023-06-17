package Prob01;

public class LinkedList<T> {
    private ListNode<T> root;
    private int size;

    public LinkedList() {
        root = null;
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("fuera de los limites");
        }

        ListNode<T> n = root;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }

        return n.getValue();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Fuera de los limites");
        }

        if (index == 0) {
            root = root.getNext();
        } else {
            ListNode<T> previous = getNode(index - 1);
            ListNode<T> current = getNode(index);
            previous.setNext(current.getNext());
        }
        size--;
    }

    private ListNode<T> getNode(int index) {
        ListNode<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }
    public void add(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (root == null) {
            root = newNode;
        } else {
            ListNode<T> n = root;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(newNode);
        }
        size++;
    }
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("fuera de los limites");
        }

        ListNode<T> n = getNode(index);
        n.setValue(value);
    }
    public int size() {
        return size;
    }
    
}

