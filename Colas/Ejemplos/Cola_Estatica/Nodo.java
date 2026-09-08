package Colas.Ejemplos.Cola_Estatica;

public class Nodo {
    private Object dato; // Dato que almacena el nodo
    private Nodo siguiente; // Referencia al siguiente nodo 
    
    public Nodo(Object dato) {
        this.dato = dato; // Inicializa el dato del nodo
        this.siguiente = null; // Inicializa la referencia al siguiente nodo como null
    }

    public Object getDato() {
        return dato; // Retorna el dato almacenado en el nodo
    }

    public void setDato(Object dato) {
        this.dato = dato; // Establece un nuevo valor para el dato del nodo
    }

    public Nodo getSiguiente() {
        return siguiente; // Retorna la referencia al siguiente nodo
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente; // Establece la referencia al siguiente nodo
    }
}
