

// Nodo generico para una lista enlazada simple
public class Nodo {
    private Object dato; // Variable para almacenar el dato del nodo
    private Nodo siguiente; // referencia al siguiente nodo

    // Constructor para inicializar el nodo con un dato
    public Nodo(Object dato) {
        this.dato = dato; // Asignar el dato al nodo
        this.siguiente = null; // Inicialmente, el siguiente nodo es nulo
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
    public Nodo getSiguiente() {
        return siguiente; // Retorna la referencia al siguiente nodo
    }

    public void setSiguiente(Nodo n) {
        this.siguiente = n; // Asigna un nuevo nodo como siguiente
    }

}
