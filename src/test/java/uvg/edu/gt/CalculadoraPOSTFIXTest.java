package uvg.edu.gt;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase CalculadoraPOSTFIX.
 */
public class CalculadoraPOSTFIXTest {

    private MyStack<Integer> pila; // Pila para la calculadora.
    private CalculadoraPOSTFIX calculadora; // Instancia de la calculadora postfix.

    /**
     * Método de configuración ejecutado antes de cada método de prueba.
     */
    @Before
    public void setUp() {
        pila = new MyStack<>(); // Inicializa una nueva pila antes de cada prueba.
        calculadora = new CalculadoraPOSTFIX(pila); // Inicializa una nueva calculadora antes de cada prueba.
    }

    /**
     * Prueba para verificar el cálculo de una expresión postfix simple.
     */
    @Test
    public void testCalcularSimple() {
        assertEquals(8, calculadora.calcular("5 3 +"), 0); // Verifica si el resultado es 8.
    }

    /**
     * Prueba para verificar el manejo de errores al tener elementos no numéricos en la expresión.
     */
    @Test
    public void testCalcularConErroresNumericos() {
        assertEquals(Integer.MIN_VALUE, calculadora.calcular("5 x +"), 0); // Verifica si se maneja el error correctamente.
    }

    /**
     * Prueba para verificar el manejo de errores al intentar dividir entre cero.
     */
    @Test
    public void testCalcularConDivisionEntreCero() {
        assertEquals(Integer.MIN_VALUE, calculadora.calcular("4 0 /"), 0); // Verifica si se maneja el error correctamente.
    }

    /**
     * Prueba para verificar el manejo de errores al tener una cantidad insuficiente de operandos.
     */
    @Test
    public void testCalcularConInsuficienteCantidadDeOperandos() {
        assertEquals(Integer.MIN_VALUE, calculadora.calcular("5 +"), 0); // Verifica si se maneja el error correctamente.
    }

    /**
     * Prueba para verificar el manejo de errores al tener una expresión incompleta.
     */
    @Test
    public void testCalcularConExpresionIncompleta() {
        assertEquals(Integer.MIN_VALUE, calculadora.calcular("5 3"), 0); // Verifica si se maneja el error correctamente.
    }
}