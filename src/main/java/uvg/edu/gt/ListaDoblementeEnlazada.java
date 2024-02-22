package uvg.edu.gt;
import java.util.LinkedList;

public class ListaDoblementeEnlazada {

    // Función para devolver la precedencia de los operadores
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Función para devolver la asociatividad de los operadores
    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Por defecto, asociatividad izquierda
    }

    // Función principal para convertir una expresión infix a postfix
    static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si el caracter escaneado es un operando, agréguelo a la cadena de salida.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c + " ");
            }
            // Si el caracter escaneado es '(', empújelo a la pila.
            else if (c == '(') {
                stack.push(c);
            }
            // Si el caracter escaneado es ')', desapílelo y agréguelo a la cadena de salida
            // hasta encontrar un '('.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop() + " ");
                }
                stack.pop(); // Desapilar '('
            }
            // Si se escanea un operador
            else {
                while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
                        prec(s.charAt(i)) == prec(stack.peek()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result.append(stack.pop() + " ");
                }
                stack.push(c);
            }
        }

        // Desapilar todos los elementos restantes de la pila
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
