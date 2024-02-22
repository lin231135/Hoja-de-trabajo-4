package uvg.edu.gt;
/**
 * Interfaz que define las operaciones básicas que debe tener una pila genérica.
 *
 * @param <T> Tipo de elementos almacenados en la pila.
 */
public interface StackInterface<T> {

    /**
     * Agrega un elemento a la pila.
     *
     * @param elemento Elemento a ser agregado a la pila.
     */
    public void push(T elemento);

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento eliminado de la parte superior de la pila.
     */
    public T pop();

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean isEmpty();
}