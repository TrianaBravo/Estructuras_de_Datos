package Colas.Ejemplos.Cola_Dinamica;

public class Cola_Dinamica {
    private Nodo frente; // Referencia al nodo en el frente de la cola
    private Nodo fin; // Referencia al nodo en el final de la cola

    public Cola_Dinamica() {
        this.frente = null; // Inicializa el frente como null (cola vacía)
        this.fin = null; // Inicializa el fin como null (cola vacía)
    }

    public boolean estaVacia() {
        return frente == null; // La cola está vacía si el frente es null
    }

    public void encolar(Nodo nodo) {
        if (estaVacia()) {
            frente = nodo; // Si la cola estaba vacía, el nuevo nodo es el frente
            fin = nodo; // El nuevo nodo también es el fin
        } else {
            fin.setSiguiente(nodo); // Enlaza el nuevo nodo al final de la cola
            fin = nodo; // Actualiza el fin al nuevo nodo
        }
    }

    public Nodo desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede eliminar un nodo.");
            return null;
        }
        Nodo nodoEliminado = frente; // Obtiene el nodo en el frente de la cola
        frente = frente.getSiguiente(); // Actualiza el frente al siguiente nodo
        if (frente == null) {
            fin = null; // Si la cola queda vacía, actualiza el fin a null
        }
        return nodoEliminado; // Retorna el nodo eliminado
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo actual = frente; // Comienza desde el frente de la cola
        while (actual != null) {
            System.out.println(actual.getDato()); // Muestra el dato del nodo actual
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        }
    }
    
    
}
