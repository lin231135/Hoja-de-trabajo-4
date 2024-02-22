package uvg.edu.gt;
import java.util.Vector;

/**
 * Clase que implementa una pila genérica utilizando un Vector como estructura de datos subyacente.
 *
 * @param <T> Tipo de elementos almacenados en la pila.
 */
public class MyStack<T> implements StackInterface<T> {

    private Vector<T> elementos; // Vector para almacenar los elementos de la pila.

    /**
     * Constructor de la clase MyStack.
     * Inicializa la estructura de datos subyacente.
     */
    public MyStack() {
        elementos = new Vector<>();
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param elemento Elemento a ser agregado a la pila.
     */
    public void push(T elemento) {
        elementos.add(elemento);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento eliminado de la parte superior de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("El stack está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Obtiene el número de elementos en la pila.
     *
     * @return Número de elementos en la pila.
     */
    public int size() {
        return elementos.size();
    }
}
