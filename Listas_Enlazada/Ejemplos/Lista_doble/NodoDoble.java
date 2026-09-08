// codigo generico de un nodo de lista doblemente enlazada
public class NodoDoble{
    private Object dato; // Variable para almacenar el dato del nodo
    private NodoDoble siguiente; // referencia al siguiente nodo
    private NodoDoble anterior; // referencia al nodo anterior

    // Constructor para inicializar el nodo con un dato
    public NodoDoble(Object dato) {
        this.dato = dato; // Asignar el dato al nodo
        this.siguiente = null; // Inicialmente, el siguiente nodo es nulo
        this.anterior = null; // Inicialmente, el nodo anterior es nulo
    }

    // Método para obtener el dato del nodo
    public Object getDato() {
        return dato; // Retorna el dato almacenado en el nodo
    }

    // Método para establecer el dato del nodo
    public void setDato(Object dato) {
        this.dato = dato; // Asigna un nuevo valor al dato del nodo
    }

    // Método para obtener el siguiente nodo
    public NodoDoble getSiguiente() {
        return siguiente; // Retorna la referencia al siguiente nodo
    }

    public void setSiguiente(NodoDoble n) {
        this.siguiente = n; // Asigna un nuevo nodo como siguiente
    }

    // Método para obtener el nodo anterior
    public NodoDoble getAnterior() {
        return anterior; // Retorna la referencia al nodo anterior
    }

    public void setAnterior(NodoDoble n) {
        this.anterior = n; // Asigna un nuevo nodo como anterior
    }
}