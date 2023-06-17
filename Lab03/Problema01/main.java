package Prob01;
import java.util.*;
import java.util.Stack;
public class main {
    public static int equalStacks(Stack<Integer>[] stacks) {
        int[] suma = new int[stacks.length];
        int[] indice = new int[stacks.length];

        // Calcular las sumas iniciales de cada pila
        for (int i = 0; i < stacks.length; i++) {
            suma[i] = sumStack(stacks[i]);
        }

        while (!allSumsEqual(suma)) {
            int maxSumIndex = getMaxSumIndex(suma);
            int poppedValue = stacks[maxSumIndex].pop();
            suma[maxSumIndex] -= poppedValue;
        }

        return suma[0]; // Todas las sumas son iguales, podemos devolver cualquier valor
    }

    private static int sumStack(Stack<Integer> stack) {
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        return sum;
    }

    private static boolean allSumsEqual(int[] suma) {
        for (int i = 1; i < suma.length; i++) {
            if (suma[i] != suma[0]) {
                return false;
            }
        }
        return true;
    }

    private static int getMaxSumIndex(int[] suma) {
        int maxIndex = 0;
        for (int i = 1; i < suma.length; i++) {
            if (suma[i] > suma[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de pilas: ");
        int numStacks = scanner.nextInt();

        Stack<Integer>[] stacks = new Stack[numStacks];

        // Ingresar los valores de cada pila
        for (int i = 0; i < numStacks; i++) {
            stacks[i] = new Stack<>();

            System.out.print("Ingrese la cantidad de cilindros en la pila " + (i + 1) + ": ");
            int numCylinders = scanner.nextInt();

            System.out.println("Ingrese las alturas de los cilindros (separadas por espacios):");
            for (int j = 0; j < numCylinders; j++) {
                stacks[i].push(scanner.nextInt());
            }
        }

        scanner.close();

        // Invertir el orden de las pilas para procesar primero la pila más alta
        Collections.reverse(Arrays.asList(stacks));

        int maxHeight = equalStacks(stacks);
        System.out.println("Altura máxima: " + maxHeight);
    }
}