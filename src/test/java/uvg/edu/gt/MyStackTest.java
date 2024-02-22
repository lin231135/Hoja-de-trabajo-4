package uvg.edu.gt;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase MyStack.
 */
public class MyStackTest {

    private MyStack<Integer> pila; // Pila de enteros para las pruebas.

    /**
     * Método de configuración ejecutado antes de cada método de prueba.
     */
    @Before
    public void setUp() {
        pila = new MyStack<>(); // Inicializa una nueva pila antes de cada prueba.
    }

    /**
     * Prueba para verificar el funcionamiento correcto de los métodos push y pop.
     */
    @Test
    public void testPushAndPop() {
        pila.push(1); // Agrega el valor 1 a la pila.
        pila.push(2); // Agrega el valor 2 a la pila.
        assertEquals(2, (int) pila.pop()); // Verifica si el valor devuelto es 2.
        assertEquals(1, (int) pila.pop()); // Verifica si el valor devuelto es 1.
        assertTrue(pila.isEmpty()); // Verifica si la pila está vacía después de pop.
    }

    /**
     * Prueba para verificar la excepción lanzada al realizar pop en una pila vacía.
     */
    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyStack() {
        pila.pop(); // Intenta realizar pop en una pila vacía.
    }

    /**
     * Prueba para verificar el método isEmpty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(pila.isEmpty()); // Verifica si la pila está vacía inicialmente.
        pila.push(1); // Agrega un elemento a la pila.
        assertFalse(pila.isEmpty()); // Verifica si la pila está vacía después de push.
        pila.pop(); // Elimina el elemento de la pila.
        assertTrue(pila.isEmpty()); // Verifica si la pila está vacía después de pop.
    }
}