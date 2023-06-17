package Prob01;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Generar peor caso para ordenamiento de burbuja
        for (int i = 9; i >= 0; i--) {
            list.add(i);
        }

        // Ejecutar algoritmo de ordenamiento en la lista enlazada
        bubbleSort(list);

        // Imprimir la lista ordenada
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void bubbleSort(LinkedList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}