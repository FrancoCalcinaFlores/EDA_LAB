package Prob02;
public class TestPila {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        System.out.println("Pila vacía: " + pila.empty());
        System.out.println("Elemento añadido: " + pila.push(1));
        System.out.println("Elemento añadido: " + pila.push(2));
        System.out.println("Elemento añadido: " + pila.push(3));

        System.out.println("Elemento en la parte superior: " + pila.peek());
        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("Elemento en la parte superior después de eliminar: " + pila.peek());
        System.out.println("¿La pila está vacía? " + pila.empty());

        System.out.println("Posición del elemento 1: " + pila.search(1));
        System.out.println("Posición del elemento 5: " + pila.search(5));
    }
}