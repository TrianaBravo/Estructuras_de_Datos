

public class NodoCircular {
    private Object dato; // Dato almacenado en el nodo
    private NodoCircular siguiente; // Referencia al siguiente nodo

    // Constructor
    public NodoCircular(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Getters y Setters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
    
}
