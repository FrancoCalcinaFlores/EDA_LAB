package Prob03;

public class TestCola {
	public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
       
        agregarElemento(cola, 1);
        agregarElemento(cola, 2);
        agregarElemento(cola, 3);
        System.out.println("Elemento en el frente de la cola: " + cola.peek());
        System.out.println("Elemento removido de la cola: " + cola.remove());
        System.out.println("¿La cola está vacía? " + cola.isEmpty());   
        System.out.println("Tamaño de la cola: " + cola.size());       
        agregarElemento(cola, 4);
        agregarElemento(cola, 5);
       
        while (!cola.isEmpty()) {
            System.out.println("Elemento eliminado: " + cola.poll());
        }

        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }

    private static void agregarElemento(Cola<Integer> cola, int elemento) {
        cola.add(elemento);
        System.out.println("Elemento agregado a la cola: " + elemento);
        System.out.println("Contenido de la cola: " + cola.toString());
    }
}