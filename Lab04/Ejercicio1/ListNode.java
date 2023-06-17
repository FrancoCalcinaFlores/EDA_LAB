package Prob01;

public class ListNode<T> {
    private T value;
    private ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

	public void setValue(T value2) {
		this.value=value2;
		
	}
}