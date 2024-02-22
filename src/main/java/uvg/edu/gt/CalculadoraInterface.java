package uvg.edu.gt;
/**
 * Interfaz que define el método para calcular el resultado de una expresión matemática.
 */
public interface CalculadoraInterface {

    /**
     * Calcula el resultado de una expresión matemática.
     *
     * @param expresion La expresión matemática a calcular.
     * @return El resultado de la expresión.
     */
    public int calcular(String expresion);
}