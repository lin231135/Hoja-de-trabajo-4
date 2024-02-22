package uvg.edu.gt;
import java.util.Vector;

public class LeerExpresionVector implements LeerExpresionesInterface{

    // Función para devolver la precedencia de los operadores
    public static int prec(char c) {
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
        return 'L'; // Por defecto, asocia a la izquierda
    }

    // Función principal para convertir una expresión infix a postfix
    static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Vector<Character> stack = new Vector<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Si el carácter escaneado es un operando, agrégalo a la cadena de salida.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c+" ");
            }
            // Si el carácter escaneado es '(', agrégalo al vector.
            else if (c == '(') {
                stack.add(c);
            }
            // Si el carácter escaneado es ')', desapila y agrega a la cadena de salida desde el vector
            // hasta encontrar un '('.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.lastElement() != '(') {
                    result.append(stack.remove(stack.size() - 1)+" ");
                }
                stack.remove(stack.size() - 1); // Eliminar '('
            }
            // Si se escanea un operador
            else {
                while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.lastElement()) ||
                        prec(s.charAt(i)) == prec(stack.lastElement()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result.append(stack.remove(stack.size() - 1)+" ");
                }
                stack.add(c);
            }
        }

        // Desapila todos los elementos restantes del vector
        while (!stack.isEmpty()) {
            result.append(stack.remove(stack.size() - 1));
        }
        return result.toString();
    }

}
