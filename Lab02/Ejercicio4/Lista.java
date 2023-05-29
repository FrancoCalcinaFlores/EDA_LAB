package Lab02.Ejercicio4;

public class Lista<T> {
    private Nodo<T> cabeza;
    private int tamaño;


    private class Nodo<E>{
        private E dato;
        private Nodo<E> siguiente;
        public Nodo(E dato){
            this.dato =dato;
            this.siguiente=null;
        }
    }

    public Lista(){
        cabeza=null;
        tamaño=0;
    }
    public int tamaño(){

        return tamaño;
    }
    public boolean Vacia(){
        return tamaño==0;
    }
    public void agregarInicio(T dato){ 
    Nodo<T> nuevoNodo = new Nodo<>(dato);
    if(Vacia()){
        cabeza=nuevoNodo;
    }else{
        nuevoNodo.siguiente=cabeza;
        cabeza = nuevoNodo;
    }
    tamaño++;
    }
    public T obtener(int indice){
        if(indice<0 || indice>= tamaño){
            throw new IndexOutOfBoundsException("indice fuera de rango");
            
        }
        Nodo<T> nodoActual =cabeza;
        for (int i=0;i<indice;i++){
            nodoActual=nodoActual.siguiente;
        }
        return nodoActual.dato;
    }
    public boolean eliminar(T dato){
         if (Vacia()){
        
            return false;
    
        }
    
        if(cabeza.dato.equals(dato)){
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }
        Nodo<T> nodoActual= cabeza;
        while(nodoActual.siguiente !=null){
        if(nodoActual.siguiente.dato.equals(dato)){
            nodoActual.siguiente=nodoActual.siguiente.siguiente;
            tamaño--;
            return true;
        }
        nodoActual = nodoActual.siguiente;
    }
    return false;
}
}
    
    

