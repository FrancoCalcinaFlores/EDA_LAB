package lab05;


import java.util.Stack;

public class CorchetesEquilibrados {

	public static String isBalanced(String s) {
		
        Stack<Character> pila = new Stack<>();
        char[] brackets = s.toCharArray(); //guardamos los caracteres del string en un arreglo

        for (int i= 0; i<brackets.length; i++) {
            if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') {
                pila.push(brackets[i]);  // Si encontramos un corchete de apertura, lo agregamos a la pila
            } else {
                if (pila.isEmpty() || !coincide(pila.pop(), brackets[i])) {
                    return "NO";  // Si encontramos un corchete de cierre sin un corchete de apertura correspondiente o si los corchetes no coinciden, la cadena no está balanceada
                }
            }
        }

        if (pila.isEmpty()) {
            return "SÍ";  // Si la pila está vacía al final, todos los corchetes tienen coincidencias y la cadena está balanceada
        } else {
            return "NO";  // Si quedan corchetes de apertura sin cerrar, la cadena no está balanceada
        }
    }

	//Compara si esta bien
    private static boolean coincide(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
    	
        System.out.println(isBalanced("{[()]}"));  // Devuelve "SÍ"
        System.out.println(isBalanced("[(])"));  // Devuelve "NO"
        System.out.println(isBalanced("[[(())]]"));  // Devuelve "SÍ"
    }
}