package Lab02.Ejercicio4;


public class Node<T> {
 
    private T data;
    private Node<T>nextNode;

    public Node(){
        this.data =null;
        this.nextNode = null;
    }
    public Node(T data){
        this.data=data;
        this.nextNode =null;
    }
    public Node (T data , Node<T> nextNode){
        this.data =data;
        this.nextNode = nextNode;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
    public Node <T> getNextNode(){
        return nextNode;
    }
    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }


    
}
    
