
//codigo de la clase lista_Circular generico

public class lista_Circular {
    private NodoCircular cabeza; // Referencia al primer nodo de la lista
    private NodoCircular cola; // Referencia al último nodo de la lista
    private int tamanio; // Tamaño de la lista

    // Constructor
    public lista_Circular() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    // Método para agregar un nodo al final de la lista
    public void agregarAlFinal(Object dato) {
        NodoCircular nuevoNodo = new NodoCircular(dato);
        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza); // Apunta al primer nodo para formar un círculo
        } else {
            cola.setSiguiente(nuevoNodo); // Enlaza el último nodo al nuevo nodo
            cola = nuevoNodo; // Actualiza la referencia de la cola
            cola.setSiguiente(cabeza); // Apunta al primer nodo para mantener el círculo
        }
        tamanio++;
    }

    // Método para recorrer e imprimir los elementos de la lista
    public void recorrer() {
        if (cabeza == null) { // Si la lista está vacía
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircular actual = cabeza; // Comienza desde el primer nodo
        do {
            System.out.print(actual.getDato() + " -> "); // Imprime el dato del nodo actual
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        } while (actual != cabeza); // Continúa hasta volver al primer nodo
        System.out.println("(vuelve al inicio)"); // Indica que se ha completado el recorrido
    }

    

}
