package uvg.edu.gt;
/**
 * Clase que implementa una calculadora para evaluar expresiones matemáticas en notación postfix.
 */
public class CalculadoraPOSTFIX {

    private MyStack<Integer> pila; // Pila para almacenar operandos durante la evaluación.

    /**
     * Constructor de la calculadora.
     * @param pila La pila a utilizar para almacenar operandos.
     */
    public CalculadoraPOSTFIX(MyStack<Integer> pila) {
        this.pila = pila;
    }

    /**
     * Método para calcular el resultado de una expresión en notación postfix.
     * @param expresion La expresión en notación postfix a evaluar.
     * @return El resultado de la expresión.
     */
    public int calcular(String expresion) {
        String[] elementos = expresion.split(" "); // Dividir la expresión en elementos individuales.

        // Iterar sobre cada elemento de la expresión.
        for (String elemento : elementos) {
            try {
                if (elemento.matches("-?\\d+")) { // Comprueba si es un número.
                    pila.push(Integer.parseInt(elemento)); // Agrega el número a la pila.
                } else { // Si es un operador.
                    if (pila.isEmpty() || pila.size() < 2) { // Verifica si hay suficientes operandos en la pila.
                        throw new IllegalArgumentException("Insuficiente cantidad de operandos para realizar la operación.");
                    }

                    int operandoB = pila.pop();
                    int operandoA = pila.pop();

                    // Realiza la operación correspondiente según el operador.
                    switch (elemento) {
                        case "+":
                            pila.push(operandoA + operandoB);
                            break;
                        case "-":
                            pila.push(operandoA - operandoB);
                            break;
                        case "*":
                            pila.push(operandoA * operandoB);
                            break;
                        case "/":
                            if (operandoB == 0) {
                                throw new ArithmeticException("División entre cero no está permitida.");
                            }
                            pila.push(operandoA / operandoB);
                            break;
                        default:
                            throw new IllegalArgumentException("Operador no reconocido: " + elemento);
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: El elemento \"" + elemento + "\" no puede ser interpretado como operando.");
                return Integer.MIN_VALUE; // Retorna un valor especial para indicar un error.
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                return Integer.MIN_VALUE; // Retorna un valor especial para indicar un error.
            }
        }

        // Verifica si la expresión es válida y si queda exactamente un resultado en la pila.
        if (pila.isEmpty() || pila.size() > 1) {
            System.err.println("Error: La expresión es inválida o incompleta.");
            return Integer.MIN_VALUE; // Retorna un valor especial para indicar un error.
        }

        return pila.pop(); // Retorna el resultado final.
    }
}