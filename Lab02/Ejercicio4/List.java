package Lab02.Ejercicio4;

public class List<T> {
    private Node<T> root;
    public List(){
        this.root= null;
    }
    public Node<T>getRoot(){
        return root;
    }
    public void serRoot(Node<T>root){
        this.root=root;
    }
    
}
